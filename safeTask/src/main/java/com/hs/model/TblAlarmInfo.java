package com.hs.model;

public class TblAlarmInfo {
	
	private Long id;
	/**
	 * 原始id
	 */
	private Long sourceId;
	/**
	 * 报警类型id
	 */
	private Integer alarmId;
	/**
	 * 报警类型
	 */
	private String alarmName;
	/**
	 * 报警图片
	 */
	private String takePic1;
	/**
	 * 报警时间
	 */
	private String alarmTime;
	/**
	 * 服务地址
	 */
	private String server;
	/**
	 * 是否处理
	 */
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
