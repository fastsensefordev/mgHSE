package com.hs.service;

import com.hs.request.SaveAddressRequest;
import com.hs.request.SaveAreaRequest;
import com.hs.request.SaveCameraRequest;
import com.hs.request.UpdateAddressRequest;
import com.hs.response.ResultResponse;

public interface AddressService {
	/**
	 * @desc: 获取地址管理
	 * @author: kpchen
	 * @createTime: 2019年7月31日 下午8:20:49
	 * @history:
	 * @return ResultResponse
	 */
	public ResultResponse getAddressList();
	/**
	 * @desc: 保存服务器地址
	 * @author: kpchen
	 * @createTime: 2019年7月31日 下午8:38:26
	 * @history:
	 * @param request
	 * @return ResultResponse
	 */
	public ResultResponse saveAddress(SaveAddressRequest request);
	/**
	 * @desc: 保存摄像头
	 * @author: kpchen
	 * @createTime: 2019年7月31日 下午8:42:36
	 * @history:
	 * @param request
	 * @return ResultResponse
	 */
	public ResultResponse saveCamera(SaveCameraRequest request);
	/**
	 * @desc: 删除地址或摄像头
	 * @author: kpchen
	 * @createTime: 2019年7月31日 下午8:47:33
	 * @history:
	 * @param id
	 * @return ResultResponse
	 */
	public ResultResponse deleteAddress(Integer id);
	/**
	 * @desc: 保存区域
	 * @author: kpchen
	 * @createTime: 2019年8月1日 下午11:10:07
	 * @history:
	 * @param request
	 * @return ResultResponse
	 */
	public ResultResponse saveArea(SaveAreaRequest request);
	/**
	 * @desc: 更新服务器地址
	 * @author: kpchen
	 * @createTime: 2019年8月18日 下午8:39:58
	 * @history:
	 * @param request
	 * @return ResultResponse
	 */
	public ResultResponse updateAddress(UpdateAddressRequest request);

}

	