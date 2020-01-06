package com.hs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.hs.model.DetpModel;
import com.hs.request.DeptRequest;
import com.hs.request.ZTreeRequest;

public interface DeptMapper {

	public void saveDept(DetpModel dept);
	
	public List<DetpModel> getTreeData(DeptRequest request);

	public void deleteDeptForChecked(DetpModel model);

	public List<ZTreeRequest> getzTreeData(ZTreeRequest request);

}

	