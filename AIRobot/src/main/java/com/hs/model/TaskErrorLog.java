package com.hs.model;

public class TaskErrorLog {
	
	private Integer id;
	/**
	 * 错误信息
	 */
	private String info;
	/**
	 * 更新时间
	 */
	private String updateTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
