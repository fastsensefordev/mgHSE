package com.hs.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("AlarmExcelModel")
public class AlarmExcelModel {

	@Excel(name = "报警名称" ,orderNum = "0", width=16)
	private String alarmName;
	@Excel(name = "报警地址" ,orderNum = "1", width=24)
	private String server;
	@Excel(name = "图片" ,orderNum = "2", width=80)
	private String takePic1;
	@Excel(name = "报警时间" ,orderNum = "3", width=20)
	private String alarmTime;
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
	
	
}

	