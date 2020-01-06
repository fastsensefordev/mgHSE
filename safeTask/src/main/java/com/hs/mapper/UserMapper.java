package com.hs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	 * @desc: 获取超级密码
	 * @author: kpchen
	 * @createTime: 2019年7月26日 下午8:58:45
	 * @history:
	 * @return String
	 */
	public String getAdminKey();
	
	/**
	 * @desc: 修改密码
	 * @author: kpchen
	 * @createTime: 2019年7月26日 下午9:12:47
	 * @history:
	 * @param retrieveMap void
	 */
	public int retrievePassword(Map<String, Object> retrieveMap);
	public String getImgCenter();
	public Integer clearConfig();
	public int saveConfig(@Param("config") String config);
	public int deleteUser(User user);
	
	//新
	public User getUserByJobIdOrWxId(User user);
	public User getUserByJobId(User user);
	

}
