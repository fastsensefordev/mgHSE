package com.hs.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.mapper.UserMapper;
import com.hs.model.User;
import com.hs.request.LoginRequest;
import com.hs.response.ResultEnum;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.LoginService;
import com.hs.util.Constants;
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
		user.setJobId(request.getUserName());
		user.setPhone(request.getUserName());
		String password = PasswordUtils.AESEncode(request.getPassword());
		try {
			User existUser = userMapper.getUserByJobIdOrWxId(user);
			if (null != existUser && password.equals(existUser.getPassword())) {
				SessionUtils.setAttribute(Constants.DOMAIN_NAME, existUser.getJobId());
				SessionUtils.setAttribute(Constants.USER_NAME, existUser.getName());
				SessionUtils.setAttribute(Constants.LOGIN_ROLE, existUser.getRoleKey());
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
