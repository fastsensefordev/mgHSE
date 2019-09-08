package com.hs.request;

import java.util.List;

import com.hs.util.Constants;

public class GetWarnListRequest {

	private Integer page;
	private Integer limit = Constants.PAGE_SIZE;
	private String alarmName;
	private List<String> alarmList;
	
	public List<String> getAlarmList() {
		return alarmList;
	}
	public void setAlarmList(List<String> alarmList) {
		this.alarmList = alarmList;
	}
	public String getAlarmName() {
		return alarmName;
	}
	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
}

	