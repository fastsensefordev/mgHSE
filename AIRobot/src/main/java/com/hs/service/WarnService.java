package com.hs.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.hs.model.AlarmExcelModel;
import com.hs.request.BatchAlarmsRequest;
import com.hs.request.GetTotalChartRequest;
import com.hs.request.GetWarnListRequest;
import com.hs.response.ResultResponse;

public interface WarnService {

	public ResultResponse dealAlarmById(Integer id);

	public ResultResponse batchAlarms(BatchAlarmsRequest request);

	public ResultResponse getWarnList(GetWarnListRequest request);

	public ResultResponse getAlarmList();

	public ResultResponse getEchartsByAid(String alarmId);

	public ResultResponse getTotalChart(GetTotalChartRequest request);

	public JSONObject getAlarmNameList();

	public List<AlarmExcelModel> getAllWarnList(GetWarnListRequest request, String realPath);

}

	