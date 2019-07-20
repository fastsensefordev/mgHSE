package com.hs.model;

/**
 * @desc: 用户实体
 * @author: kpchen
 * @createTime: 2019年7月20日 下午3:01:53
 * @history:
 * @version: v1.0
 */
public class User {
	
	private Integer id;//主键
	private String userName;//用户名
	private String password;//密码
	private Integer userType;//类型
	private String userTypeStr;//类型字符串
	private String createTime;//创建时间
	private String lastLoginTime;//最后更新时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getUserTypeStr() {
		return userTypeStr;
	}

	public void setUserTypeStr(String userTypeStr) {
		this.userTypeStr = userTypeStr;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", userType=" + userType
				+ ", userTypeStr=" + userTypeStr + ", createTime=" + createTime + ", lastLoginTime=" + lastLoginTime
				+ "]";
	}

	
}
