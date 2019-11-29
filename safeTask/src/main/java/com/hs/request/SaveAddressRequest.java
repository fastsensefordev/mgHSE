package com.hs.request;
public class SaveAddressRequest {

	private Integer ipType;
	private String ip;
	public Integer getIpType() {
		return ipType;
	}
	public void setIpType(Integer ipType) {
		this.ipType = ipType;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "SaveAddressRequest [ipType=" + ipType + ", ip=" + ip + "]";
	}


}

