package com.hs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hs.request.GetUserListRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/ip")
public class IpController {
	
	@ApiOperation(value="获取用户列表", notes="分页获取用户列表")
	@GetMapping("getTable")
	public String getTable(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			GetUserListRequest request) {
		return "{\"code\":0,\"msg\":\"ok\",\"data\":[{\"id\":1,\"name\":\"10.185.32.154\",\"sex\":\"male\",\"pid\":-1},{\"id\":2,\"name\":\"10.52.25.11"
				+ "\",\"sex\":\"male\",\"pid\":1}]}";
	}
}

	