package com.hs.request;
public class SaveCameraRequest {

	private String location;//摄像头位置
	private String cameraId;//摄像头ID（通道号）
	private Integer pid;//服务器ID
	private String audioId;//音响ID
	private String audioLocation;//音响位置
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCameraId() {
		return cameraId;
	}
	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
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
		return "SaveCameraRequest [location=" + location + ", cameraId=" + cameraId + ", pid=" + pid + ", audioId="
				+ audioId + ", audioLocation=" + audioLocation + "]";
	}

}

