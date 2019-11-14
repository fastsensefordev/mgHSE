package com.hs.model;

/**
 * @desc: 登录日志
 * @author: kpchen
 * @createTime: 2019年7月21日 上午10:22:39
 * @history:
 * @version: v1.0
 */
public class LoginUserLog {
	
	private Integer id;
	/**
	 * UID
	 */
	private Integer uId;
	/**
	 * 登录时间
	 */
	private String loginTime;
	/**
	 * 访问ip地址
	 */
	private String ip;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "LoginLog [id=" + id + ", uId=" + uId + ", loginTime=" + loginTime + ", ip=" + ip + "]";
	}

}
