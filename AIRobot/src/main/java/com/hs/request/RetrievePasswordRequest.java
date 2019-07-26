package com.hs.request;
/**
 * @desc: 找回密码
 * @author: kpchen
 * @createTime: 2019年7月26日 下午8:54:39
 * @history:
 * @version: v1.0
 */
public class RetrievePasswordRequest extends BaseRequest {

	private static final long serialVersionUID = 3697325167868038435L;
	private String userName;
	private String adminKey;//找回密码公钥
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAdminKey() {
		return adminKey;
	}
	public void setAdminKey(String adminKey) {
		this.adminKey = adminKey;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RetrievePasswordRequest [userName=" + userName + ", adminKey=" + adminKey + ", password=" + password
				+ "]";
	}
	
}

	