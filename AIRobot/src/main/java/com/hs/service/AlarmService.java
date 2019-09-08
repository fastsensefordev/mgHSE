package com.hs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import com.hs.model.TblAlarmInfo;
import com.hs.util.WebServiceUtil;

@Service
public class AlarmService {
	@Autowired
	private AlarmInfoMapper alarmInfoMapper;
	@Autowired
	private AddressMapper addressMapper;
	
	public void parseData() {
		LocalDate localDate = LocalDate.now();
		String year = String.valueOf(localDate.getYear());
		String month = String.valueOf(localDate.getMonthValue());
		String day = String.valueOf(localDate.getDayOfMonth());
		List<String> serverList = addressMapper.getCalcAddressList();
		for (String serveAddress : serverList) {
			Long idStart = 0L;
			//查询数据
			String result = WebServiceUtil.getRecordList(serveAddress, year, month, day, "ID > " + idStart + " order by ID ASC limit 10");
			List<AlarmInfo> alarmResultList = new ArrayList<AlarmInfo>();
			if (StringUtils.isNoneBlank(result)) {
				alarmResultList = JSON.parseObject(result,new TypeReference<List<AlarmInfo>>(){});
				insert2Data(serveAddress,alarmResultList);//入库处理
			}
			//循环分页查询
			while (CollectionUtils.isNotEmpty(alarmResultList)) {
				idStart = alarmResultList.get(alarmResultList.size()-1).getID();
				result = WebServiceUtil.getRecordList(serveAddress, year, month, day, "ID >" + idStart + " order by ID ASC limit 10");
				if (StringUtils.isNoneBlank(result)) {
					alarmResultList.clear();//清空数据
					alarmResultList = JSON.parseObject(result,new TypeReference<List<AlarmInfo>>(){});
					insert2Data(serveAddress, alarmResultList);//入库处理
				} else {
					alarmResultList.clear();//清空数据
				}
			} 
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

}

	