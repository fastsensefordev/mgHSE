package com.hs.service;

import com.hs.request.AddUserRequest;
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
	/**
	 * @desc: 新增用户
	 * @author: kpchen
	 * @createTime: 2019年7月21日 上午9:47:23
	 * @history:
	 * @param request
	 * @return ResultResponse
	 */
	public ResultResponse addUser(AddUserRequest request);
	/**
	 * @desc: 更新用户
	 * @author: kpchen
	 * @createTime: 2019年7月21日 上午10:05:49
	 * @history:
	 * @param request
	 * @return ResultResponse
	 */
	public ResultResponse updateUser(AddUserRequest request);
	/**
	 * @desc: 删除用户
	 * @author: kpchen
	 * @createTime: 2019年7月21日 上午10:07:27
	 * @history:
	 * @param userId
	 * @return ResultResponse
	 */
	public ResultResponse deleteUser(Integer userId);

}

	