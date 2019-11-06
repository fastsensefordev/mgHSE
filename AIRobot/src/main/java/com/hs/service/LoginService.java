package com.hs.service;

import javax.servlet.http.HttpServletRequest;

import com.hs.request.LoginRequest;
import com.hs.response.ResultResponse;

public interface LoginService {

	public ResultResponse login(LoginRequest request,HttpServletRequest httpServletRequest);

}

	