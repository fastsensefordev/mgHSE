package com.hs.request;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc: AIRobot
 * @author: kpchen
 * @createTime: 2019年7月20日 下午1:38:31
 * @history:
 * @version: v1.0
 */
public class BaseRequest implements Serializable {
	
	private static final long serialVersionUID = -992656467140721566L;
	private Date timestamp = new Date();
	
	public Date getTimestamp() {
	
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
	
		this.timestamp = timestamp;
	}
	
	
}

	