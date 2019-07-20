package com.hs.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hs.mapper.UserMapper;
import com.hs.model.User;
import com.hs.request.GetUserListRequest;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.UserService;

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
			resultMap.put("data", userList);
			return ResultUtil.success(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("data", userList);
			return ResultUtil.error("查询失败", resultMap);
		}
	}

}

	