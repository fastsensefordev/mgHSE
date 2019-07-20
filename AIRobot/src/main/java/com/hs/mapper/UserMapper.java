package com.hs.mapper;

import java.util.List;

import com.hs.model.User;

public interface UserMapper {

	/**
	 * @description 查询用户列表
	 * @author: kpchen
	 * @createTime: 2019年7月20日 下午3:09:43
	 * @history:
	 * @return List<User>
	 */
	public List<User> getUserList();

}
