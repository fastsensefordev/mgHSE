package com.hs.response;

import java.util.Map;

/**
 * 结果集返回
 *
 */
public class ResultUtil {

	/**
	 *  成功
	 */
	public static  ResultResponse success() {
		return new ResultResponse(ResultEnum.SUCCESS);
	}
	
	/**
	 * @createTime: 2019年7月15日 下午8:50:14
	 * @history:
	 * @param data
	 * @return ResultResponse
	 */
	public static  ResultResponse success(Map<String, Object> data) {
		return new ResultResponse(ResultEnum.SUCCESS, data);
	}

	public static  ResultResponse success(ResultEnum resultEnum) {
		return new ResultResponse(resultEnum);
	}

	public static  ResultResponse success(ResultEnum resultEnum, Map<String, Object> data) {
		ResultResponse result = new ResultResponse(resultEnum, data);
		return result;
	}

	public static  ResultResponse success(String msg, Map<String, Object> data) {
		ResultResponse result = new ResultResponse(ResultEnum.SUCCESS.code(), msg, data);
		return result;
	}
	
	public static  ResultResponse error() {
		return new ResultResponse(ResultEnum.SERVER_ERRO);
	}

	public static  ResultResponse error(String msg) {
		ResultResponse result = new ResultResponse(ResultEnum.SERVER_ERRO);
		result.setMsg(msg);
		return result;
	}
	
	public static ResultResponse error(String msg, Map<String, Object> data) {
		ResultResponse result = new ResultResponse(ResultEnum.SERVER_ERRO);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	public static  ResultResponse error(ResultEnum resultEnum) {
		ResultResponse result = new ResultResponse(resultEnum);
		return result;
	}

	public static  ResultResponse error(ResultEnum resultEnum, String msg) {
		ResultResponse result = new ResultResponse(resultEnum);
		result.setMsg(msg);
		return result;
	}
}
