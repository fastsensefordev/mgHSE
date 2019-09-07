package com.hs.model;

import java.text.SimpleDateFormat;
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
	private String AlarmTime;
	/**
	 * 图片1-报警对象图片---****
	 */
	private String TakePic1;
	/**
	 * 名称的英文名
	 */
	private String IvsEventType;
	
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
	public String getAlarmTime() {
		return AlarmTime;
	}
	public void setAlarmTime(String alarmTime) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
		      Date date = sdf1.parse(alarmTime);//拿到Date对象
		      String str = sdf2.format(date);//输出格式：2017-01-22 09:28:33
		      AlarmTime = str;
		  } catch (Exception e) {
		      e.printStackTrace();
		  }
	}
	public String getTakePic1() {
		return TakePic1;
	}
	public void setTakePic1(String takePic1) {
		TakePic1 = takePic1;
	}
	public String getIvsEventType() {
		return IvsEventType;
	}
	public void setIvsEventType(String ivsEventType) {
		IvsEventType = ivsEventType;
	}
	

}
