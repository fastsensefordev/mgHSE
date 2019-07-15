package com.hs.response;

import java.io.Serializable;
import java.util.Date;

/**
 * 结果集
 */
public class ResultResponse<T> implements Serializable {
	
	private static final long serialVersionUID = -2419546928310043339L;
	
	private Integer code;
	private String msg;
	private T data;
	private Date timestamp = new Date();

	public ResultResponse(ResultEnum resultEnum) {
		this.code = resultEnum.code();
		this.msg = resultEnum.msg();
	}

	public ResultResponse(ResultEnum resultEnum, T data) {
		this.code = resultEnum.code();
		this.msg = resultEnum.msg();
		this.data = data;
	}

	public ResultResponse(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
