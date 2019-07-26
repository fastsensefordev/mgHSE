package com.hs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.mapper.UserMapper;
import com.hs.model.User;
import com.hs.request.AddUserRequest;
import com.hs.request.GetUserListRequest;
import com.hs.request.RetrievePasswordRequest;
import com.hs.response.ResultEnum;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.UserService;
import com.hs.util.Constants;
import com.hs.util.PasswordUtils;

/**
 * @desc: 用户管理service
 * @author: kpchen
 * @createTime: 2019年7月20日 下午1:57:37
 * @history:
 * @version: v1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	/**
	  *    获取用户列表
	 */
	@Override
	public ResultResponse getUserList(GetUserListRequest request) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		List<User> userList = new ArrayList<>();
		try {
			PageHelper.startPage(request.getPage(), request.getLimit());
			userList = userMapper.getUserList();
			PageInfo<User> page = new PageInfo<User>(userList);
			resultMap.put("data", page.getList());
			resultMap.put("total", page.getTotal());
			return ResultUtil.success(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("data", userList);
			return ResultUtil.error("查询失败", resultMap);
		}
	}
	/**
	 * 新增用户
	 */
	@Override
	public ResultResponse addUser(AddUserRequest request) {
		try {
			User user = request.getUser();
			String pwd = user.getPassword();
			user.setPassword(PasswordUtils.AESEncode(pwd));//加密
			User existUser = userMapper.getUserByNameOrPhone(user);
			if (null != existUser) {
				return ResultUtil.success(ResultEnum.USER_EXIST);
			}
			userMapper.addUser(request.getUser());
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error();
		}
	}
	/**
	 * 更新用户
	 */
	@Override
	public ResultResponse updateUser(AddUserRequest request) {
		try {
			User user = request.getUser();
			String pwd = user.getPassword();
			user.setPassword(PasswordUtils.AESEncode(pwd));//加密
			userMapper.updateUser(user);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("更新失败");
		}
	}
	/**
	 * 删除用户
	 */
	@Override
	public ResultResponse deleteUser(Integer userId) {
		try {
			User user = new User();
			user.setId(userId);
			user.setStatus(Constants.USER_STATUS_DELETE);
			userMapper.updateUser(user);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("删除失败");
		}
	}
	/**
	 * 找回密码
	 */
	@Override
	public ResultResponse retrievePassword(RetrievePasswordRequest request) {
		try {
			String adminKey = userMapper.getAdminKey(); //获取超级密码
			if (!request.getAdminKey().equals(adminKey)) {
				return ResultUtil.error(ResultEnum.UNAUTHORIZED,"超级密不正确");
			} else {
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("userName", request.getUserName());
				User existUser = userMapper.getUserByFifter(paramMap);
				if (null == existUser) {
					return ResultUtil.error(ResultEnum.UNAUTHORIZED,"该用户不存在");
				} else {
					Map<String, Object> retrieveMap = new HashMap<>();
					retrieveMap.put("userName", request.getUserName());
					retrieveMap.put("password", PasswordUtils.AESEncode(request.getPassword()));
					int affectRows = userMapper.retrievePassword(retrieveMap);
					if (affectRows == 0) {
						return ResultUtil.error(ResultEnum.UNAUTHORIZED,"操作失败，请稍后重试");
					}
				}
			}
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("操作失败");
		}
	}

}

	