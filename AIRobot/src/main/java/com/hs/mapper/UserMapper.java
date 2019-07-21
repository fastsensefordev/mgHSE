package com.hs.mapper;

import java.util.List;

import com.hs.model.LoginUserLog;
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
	/**
	 * @desc: 新增用户
	 * @author: kpchen
	 * @createTime: 2019年7月21日 上午9:50:07
	 * @history:
	 * @param request
	 * @return int
	 */
	public int addUser(User user);
	/**
	 * @desc: 更新用户
	 * @author: kpchen
	 * @createTime: 2019年7月21日 上午9:50:07
	 * @history:
	 * @param request
	 * @return int
	 */
	public int updateUser(User user);
	/**
	 * @desc: 用户登录日志记录
	 * @author: kpchen
	 * @createTime: 2019年7月21日 上午10:24:47
	 * @history:
	 * @param log
	 * @return int
	 */
	public int saveLoginLog(LoginUserLog log);
	/**
	 * @desc: 用户登录日志记录
	 * @author: kpchen
	 * @createTime: 2019年7月21日 上午10:24:47
	 * @history:
	 * @param log
	 * @return int
	 */
	public User getUserByNameOrPhone(User user);
	

}
