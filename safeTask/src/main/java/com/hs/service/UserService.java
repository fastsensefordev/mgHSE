package com.hs.service;

import org.springframework.web.multipart.MultipartFile;

import com.hs.model.User;
import com.hs.request.AddUserRequest;
import com.hs.request.GetUserListRequest;
import com.hs.request.RetrievePasswordRequest;
import com.hs.response.ResultResponse;

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
	/**
	 * @desc: 找回密码
	 * @author: kpchen
	 * @createTime: 2019年7月26日 下午8:56:59
	 * @history:
	 * @param request
	 * @return ResultResponse
	 */
	public ResultResponse retrievePassword(RetrievePasswordRequest request);
	public User getLoginUser();
	public ResultResponse uploadImg(MultipartFile file);
	public ResultResponse getImgCenter();

}

	