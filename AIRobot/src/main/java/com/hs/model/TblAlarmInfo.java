package com.hs.model;

public class TblAlarmInfo {
	
	private Long id;
	private Long alarmId;
	private String alarmName;
	private String takePic1;
	private String alarmTime;
	private String server;
	

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(Long alarmId) {
		this.alarmId = alarmId;
	}

	public String getAlarmName() {
		return alarmName;
	}

	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}

	public String getTakePic1() {
		return takePic1;
	}

	public void setTakePic1(String takePic1) {
		this.takePic1 = takePic1;
	}

	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}

}
