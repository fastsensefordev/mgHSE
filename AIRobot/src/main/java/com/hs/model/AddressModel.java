package com.hs.model;

/**
 * @desc: 地址管理
 * @author: kpchen
 * @createTime: 2019年7月31日 下午8:13:34
 * @history:
 * @version: v1.0
 */
public class AddressModel {

	private Integer id;
	/**
	 * 类型（0 :通用算法服务器 、1 :人脸识别算法服务器 、2 :其他）
	 */
	private Integer ipType;
	/**
	 * 类型字符串展现
	 */
	private String ipTypeStr;
	/**
	 * IP地址
	 */
	private String ip;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 创建者
	 */
	private String createUser;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 父Id
	 */
	private Integer pid;
	/**
	 * 状态（0未删除,1删除）
	 */
	private Integer status;
	/**
	 * 摄像头id
	 */
	private String cameraId;
	/**
	 * 摄像头位置
	 */
	private String location;
	/**
	 * 层级级别 1 2 3
	 */
	private Integer level;
	/**
	 * 类别：服务器、区域、摄像头
	 */
	private String levelStr;
	/**
	 * 区域
	 */
	private String area;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIpType() {
		return ipType;
	}

	public void setIpType(Integer ipType) {
		this.ipType = ipType;
	}

	public String getIpTypeStr() {
		return ipTypeStr;
	}

	public void setIpTypeStr(String ipTypeStr) {
		this.ipTypeStr = ipTypeStr;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCameraId() {
		return cameraId;
	}

	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getLevelStr() {
		return levelStr;
	}

	public void setLevelStr(String levelStr) {
		this.levelStr = levelStr;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "AddressModel [id=" + id + ", ipType=" + ipType + ", ipTypeStr=" + ipTypeStr + ", ip=" + ip + ", userId="
				+ userId + ", createUser=" + createUser + ", createTime=" + createTime + ", pid=" + pid + ", status="
				+ status + ", cameraId=" + cameraId + ", location=" + location + ", level=" + level + ", levelStr="
				+ levelStr + ", area=" + area + "]";
	}

}
