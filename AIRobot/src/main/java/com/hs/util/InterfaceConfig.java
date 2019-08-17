package com.hs.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InterfaceConfig {
	
	@Value("${interface.imgServer}")
	private String imgServer;

	public String getImgServer() {
		return imgServer;
	}

	public void setImgServer(String imgServer) {
		this.imgServer = imgServer;
	}
	
	
}

