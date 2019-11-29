package com.hs.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hs.request.LoginRequest;
import com.hs.response.ResultEnum;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @desc: 登录
 * @author: kpchen
 * @createTime: 2019年7月20日 下午1:25:36
 * @history:
 * @version: v1.0
 */
@Api
@RestController
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	/**
	 * @desc: 登录
	 * @author: kpchen
	 * @createTime: 2019年7月27日 上午10:23:43
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="登录", notes="登录")
	@PostMapping("loginBy")
	public ResultResponse loginBy(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			LoginRequest request) {
		if (StringUtils.isEmpty(request.getUserName())) {
			return ResultUtil.error(ResultEnum.VALUE_EMPTY, "账号不能为空");
		}
		if (StringUtils.isEmpty(request.getPassword())) {
			return ResultUtil.error(ResultEnum.VALUE_EMPTY, "密码不能为空");
		}
		ResultResponse resopnse = loginService.login(request,httpServletRequest);
		return resopnse;
		
	}
	
	/**
	 * @desc: 退出登录
	 * @author: kpchen
	 * @createTime: 2019年7月27日 上午10:25:24
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException void
	 */
	@ApiOperation(value="退出登录", notes="退出登录")
	@GetMapping("logoff")
	public void logoff(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
		HttpSession session = httpServletRequest.getSession();
		session.invalidate();
		httpServletResponse.sendRedirect("login");
	}
}

	