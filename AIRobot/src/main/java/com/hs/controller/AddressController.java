package com.hs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hs.request.GetUserListRequest;
import com.hs.request.SaveAddressRequest;
import com.hs.request.SaveAreaRequest;
import com.hs.request.SaveCameraRequest;
import com.hs.request.UpdateAddressRequest;
import com.hs.response.ResultResponse;
import com.hs.service.AddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	/**
	 * @desc: 获取地址管理
	 * @author: kpchen
	 * @createTime: 2019年7月31日 下午8:20:24
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="获取地址管理", notes="获取地址管理")
	@GetMapping("getAddressList")
	public ResultResponse getAddressList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			GetUserListRequest request) {
		ResultResponse resopnse = addressService.getAddressList();
		return resopnse;
	}
	
	/**
	 * @desc: 保存服务器地址
	 * @author: kpchen
	 * @createTime: 2019年7月31日 下午8:36:01
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="保存服务器地址", notes="保存服务器地址")
	@RequestMapping("saveAddress")
	public ResultResponse saveAddress(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody SaveAddressRequest request) {
		ResultResponse resopnse = addressService.saveAddress(request);
		return resopnse;
	}
	
	/**
	 * 
	 * @desc: 保存摄像头
	 * @author: kpchen
	 * @createTime: 2019年7月31日 下午8:35:53
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="保存摄像头", notes="保存摄像头")
	@RequestMapping("saveCamera")
	public ResultResponse saveCamera(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody SaveCameraRequest request) {
		ResultResponse resopnse = addressService.saveCamera(request);
		return resopnse;
	}
	
	/**
	 * 
	 * @desc: 保存区域
	 * @author: kpchen
	 * @createTime: 2019年7月31日 下午8:35:53
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="保存区域", notes="保存区域")
	@RequestMapping("saveArea")
	public ResultResponse saveArea(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody SaveAreaRequest request) {
		ResultResponse resopnse = addressService.saveArea(request);
		return resopnse;
	}
	
	/**
	 * @desc: 删除地址或摄像头
	 * @author: kpchen
	 * @createTime: 2019年7月29日 下午9:42:52
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param id
	 * @return ResultResponse
	 */
	@ApiOperation(value="删除地址或摄像头", notes="删除地址或摄像头")
	@RequestMapping("deleteAddress")
	public ResultResponse deleteAddress(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			Integer id) {
		ResultResponse resopnse = addressService.deleteAddress(id);
		return resopnse;
	}
	
	
	@ApiOperation(value="更新服务器地址", notes="更新服务器地址")
	@RequestMapping("updateAddress")
	public ResultResponse updateAddress(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody UpdateAddressRequest request) {
		ResultResponse resopnse = addressService.updateAddress(request);
		return resopnse;
	}
}

	