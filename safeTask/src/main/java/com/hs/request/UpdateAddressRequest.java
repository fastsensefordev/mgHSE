package com.hs.request;

public class UpdateAddressRequest {
	
	private String ip;
	private String area;
	private String cameraId;
	private String location;
	private Integer id;
	private String audioId;//音响ID
	private String audioLocation;//音响位置

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
}
