package com.hs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.WarnService;

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
@RequestMapping("/warn")
public class WarnController {
	
	@Autowired
	private WarnService warnService;
	
	/**
	 * @author: 报警列表
	 * @createTime: 2019年7月20日 下午2:53:50
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="报警列表", notes="报警列表")
	@GetMapping("getWarnList")
	public ResultResponse getWarnList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		return ResultUtil.success();
		
	}
}

