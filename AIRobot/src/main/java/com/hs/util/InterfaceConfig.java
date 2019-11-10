package com.hs.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InterfaceConfig {

	@Value("${interface.imgServer}")
	private String imgServer;
	@Value("${interface.serverName}")
	private String serverName;
	@Value("${interface.calcImgServer}")
	private String calcImgServer;

	public String getImgServer() {
		return imgServer;
	}

	public void setImgServer(String imgServer) {
		this.imgServer = imgServer;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getCalcImgServer() {
		return calcImgServer;
	}

	public void setCalcImgServer(String calcImgServer) {
		this.calcImgServer = calcImgServer;
	}

}
