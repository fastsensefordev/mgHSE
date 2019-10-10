package com.hs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hs.mapper.AddressMapper;
import com.hs.mapper.AlarmInfoMapper;
import com.hs.model.AlarmInfo;
import com.hs.model.AlarmType;
import com.hs.model.TaskErrorLog;
import com.hs.model.TblAlarmInfo;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.util.WebServiceUtil;

@Service
public class AlarmService {
	@Autowired
	private AlarmInfoMapper alarmInfoMapper;
	@Autowired
	private AddressMapper addressMapper;
	
	public ResultResponse parseData() {
		LocalDate nowDate = LocalDate.now();
    	LocalDate localDate = nowDate.minusDays(1);//前一天数据
		try {
			String year = String.valueOf(localDate.getYear());
			String month = String.valueOf(localDate.getMonthValue());
			String day = String.valueOf(localDate.getDayOfMonth());
			alarmInfoMapper.dealAlarmsByDate(localDate.toString());
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
			alarmInfoMapper.deleteErrorLog(localDate.toString());//删除当天异常日志记录
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			TaskErrorLog errorLog = new TaskErrorLog();
			errorLog.setInfo(localDate.toString() + " 定时任务数据包抓取处理失败，请及时处理~");
			errorLog.setUpdateTime(localDate.toString());
			alarmInfoMapper.saveErrorLog(errorLog);
			return ResultUtil.error();
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
			e.printStackTrace();
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
			e.printStackTrace();
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

}

	