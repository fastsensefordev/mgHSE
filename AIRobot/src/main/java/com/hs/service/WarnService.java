package com.hs.service;

import com.hs.request.BatchAlarmsRequest;
import com.hs.request.GetWarnListRequest;
import com.hs.response.ResultResponse;

public interface WarnService {

	public ResultResponse dealAlarmById(Integer id);

	public ResultResponse batchAlarms(BatchAlarmsRequest request);

	public ResultResponse getWarnList(GetWarnListRequest request);

	public ResultResponse getAlarmList();

}

	