package com.hs.response;

/**
 * 结果集返回
 *
 */
public class ResultUtil {

	/**
	 *  成功
	 */
	public static <T> ResultResponse<T> success() {
		return new ResultResponse<T>(ResultEnum.SUCCESS);
	}
	
	/**
	 * @createTime: 2019年7月15日 下午8:50:14
	 * @history:
	 * @param data
	 * @return ResultResponse<T>
	 */
	public static <T> ResultResponse<T> success(T data) {
		return new ResultResponse<T>(ResultEnum.SUCCESS, data);
	}

	public static <T> ResultResponse<T> success(ResultEnum resultEnum) {
		return new ResultResponse<T>(resultEnum);
	}

	public static <T> ResultResponse<T> success(ResultEnum resultEnum, T data) {
		ResultResponse<T> result = new ResultResponse<T>(resultEnum, data);
		return result;
	}

	public static <T> ResultResponse<T> success(String msg, T data) {
		ResultResponse<T> result = new ResultResponse<T>(ResultEnum.SUCCESS.code(), msg, data);
		return result;
	}
	
	public static <T> ResultResponse<T> error() {
		return new ResultResponse<T>(ResultEnum.SERVER_ERRO);
	}

	public static <T> ResultResponse<T> error(String msg) {
		ResultResponse<T> result = new ResultResponse<T>(ResultEnum.SERVER_ERRO);
		result.setMsg(msg);
		return result;
	}

	public static <T> ResultResponse<T> error(ResultEnum resultEnum) {
		ResultResponse<T> result = new ResultResponse<T>(resultEnum);
		return result;
	}

	public static <T> ResultResponse<T> error(ResultEnum resultEnum, String msg) {
		ResultResponse<T> result = new ResultResponse<T>(resultEnum);
		result.setMsg(msg);
		return result;
	}
}
