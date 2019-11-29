package com.hs.model;

/**
 * @desc: 音箱管理
 * @author: dt
 * @createTime: 2019年11月12日 下午5:13:22
 * @history:
 * @version: v1.0
 */
public class AudioModel {
	private Integer id;
	private String musicName;
	private String musicPath;
	private String alarmEn;
	private String alarmName;
	
	//扩展
	private String serverAndHost;
	private String audioId;
	private String location;
	
	
	
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
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getMusicPath() {
		return musicPath;
	}
	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}
	public String getAlarmEn() {
		return alarmEn;
	}
	public void setAlarmEn(String alarmEn) {
		this.alarmEn = alarmEn;
	}
	public String getAlarmName() {
		return alarmName;
	}
	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}
	
	public String getServerAndHost() {
		return serverAndHost;
	}
	public void setServerAndHost(String serverAndHost) {
		this.serverAndHost = serverAndHost;
	}
	public String getAudioId() {
		return audioId;
	}
	public void setAudioId(String audioId) {
		this.audioId = audioId;
	}
	@Override
	public String toString() {
		return "AudioModel [id=" + id + ", musicName=" + musicName + ", musicPath=" + musicPath + ", alarmEn=" + alarmEn
				+ ", alarmName=" + alarmName + ", serverAndHost=" + serverAndHost + ", audioId=" + audioId + "]";
	}
	
	

}
