package com.hs.request;

import java.util.List;

import com.hs.util.Constants;

public class GetWarnListRequest {

	private Integer page;
	private Integer limit = Constants.PAGE_SIZE;
	private String alarmName;
	private List<String> alarmList;
	private String date;
	private String start;
	private String end;
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
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

	