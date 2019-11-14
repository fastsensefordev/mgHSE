package com.hs.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.hs.util.SpringUtil;
import com.hs.util.WebServiceUtil;

@Service
@DependsOn("springUtil")
public class AlarmService {
	private final Logger logger = LoggerFactory.getLogger(AlarmService.class);
	public static Map<String,AudioModel> ipVoiceMap;
	public static Map<String,AudioModel> alarmMusicMap;
	@Autowired
	private AlarmInfoMapper alarmInfoMapper;
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private static AddressMapper addressIpMapper;

    static {
    	addressIpMapper=SpringUtil.getBean(AddressMapper.class);
    	ipVoiceMap();
    	alarmMusicMap();
    	initVoice();
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
	 */
	private void insert2Data(String server, List<AlarmInfo> alarmResultList) {
		TblAlarmInfo alarmInfo = null;
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
			alarmInfo.setAlarmTime(model.getAlarmTime());
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
					broadcastVoice(serveAddress,alarmResultList);
				}
				//循环分页查询
				while (CollectionUtils.isNotEmpty(alarmResultList)) {
					idStart = alarmResultList.get(alarmResultList.size() - 1).getID();
					alarmInfoMapper.saveLastTaskId(serveAddress, idStart, dateStr);//保存本次的任务id
					result = WebServiceUtil.getRecordList(serveAddress, year, month, day,
							"ID >" + idStart + " order by ID ASC limit 10");
					if (StringUtils.isNoneBlank(result)) {
						alarmResultList.clear();//清空数据
						alarmResultList = JSON.parseObject(result, new TypeReference<List<AlarmInfo>>() {
						});
						//todo
						insert2Data(serveAddress, alarmResultList);//入库处理
						broadcastVoice(serveAddress,alarmResultList);
					} else {
						alarmResultList.clear();//清空数据
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				alarmInfoMapper.saveLastTaskId(serveAddress,idStart,dateStr);
			}
		} 
	}

	private void broadcastVoice(String serveAddress, List<AlarmInfo> alarmResultList) throws Exception {
		String key=null;
		String audioId=null;
		AudioModel model=null;
		String musicPath=null;
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long timeNow= new Date().getTime(); 
		long timeAlarm=0L;
		logger.info("【本次获取报警数目】"+alarmResultList.size());
		for(AlarmInfo info:alarmResultList){
			key=serveAddress+"+"+info.getIvsHostId();
			model=ipVoiceMap.get(key);
			audioId=model.getAudioId();
			musicPath=(null!=alarmMusicMap.get(info.getIvsEventType()))?alarmMusicMap.get(info.getIvsEventType()).getMusicPath():null;
			timeAlarm=inputFormat.parse(info.getAlarmTime()).getTime();
			System.out.println(timeAlarm-timeNow);
			if(null!=musicPath&&null!=audioId&&timeNow-timeAlarm<12000){
				OpsApi.init(audioId,musicPath);
				CLibrary.INSTANCE._SDK_Install_StartTask(OpsApi.dwID);
				logger.info("【任务播放成功】");
				Thread.sleep(5000);
			}
		}
		
	}

}

