package com.hs.model;

import java.util.Date;

public class AlarmInfo {
	/**
	 * ID ***
	 */
	private Long ID;
	/**
	 * 报警事件名称,算法名称
	 */
	private String AlarmName;
	/**
	 * 报警时间
	 */
	private Date AlarmTime;
	/**
	 * 图片1-报警对象图片---****
	 */
	private String TakePic1;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getAlarmName() {
		return AlarmName;
	}
	public void setAlarmName(String alarmName) {
		AlarmName = alarmName;
	}
	public Date getAlarmTime() {
		return AlarmTime;
	}
	public void setAlarmTime(Date alarmTime) {
		AlarmTime = alarmTime;
	}
	public String getTakePic1() {
		return TakePic1;
	}
	public void setTakePic1(String takePic1) {
		TakePic1 = takePic1;
	}


}
