package com.hs.request;
public class SaveCameraRequest {

	private String location;
	private String cameraId;
	private Integer pid;
	
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
	@Override
	public String toString() {
		return "SaveCameraRequest [location=" + location + ", cameraId=" + cameraId + ", pid=" + pid + "]";
	}

}

