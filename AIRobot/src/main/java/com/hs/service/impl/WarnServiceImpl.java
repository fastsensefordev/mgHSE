package com.hs.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.mapper.AlarmInfoMapper;
import com.hs.model.TblAlarmInfo;
import com.hs.model.TotalCalcInfo;
import com.hs.model.TotalInfo;
import com.hs.request.BatchAlarmsRequest;
import com.hs.request.GetTotalChartRequest;
import com.hs.request.GetWarnListRequest;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.WarnService;
import com.hs.util.DateCalcUtils;
@Service
public class WarnServiceImpl implements WarnService {
	
	@Autowired
	private AlarmInfoMapper alarmInfoMapper;
	/**
	 * @desc 处理告警
	 */
	@Override
	public ResultResponse dealAlarmById(Integer id) {
		try {
			alarmInfoMapper.dealAlarmById(id);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("操作失败");
		}
			
	}
	/**
	 * @desc 批量删除告警数据
	 */
	@Override
	public ResultResponse batchAlarms(BatchAlarmsRequest request) {
		try {
			List<Integer> idList = request.getIdList();
			if (!CollectionUtils.isEmpty(idList)) {
				alarmInfoMapper.batchAlarms(idList);
			}
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("批量删除失败");
		}
			
	}
	@Override
	public ResultResponse getWarnList(GetWarnListRequest request) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		List<TblAlarmInfo> list = new ArrayList<TblAlarmInfo>();
		try {
			String alarmName = request.getAlarmName();
			//查询条件不为空的时候 设置alarm
			if (StringUtils.isNoneBlank(alarmName)) {
				String[] alarmStrs = alarmName.split(",");
				List<String> alarmList = Arrays.asList(alarmStrs);
				request.setAlarmList(alarmList);
			}
			PageHelper.startPage(request.getPage(), request.getLimit());
			list = alarmInfoMapper.getWarnList(request);
			PageInfo<TblAlarmInfo> page = new PageInfo<TblAlarmInfo>(list);
			resultMap.put("data", page.getList());
			resultMap.put("total", page.getTotal());
			return ResultUtil.success(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("data", list);
			return ResultUtil.error("查询失败", resultMap);
		}
			
	}
	/**
	 * @desc 获取报警名称列表
	 */
	@Override
	public ResultResponse getAlarmList() {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		List<TblAlarmInfo> list = new ArrayList<TblAlarmInfo>();
		try {
			list = alarmInfoMapper.getAlarmList();
			resultMap.put("list", list);
			return ResultUtil.success(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("data", list);
			return ResultUtil.error("查询失败", resultMap);
		}
			
	}
	
	/**
	 * @desc 获取报警名称列表
	 */
	@Override
	public JSONObject getAlarmNameList() {
		JSONObject jsonObject = new JSONObject();
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		List<TblAlarmInfo> list = new ArrayList<TblAlarmInfo>();
		try {
			list = alarmInfoMapper.getAlarmList();
			Map<String, String> resultMap = null;
			for (TblAlarmInfo tblAlarmInfo : list) {
				resultMap = new HashMap<String, String>();
				resultMap.put("key", tblAlarmInfo.getAlarmName());
				resultMap.put("value", tblAlarmInfo.getAlarmName());
				resultList.add(resultMap);
			}
			jsonObject.put("data", resultList);
			return jsonObject;
		} catch (Exception e) {
			e.printStackTrace();
			return jsonObject;
		}
	}
	@Override
	public ResultResponse getEchartsByAid(String alarmId) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		List<TotalInfo> resultList = new ArrayList<TotalInfo>();
		try {
			List<TotalInfo> infos = alarmInfoMapper.getEchartsByAid(alarmId);
			Map<String, TotalInfo> infoMap = infos.parallelStream().collect(Collectors.toMap(TotalInfo::getTime, a -> a,(k1,k2)->k1));
			List<String> pastDaysList = DateCalcUtils.getPastDaysList(7);
			
			int maxCount = 0;
			int countNum = 0;
			for (String date : pastDaysList) {
				TotalInfo info = new TotalInfo();
				Integer count = 0;
				if (infoMap.containsKey(date)) {
					count = infoMap.get(date).getCount();
				}
				info.setTime(date.substring(date.length() - 5, date.length()));
				info.setCount(count);
				resultList.add(info);
				if (maxCount < count) {
					maxCount = count;
				}
				countNum += count;
			}
			resultMap.put("data", resultList);
			resultMap.put("maxCount", maxCount + 10);
			resultMap.put("countNum", countNum);
			return ResultUtil.success(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("data", resultList);
			return ResultUtil.error("查询失败", resultMap);
		}
	}
	@Override
	public ResultResponse getTotalChart(GetTotalChartRequest request) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		List<TotalCalcInfo> resultList = new ArrayList<TotalCalcInfo>();
		try {
			String alarmIds = request.getAlarmIds();
			if (StringUtils.isNoneBlank(alarmIds)) {
				String[] ids = alarmIds.split(",");
				List<String> idList= new ArrayList<>(Arrays.asList(ids));
				List<TotalCalcInfo> calcInfos = alarmInfoMapper.getTotalChart(idList);
				
				Map<String, TotalCalcInfo> alarmMap = calcInfos.parallelStream().collect(Collectors.toMap(TotalCalcInfo::getAlarmId, alarmIndo -> alarmIndo));
				List<TblAlarmInfo> alarmList = alarmInfoMapper.getAlarmList();
				
				Map<Integer, String> alarmListMap = alarmList.parallelStream().collect(Collectors.toMap(TblAlarmInfo::getAlarmId, TblAlarmInfo::getAlarmName));
				
				for (String alarmId : idList) {
					TotalCalcInfo info = new TotalCalcInfo();
					Integer count = 0;
					String alarmName = "";
					if (alarmMap.containsKey(alarmId)) {
						count = alarmMap.get(alarmId).getCount();
						alarmName = alarmListMap.get(Integer.parseInt(alarmId));
					}
					info.setCount(count);
					info.setAlarmId(alarmId);
					info.setAlarmName(alarmName);
					resultList.add(info);
				}
			}
			resultMap.put("data", resultList);
			return ResultUtil.success(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("data", resultList);
			return ResultUtil.error("查询失败", resultMap);
		}
	}

}

	