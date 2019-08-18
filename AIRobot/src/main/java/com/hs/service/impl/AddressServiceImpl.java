package com.hs.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.mapper.AddressMapper;
import com.hs.model.AddressModel;
import com.hs.model.User;
import com.hs.request.SaveAddressRequest;
import com.hs.request.SaveAreaRequest;
import com.hs.request.SaveCameraRequest;
import com.hs.request.UpdateAddressRequest;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.AddressService;
import com.hs.service.UserService;
import com.hs.util.Constants;
import com.hs.util.SessionUtils;
@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private UserService userService;
	/**
	 * 获取地址管理
	 */
	@Override
	public ResultResponse getAddressList() {
		try {
			List<AddressModel> models = addressMapper.getAddressList();
			Map<String, Object> data = new LinkedHashMap<String, Object>();
			data.put("data", models);
			return ResultUtil.success(data);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("查询失败");
		}
			
	}
	/**
	 * @desc 保存服务器地址
	 */
	@Override
	public ResultResponse saveAddress(SaveAddressRequest request) {
		try {
			String loginUser = SessionUtils.getLoginUser();
			User existUser = userService.getLoginUser();
			AddressModel addressModel = new AddressModel();
			addressModel.setCreateUser(loginUser);
			addressModel.setUserId(existUser.getId());
			addressModel.setIp(request.getIp());
			addressModel.setIpType(request.getIpType());
			addressModel.setLevel(Constants.INT_1);
			addressModel.setStatus(Constants.ADDRESS_STATUS_DEFAULT);
			addressModel.setPid(Constants.INT_0);
			addressMapper.saveAddress(addressModel);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("保存失败");
		}
			
	}
	/**
	 * @desc 保存摄像
	 */
	@Override
	public ResultResponse saveCamera(SaveCameraRequest request) {
		try {
			String loginUser = SessionUtils.getLoginUser();
			User existUser = userService.getLoginUser();
			AddressModel addressModel = new AddressModel();
			addressModel.setCreateUser(loginUser);
			addressModel.setUserId(existUser.getId());
			addressModel.setCameraId(request.getCameraId());
			addressModel.setLocation(request.getLocation());
			addressModel.setLevel(Constants.INT_3);
			addressModel.setPid(request.getPid());
			addressModel.setStatus(Constants.TEMPLATE_STATUS_DEFAULT);
			addressModel.setIpType(Constants.INT_0);
			addressMapper.saveAddress(addressModel);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("保存失败");
		}
	}
	
	/**
	 * @desc 保存区域
	 */
	@Override
	public ResultResponse saveArea(SaveAreaRequest request) {
		try {
			String loginUser = SessionUtils.getLoginUser();
			User existUser = userService.getLoginUser();
			AddressModel addressModel = new AddressModel();
			addressModel.setCreateUser(loginUser);
			addressModel.setUserId(existUser.getId());
			addressModel.setArea(request.getArea());
			addressModel.setLevel(Constants.INT_2);
			addressModel.setPid(request.getPid());
			addressModel.setStatus(Constants.TEMPLATE_STATUS_DEFAULT);
			addressModel.setIpType(Constants.INT_0);
			addressMapper.saveAddress(addressModel);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("保存失败");
		}
	}
	
	/**
	 * @desc 删除地址或摄像头
	 */
	@Override
	public ResultResponse deleteAddress(Integer id) {
		try {
			addressMapper.deleteAddress(id);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("删除失败");
		}
	}
	/**
	 * @desc 更新服务器地址
	 */
	@Override
	public ResultResponse updateAddress(UpdateAddressRequest request) {
		try {
			addressMapper.updateAddress(request);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("更新失败");
		}
	}


}

	