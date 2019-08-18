package com.hs.model;

import java.util.Date;

public class AlarmInfo {
	/**
	 * ID ***
	 */
	private long ID;
	/**
	 * 报警事件名称,算法名称
	 */
	private String AlarmName;
	//报警发生产视频源名称(一般为摄像机名称)
	private String SourceName;
	/**
	 * 报警时间
	 */
	private Date AlarmTime;
	//停止报警时间
	private Date StopAlarmTime;
	//源Id
	private int IvsHostId;
	//规则区域序号
	private int RuleIndex;
	//布控区域序号ID
	private int AreaIndex;
	//Ivs事件类型
	private String IvsEventType;
	/**
	 * 图片1-报警对象图片---****
	 */
	private String TakePic1;
	//图片2-报警开始全景图片
	private String TakePic2;
	//图片3-报警停止全景图片
	private String TakePic3;
	//录像文件路径
	private String RecFilePath;
	private boolean IsExistVehicle;
	//规则类型
	private String RuleType;
	//报警级别
	private int AlarmLevel;
	//车辆号牌
	private String VehiclePlate;
	//车辆型号
	private String VehicleModel;
	//对象颜色
	private String ObjColor;
	//对象信息
	private String ObjInfo;
	//对象类型
	private String ObjType;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getAlarmName() {
		return AlarmName;
	}

	public void setAlarmName(String alarmName) {
		AlarmName = alarmName;
	}

	public String getSourceName() {
		return SourceName;
	}

	public void setSourceName(String sourceName) {
		SourceName = sourceName;
	}

	public Date getAlarmTime() {
		return AlarmTime;
	}

	public void setAlarmTime(Date alarmTime) {
		AlarmTime = alarmTime;
	}

	public Date getStopAlarmTime() {
		return StopAlarmTime;
	}

	public void setStopAlarmTime(Date stopAlarmTime) {
		StopAlarmTime = stopAlarmTime;
	}

	public int getIvsHostId() {
		return IvsHostId;
	}

	public void setIvsHostId(int ivsHostId) {
		IvsHostId = ivsHostId;
	}

	public int getRuleIndex() {
		return RuleIndex;
	}

	public void setRuleIndex(int ruleIndex) {
		RuleIndex = ruleIndex;
	}

	public int getAreaIndex() {
		return AreaIndex;
	}

	public void setAreaIndex(int areaIndex) {
		AreaIndex = areaIndex;
	}

	public String getIvsEventType() {
		return IvsEventType;
	}

	public void setIvsEventType(String ivsEventType) {
		IvsEventType = ivsEventType;
	}

	public String getTakePic1() {
		return TakePic1;
	}

	public void setTakePic1(String takePic1) {
		TakePic1 = takePic1;
	}

	public String getTakePic2() {
		return TakePic2;
	}

	public void setTakePic2(String takePic2) {
		TakePic2 = takePic2;
	}

	public String getTakePic3() {
		return TakePic3;
	}

	public void setTakePic3(String takePic3) {
		TakePic3 = takePic3;
	}

	public String getRecFilePath() {
		return RecFilePath;
	}

	public void setRecFilePath(String recFilePath) {
		RecFilePath = recFilePath;
	}

	public boolean isIsExistVehicle() {
		return IsExistVehicle;
	}

	public void setIsExistVehicle(boolean isExistVehicle) {
		IsExistVehicle = isExistVehicle;
	}

	public String getRuleType() {
		return RuleType;
	}

	public void setRuleType(String ruleType) {
		RuleType = ruleType;
	}

	public int getAlarmLevel() {
		return AlarmLevel;
	}

	public void setAlarmLevel(int alarmLevel) {
		AlarmLevel = alarmLevel;
	}

	public String getVehiclePlate() {
		return VehiclePlate;
	}

	public void setVehiclePlate(String vehiclePlate) {
		VehiclePlate = vehiclePlate;
	}

	public String getVehicleModel() {
		return VehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		VehicleModel = vehicleModel;
	}

	public String getObjColor() {
		return ObjColor;
	}

	public void setObjColor(String objColor) {
		ObjColor = objColor;
	}

	public String getObjInfo() {
		return ObjInfo;
	}

	public void setObjInfo(String objInfo) {
		ObjInfo = objInfo;
	}

	public String getObjType() {
		return ObjType;
	}

	public void setObjType(String objType) {
		ObjType = objType;
	}

}
