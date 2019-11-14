package com.hs.model;

public class TblAlarmInfo {
	
	private Long id;
	private Long sourceId;//原始id
	private Integer alarmId;
	private String alarmName;
	private String takePic1;
	private String alarmTime;
	private String server;
	private Integer isDelete;
	/**
	 * 通道号
	 */
	private String ivsHostId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	public Integer getAlarmId() {
		return alarmId;
	}
	public void setAlarmId(Integer alarmId) {
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
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getIvsHostId() {
		return ivsHostId;
	}
	public void setIvsHostId(String ivsHostId) {
		this.ivsHostId = ivsHostId;
	}
	
	
	
}
