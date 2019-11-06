package com.hs.service.impl;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.mapper.UserMapper;
import com.hs.model.LoginUserLog;
import com.hs.model.User;
import com.hs.request.LoginRequest;
import com.hs.response.ResultEnum;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.LoginService;
import com.hs.util.Constants;
import com.hs.util.IpUtil;
import com.hs.util.PasswordUtils;
import com.hs.util.SessionUtils;

@Service
public class LoginServiceImpl implements LoginService {

	private final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	private UserMapper userMapper;

	/**
	 * 登录验证
	 */
	@Override
	public ResultResponse login(LoginRequest request,HttpServletRequest httpServletRequest) {

		User user = new User();
		user.setUserName(request.getUserName());
		user.setPhone(request.getUserName());
		String password = PasswordUtils.AESEncode(request.getPassword());
		try {
			User existUser = userMapper.getUserByNameOrPhone(user);
			if (null != existUser && password.equals(existUser.getPassword())) {
				SessionUtils.setAttribute(Constants.DOMAIN_NAME, existUser.getUserName());
				SessionUtils.setAttribute(Constants.LOGIN_ROLE, existUser.getUserType());
				
				User updateUser = new User();
				updateUser.setId(existUser.getId());
				LocalDateTime lastLoginTime = LocalDateTime.now();
				updateUser.setLastLoginTime(lastLoginTime.toString());
				userMapper.updateUser(updateUser);
				//登录记录
				LoginUserLog log = new LoginUserLog();
				log.setuId(existUser.getId());
				log.setIp(IpUtil.getIpAddr(httpServletRequest));
				userMapper.saveLoginLog(log);
				return ResultUtil.error(ResultEnum.SUCCESS, "登录成功");
			} else {
				return ResultUtil.error(ResultEnum.UNAUTHORIZED, "用户名或密码错误");
			}
		} catch (Exception e) {
			logger.error("LoginServiceImpl.login Error:", e);
			return ResultUtil.error(ResultEnum.UNAUTHORIZED, "服务器异常，请联系运维人员");
		}
	}

}
