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
	private Integer ipType;
	private String ipTypeStr;
	private String ip;
	private Integer userId;
	private String createUser;
	private String createTime;
	private Integer pid;
	private Integer status;
	private String cameraId;
	private String location;
	private Integer level;
	private String levelStr;
	private String area;
	private String audioId;//音响ID
	private String audioLocation;//音响位置

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
	
	

	public String getAudioId() {
		return audioId;
	}

	public void setAudioId(String audioId) {
		this.audioId = audioId;
	}

	public String getAudioLocation() {
		return audioLocation;
	}

	public void setAudioLocation(String audioLocation) {
		this.audioLocation = audioLocation;
	}

	@Override
	public String toString() {
		return "AddressModel [id=" + id + ", ipType=" + ipType + ", ipTypeStr=" + ipTypeStr + ", ip=" + ip + ", userId="
				+ userId + ", createUser=" + createUser + ", createTime=" + createTime + ", pid=" + pid + ", status="
				+ status + ", cameraId=" + cameraId + ", location=" + location + ", level=" + level + ", levelStr="
				+ levelStr + ", area=" + area + ", audioId=" + audioId + ", audioLocation=" + audioLocation + "]";
	}

}
