package com.hs.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.opssdk.jni.CLibrary;
import com.example.opssdk.jni.OpsApi;
import com.hs.mapper.AddressMapper;
import com.hs.mapper.AlarmInfoMapper;
import com.hs.model.AlarmInfo;
import com.hs.model.AlarmType;
import com.hs.model.AudioModel;
import com.hs.model.TaskErrorLog;
import com.hs.model.TblAlarmInfo;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.util.DateCalcUtils;
import com.hs.util.InterfaceConfig;
import com.hs.util.SpringUtil;
import com.hs.util.WebServiceUtil;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;


@Service
@DependsOn("springUtil")
public class AlarmService {
	private final Logger logger = LoggerFactory.getLogger(AlarmService.class);
	public static Map<String,AudioModel> ipVoiceMap;
	public static Map<String,AudioModel> cameraLocationMap;
	public static Map<String,AudioModel> alarmMusicMap;
	@Autowired
	private AlarmInfoMapper alarmInfoMapper;
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private static AddressMapper addressIpMapper;
	@Autowired
	private InterfaceConfig interfaceConfig;
    static {
    	addressIpMapper=SpringUtil.getBean(AddressMapper.class);
//    	ipVoiceMap();
//    	alarmMusicMap();
//    	cameraLocationMap();
//    	initVoice();
    }
    /**
     * 初始化音箱配置信息
     */
	public static void ipVoiceMap(){
		if(MapUtils.isEmpty(ipVoiceMap)){
			ipVoiceMap=addressIpMapper.getIpVoiceMap();
		}
	}
	/**
	 * 初始化报警音乐配置信息
	 */
	public static void alarmMusicMap(){
		if(MapUtils.isEmpty(alarmMusicMap)){
			alarmMusicMap=addressIpMapper.getAlarmMusicMap();
		}
	}
	
	/**
	 * 初始化摄像头位置配置信息
	 */
	public static void cameraLocationMap(){
		if(MapUtils.isEmpty(cameraLocationMap)){
			cameraLocationMap=addressIpMapper.getCameraLocationMap();
		}
	}

	/**
	 * 初始化音箱
	 */
	public static void initVoice(){
		if (!CLibrary.INSTANCE._SDK_Install_InitDll())
         {
             throw new RuntimeException("初始化sdk失败");
         }
         if (!CLibrary.INSTANCE._SDK_Install_InitNetworkManager(12680,0))
         {
             throw new RuntimeException("初始化网络失败");
         }
	}
	public void parseData() {
		LocalDate nowDate = LocalDate.now();
		LocalDate localDate = nowDate.minusDays(1);//前一天数据
		String lastDate = alarmInfoMapper.getLastTaskDate();//获取上次最后更新日期
		String date = lastDate;
		if (date == null) {
			date = localDate.toString();
		}
		List<String> dateList = DateCalcUtils.getDateList(date, localDate.toString());
		try {
			for (String dateStr : dateList) {
				if (lastDate != null && lastDate != dateStr) {
					alarmInfoMapper.saveTaskDate(dateStr);//保存本次跑的日期
				}
				String dateArrs[] = dateStr.split("-");
				String year = dateArrs[0];
				String month = dateArrs[1];
				String day = dateArrs[2];
				alarmInfoMapper.dealAlarmsByDate(dateStr);
				List<String> serverList = addressMapper.getCalcAddressList();
				for (String serveAddress : serverList) {
					Long idStart = 0L;
					//查询数据
					String result = WebServiceUtil.getRecordList(serveAddress, year, month, day,
							"ID > " + idStart + " order by ID ASC limit 10");
					List<AlarmInfo> alarmResultList = new ArrayList<AlarmInfo>();
					if (StringUtils.isNoneBlank(result)) {
						alarmResultList = JSON.parseObject(result, new TypeReference<List<AlarmInfo>>() {
						});
						insert2Data(serveAddress, alarmResultList);//入库处理
					}
					//循环分页查询
					while (CollectionUtils.isNotEmpty(alarmResultList)) {
						idStart = alarmResultList.get(alarmResultList.size() - 1).getID();
						result = WebServiceUtil.getRecordList(serveAddress, year, month, day,
								"ID >" + idStart + " order by ID ASC limit 10");
						if (StringUtils.isNoneBlank(result)) {
							alarmResultList.clear();//清空数据
							alarmResultList = JSON.parseObject(result, new TypeReference<List<AlarmInfo>>() {
							});
							insert2Data(serveAddress, alarmResultList);//入库处理
						} else {
							alarmResultList.clear();//清空数据
						}
					}
				} 
				alarmInfoMapper.deleteTaskDate(dateStr);
			}
			alarmInfoMapper.deleteErrorLog(nowDate.toString());//删除当天异常日志记录
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("parseData:", e);
			TaskErrorLog errorLog = new TaskErrorLog();
			errorLog.setInfo(nowDate.toString() + " 定时任务数据包抓取处理失败，请及时处理~");
			errorLog.setUpdateTime(nowDate.toString());
			alarmInfoMapper.saveErrorLog(errorLog);
		}
	}

	/**
	 * @desc: 处理数据并插入数据库
	 * @author: kpchen
	 * @createTime: 2019年9月7日 下午12:22:45
	 * @history:
	 * @param server
	 * @param alarmResultList void
	 * @throws ParseException 
	 */
	private void insert2Data(String server, List<AlarmInfo> alarmResultList) throws ParseException {
		TblAlarmInfo alarmInfo = null;
		String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
		String tempTime=null;
		List<TblAlarmInfo> alarmList = new ArrayList<>();//待入库报警集合
		for (AlarmInfo model : alarmResultList) {
			alarmInfo = new TblAlarmInfo();
			String ivsEventType = model.getIvsEventType();
			String alarmName = model.getAlarmName();
			AlarmType alarmType = alarmInfoMapper.getAlarmType(ivsEventType);
			if (alarmType == null) {
				AlarmType saveAlarmModel = new AlarmType();
				saveAlarmModel.setAlarmName(alarmName);
				saveAlarmModel.setAlarmNameEn(ivsEventType);
				alarmInfoMapper.saveAlarmType(saveAlarmModel);
				alarmInfo.setAlarmId(saveAlarmModel.getId());
			} else {
				alarmInfo.setAlarmId(alarmType.getId());
			}
			alarmInfo.setSourceId(model.getID());
			alarmInfo.setAlarmName(alarmName);
//			alarmInfo.setAlarmTime(model.getAlarmTime());
			tempTime=model.getTakePic1().split("_")[2];
			tempTime=tempTime.substring(0,tempTime.length()-4);
			tempTime=tempTime.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
			alarmInfo.setAlarmTime(tempTime);
			alarmInfo.setTakePic1(model.getTakePic1());
			alarmInfo.setServer(server);
			alarmInfo.setIvsHostId(model.getIvsHostId());
			alarmList.add(alarmInfo);
		}
		alarmInfoMapper.batchSaveAlarmInfo(alarmList);
	}

	/**
	 * @desc: 获取今天的定时任务是否有异常
	 * @author: kpchen
	 * @createTime: 2019年9月15日 下午7:14:34
	 * @history:
	 * @return ResultResponse
	 */
	public ResultResponse getErrorLog() {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		try {
			LocalDate nowDate = LocalDate.now();
			LocalDate localDate = nowDate.minusDays(1);//前一天数据
			String infos = alarmInfoMapper.getErrorLog(localDate.toString());
			resultMap.put("data", infos);
			return ResultUtil.success(resultMap);
		} catch (Exception e) {
			logger.error("getErrorLog:", e);
			return ResultUtil.error("查询失败", resultMap);
		}
	}

	/**
	 * @desc: deleteErrorLog
	 * @author: kpchen
	 * @createTime: 2019年9月15日 下午7:43:53
	 * @history:
	 * @return ResultResponse
	 */
	public ResultResponse deleteErrorLog() {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		try {
			LocalDate nowDate = LocalDate.now();
			LocalDate localDate = nowDate.minusDays(1);//前一天数据
			alarmInfoMapper.deleteErrorLog(localDate.toString());
			return ResultUtil.success(resultMap);
		} catch (Exception e) {
			logger.error("deleteErrorLog:", e);
			return ResultUtil.error("删除定时任务日志失败", resultMap);
		}

	}
	
	public ResultResponse parseDataSomeday(String date) {
		String[] days = date.split("-");
		try {
			String year = days[0];
			String month = days[1];
			String day = days[2];
			alarmInfoMapper.dealAlarmsByDate(day);
			List<String> serverList = addressMapper.getCalcAddressList();
			for (String serveAddress : serverList) {
				Long idStart = 0L;
				//查询数据
				String result = WebServiceUtil.getRecordList(serveAddress, year, month, day,
						"ID > " + idStart + " order by ID ASC limit 10");
				List<AlarmInfo> alarmResultList = new ArrayList<AlarmInfo>();
				if (StringUtils.isNoneBlank(result)) {
					alarmResultList = JSON.parseObject(result, new TypeReference<List<AlarmInfo>>() {
					});
					insert2Data(serveAddress, alarmResultList);//入库处理
				}
				//循环分页查询
				while (CollectionUtils.isNotEmpty(alarmResultList)) {
					idStart = alarmResultList.get(alarmResultList.size() - 1).getID();
					result = WebServiceUtil.getRecordList(serveAddress, year, month, day,
							"ID >" + idStart + " order by ID ASC limit 10");
					if (StringUtils.isNoneBlank(result)) {
						alarmResultList.clear();//清空数据
						alarmResultList = JSON.parseObject(result, new TypeReference<List<AlarmInfo>>() {
						});
						insert2Data(serveAddress, alarmResultList);//入库处理
					} else {
						alarmResultList.clear();//清空数据
					}
				}
			} 
			alarmInfoMapper.deleteErrorLog(date);//删除当天异常日志记录
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			TaskErrorLog errorLog = new TaskErrorLog();
			errorLog.setInfo(date + " 定时任务数据包抓取处理失败，请及时处理~");
			errorLog.setUpdateTime(date);
			alarmInfoMapper.saveErrorLog(errorLog);
			return ResultUtil.error();
		}
	}

	public void realTimeTask() {
		LocalDate nowDate = LocalDate.now();
		LocalDate localDate = nowDate.minusDays(0);//前一天数据
		String dateStr = localDate.toString();
		String dateArrs[] = dateStr.split("-");
		String year = dateArrs[0];
		String month = dateArrs[1];
		String day = dateArrs[2];
		List<String> serverList = addressMapper.getCalcAddressList();
		for (String serveAddress : serverList) {
			Long idStart = 0L;
			try {
				Long lastId = alarmInfoMapper.getTaskLastId(serveAddress, dateStr);
				if (lastId != null) { //取上一次ID
					idStart = lastId;
				}
				//查询数据
				String result = WebServiceUtil.getRecordList(serveAddress, year, month, day,
						"ID > " + idStart + " order by ID ASC limit 10");
				List<AlarmInfo> alarmResultList = new ArrayList<AlarmInfo>();
				if (StringUtils.isNoneBlank(result)) {
					alarmResultList = JSON.parseObject(result, new TypeReference<List<AlarmInfo>>() {
					});
					insert2Data(serveAddress, alarmResultList);//入库处理
					dashboardConsumer(serveAddress, alarmResultList);
					broadcastVoice(serveAddress,alarmResultList);
				}
				//循环分页查询
				while (CollectionUtils.isNotEmpty(alarmResultList)) {
					idStart = alarmResultList.get(alarmResultList.size() - 1).getID();
					result = WebServiceUtil.getRecordList(serveAddress, year, month, day,
							"ID >" + idStart + " order by ID ASC limit 10");
					if (StringUtils.isNoneBlank(result)) {
						alarmResultList.clear();//清空数据
						alarmResultList = JSON.parseObject(result, new TypeReference<List<AlarmInfo>>() {
						});
						insert2Data(serveAddress, alarmResultList);//入库处理
						dashboardConsumer(serveAddress, alarmResultList);
						broadcastVoice(serveAddress,alarmResultList);
					} else {
						alarmResultList.clear();//清空数据
					}
					alarmInfoMapper.saveLastTaskId(serveAddress, idStart, dateStr);//保存本次的任务id
				}
			} catch (Exception e) {
				e.printStackTrace();
				alarmInfoMapper.saveLastTaskId(serveAddress,idStart,dateStr);
			}
		} 
	}
	
	//消息系统后端代码
	private void dashboardConsumer(String serveAddress, List<AlarmInfo> alarmResultList) throws JMSException, ParseException {
		//1、创建工厂连接对象，需要制定ip和端口号
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(interfaceConfig.getAmqUrl());
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Destination dest = session.createTopic("dashboard");
        //6、使用会话对象创建生产者对象
        MessageProducer producer = session.createProducer(dest);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String timeTemp=null;
        long timeNow= 0L; 
        long timeAlarm=0L;
        String key=null;
        AudioModel model=null;
        String location="";
        for(AlarmInfo info:alarmResultList){
        	if(MapUtils.isNotEmpty(cameraLocationMap)){
        		key=serveAddress+"+"+info.getIvsHostId();
        		model=cameraLocationMap.get(key);
        		location=model.getLocation()==null?"":model.getLocation();
        	}
        	timeNow= new Date().getTime(); 
        	timeTemp=info.getTakePic1().split("_")[2];
        	timeTemp=timeTemp.substring(0,timeTemp.length()-4);
        	timeAlarm=inputFormat.parse(timeTemp).getTime();
        	if((timeNow-timeAlarm)<12000){//两秒前的数据
            	String msg=info.getAlarmName()+"报警,位置："+location;
            	//7、使用会话对象创建一个消息对象
            	TextMessage textMessage = session.createTextMessage(msg);
    	        //8、发送消息
    	        producer.send(textMessage);
        	}
        }
        //9、关闭资源
        producer.close();
        session.close();
        connection.close();
	}
	

	

	private void broadcastVoice(String serveAddress, List<AlarmInfo> alarmResultList) throws Exception {
		String key=null;
		String audioId=null;
		AudioModel model=null;
		String musicPath=null;
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		long timeNow= 0L; 
		long timeAlarm=0L;
		logger.info("【本次获取报警数目】"+alarmResultList.size());
		for(AlarmInfo info:alarmResultList){
			timeNow= new Date().getTime(); 
			key=serveAddress+"+"+info.getIvsHostId();
			model=ipVoiceMap.get(key);
			audioId=model.getAudioId();
			musicPath=(null!=alarmMusicMap.get(info.getIvsEventType()))?alarmMusicMap.get(info.getIvsEventType()).getMusicPath():null;
//			timeAlarm=inputFormat.parse(info.getAlarmTime()).getTime();
			timeAlarm=inputFormat.parse(info.getTakePic1().split("_")[2].substring(0,info.getTakePic1().split("_")[2].length()-4)).getTime();
			logger.info("当前时间"+new Date());
			logger.info("报警时间"+info.getAlarmTime());//报警时间有误差
			logger.info("图片时间"+info.getTakePic1().split("_")[2].substring(0,info.getTakePic1().split("_")[2].length()-4));
			System.out.println(timeAlarm-timeNow);
			if(null!=musicPath&&null!=audioId
					&&(timeNow-timeAlarm)<12000
					){//两秒之后的信息不再报警
				OpsApi.init(audioId,musicPath);
				CLibrary.INSTANCE._SDK_Install_StartTask(OpsApi.dwID);
				logger.info("【任务播放成功】");
				Thread.sleep(5000);
			}
		}
	}

}

