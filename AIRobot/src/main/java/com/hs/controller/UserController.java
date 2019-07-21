package com.hs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hs.model.User;
import com.hs.request.AddUserRequest;
import com.hs.request.GetUserListRequest;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * @desc: 用户管理
 * @author: kpchen
 * @createTime: 2019年7月20日 下午1:25:36
 * @history:
 * @version: v1.0
 */
@Api
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * @author: 获取用户列表
	 * @createTime: 2019年7月20日 下午2:53:50
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="获取用户列表", notes="分页获取用户列表")
	@GetMapping("getUserList")
	public ResultResponse getUserList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			GetUserListRequest request) {
		ResultResponse resopnse = userService.getUserList(request);
		return resopnse;
		
	}
	/**
	 * @desc: 新增用户
	 * @author: kpchen
	 * @createTime: 2019年7月21日 上午9:45:03
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="新增用户")
	@RequestMapping("addUser")
	public ResultResponse addUser(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody AddUserRequest request) {
		User user = request.getUser();
		String phone = user.getPhone();
		String userName = user.getUserName();
		String password = user.getPassword();
		Integer type = user.getUserType();
		if (StringUtils.isBlank(phone)) {
			return ResultUtil.error("手机号不能为空");
		}
		if (StringUtils.isBlank(userName)) {
			return ResultUtil.error("账号不能为空");
		}
		if (StringUtils.isBlank(password)) {
			return ResultUtil.error("密码不能为空");
		}
		if (null == type) {
			return ResultUtil.error("账户类型有误，请选择后操作");
		}
		ResultResponse resopnse = userService.addUser(request);
		return resopnse;
	}
	
	
	/**
	 * @desc: 删除用户
	 * @author: kpchen
	 * @createTime: 2019年7月21日 上午9:45:03
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="删除用户")
	@RequestMapping("deleteUser")
	public ResultResponse deleteUser(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			Integer userId) {
		ResultResponse resopnse = userService.deleteUser(userId);
		return resopnse;
	}
	
	
	/**
	 * @desc: 更新用户
	 * @author: kpchen
	 * @createTime: 2019年7月21日 上午9:45:03
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="更新用户")
	@RequestMapping("updateUser")
	public ResultResponse updateUser(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			AddUserRequest request) {
		User user = request.getUser();
		String phone = user.getPhone();
		String userName = user.getUserName();
		String password = user.getPassword();
		if (StringUtils.isBlank(phone)) {
			return ResultUtil.error("手机号不能为空");
		}
		if (StringUtils.isBlank(userName)) {
			return ResultUtil.error("账号不能为空");
		}
		if (StringUtils.isBlank(password)) {
			return ResultUtil.error("密码不能为空");
		}
		ResultResponse resopnse = userService.updateUser(request);
		return resopnse;
	}
}

