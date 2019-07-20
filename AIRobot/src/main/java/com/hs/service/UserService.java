package com.hs.service;

import com.hs.request.GetUserListRequest;
import com.hs.response.ResultResponse;

/**
 * @desc: 用户管理接口
 * @author: kpchen
 * @createTime: 2019年7月20日 下午1:56:47
 * @history:
 * @version: v1.0
 */
public interface UserService {
	
	/**
	 * @desc: 获取用户列表
	 * @author: kpchen
	 * @createTime: 2019年7月20日 下午3:16:10
	 * @history:
	 * @param request
	 * @return ResultResponse
	 */
	public ResultResponse getUserList(GetUserListRequest request);

}

	