package com.hs.model;
/**
 * @desc: 报警类型
 * @author: kpchen
 * @createTime: 2019年11月13日 下午9:31:47
 * @history:
 * @version: v1.0
 */
public class AlarmType {

	private Integer id;
	/**
	 * 算法类型（名称 唯一的）
	 */
	private String alarmNameEn;
	/**
	 * 算法类型
	 */
	private String alarmName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlarmNameEn() {
		return alarmNameEn;
	}

	public void setAlarmNameEn(String alarmNameEn) {
		this.alarmNameEn = alarmNameEn;
	}

	public String getAlarmName() {
		return alarmName;
	}

	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}

}
