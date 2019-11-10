package com.hs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hs.model.AddressModel;
import com.hs.request.UpdateAddressRequest;

public interface AddressMapper {
	/**
	 * @desc: 保存服务器地址
	 * @author: kpchen
	 * @createTime: 2019年7月28日 上午10:40:15
	 * @history:
	 * @param template
	 * @return int
	 */
	public int saveAddress(AddressModel addressModel);
	
	/**
	 * @desc: 获取当前用户服务器地址
	 * @author: kpchen
	 * @createTime: 2019年7月28日 上午11:13:46
	 * @history:
	 * @param id
	 * @return List<AddressModel>
	 */
	public List<AddressModel> getAddressList();
	/**
	 * @desc: 删除服务器地址
	 * @author: kpchen
	 * @createTime: 2019年7月29日 下午9:44:20
	 * @history:
	 * @param id
	 * @return List<AddressModel>
	 */
	public int deleteAddress(@Param("id") Integer id);

	public int updateAddress(UpdateAddressRequest request);
	/**
	 * 获取算法服务器地址
	 * @desc: AIRobot
	 * @author: kpchen
	 * @createTime: 2019年9月8日 上午10:10:50
	 * @history:
	 * @return List<AddressModel>
	 */
	public List<String> getCalcAddressList();

}

	