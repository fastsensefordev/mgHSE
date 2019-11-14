package com.hs.model;

public class TotalCalcInfo {
	/**
	 * 报警名称
	 */
	private String alarmName;
	/**
	 * 报警算法id
	 */
	private String alarmId;
	/**
	 * 统计值
	 */
	private Integer count;

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getAlarmName() {
		return alarmName;
	}

	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}

}
