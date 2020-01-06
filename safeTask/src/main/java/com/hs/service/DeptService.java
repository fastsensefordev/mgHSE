package com.hs.service;

import com.hs.model.DetpModel;
import com.hs.request.DeptRequest;
import com.hs.request.ZTreeRequest;
import com.hs.response.ResultResponse;

public interface DeptService {

	public ResultResponse initialDeptRoot(DetpModel dept);

	public ResultResponse getTreeData(DeptRequest request);

	public ResultResponse deleteDeptForChecked();

	public ResultResponse addDeptTree(DetpModel model);

	public ResultResponse updateDeptTree(DetpModel model);

	public ResultResponse deleteDeptTree(DetpModel model);

	public ResultResponse getzTreeData(ZTreeRequest request);


}

	