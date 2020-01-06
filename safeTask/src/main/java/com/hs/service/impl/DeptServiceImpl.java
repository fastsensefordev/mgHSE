package com.hs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.mapper.DeptMapper;
import com.hs.model.AddressModel;
import com.hs.model.DetpModel;
import com.hs.request.DeptRequest;
import com.hs.request.ZTreeRequest;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	private final Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);
	@Autowired
	private DeptMapper deptMapper;
	@Override
	public ResultResponse initialDeptRoot(DetpModel dept) {
		try {
			deptMapper.saveDept(dept);
			return ResultUtil.success();
		} catch (Exception e) {
			logger.error("DeptServiceImpl.initialDeptRoot Error:", e);
			return ResultUtil.error("保存失败");
		}
	}
	
	@Override
	public ResultResponse getzTreeData(ZTreeRequest request) {
		try {
			List<ZTreeRequest> list = deptMapper.getzTreeData(request);
			Map<String, Object> data = new LinkedHashMap<String, Object>();
			data.put("data", list);
			return ResultUtil.success(data);
		} catch (Exception e) {
			logger.error("DeptServiceImpl.getzTreeData Error:", e);
			return ResultUtil.error("查询失败");
		}
	}

	@Override
	public ResultResponse getTreeData(DeptRequest request) {
		try {
			List<DetpModel> list = deptMapper.getTreeData(request);
			List<DeptRequest> resultList=new ArrayList<DeptRequest>();
			setTreeMap(list,resultList);
			Map<String, Object> data = new LinkedHashMap<String, Object>();
			data.put("data", resultList);
			return ResultUtil.success(data);
		} catch (Exception e) {
			logger.error("DeptServiceImpl.getTreeData Error:", e);
			return ResultUtil.error("查询失败");
		}
	}
	private void setTreeMap(List<DetpModel> list, List<DeptRequest> resultList) {
		for(DetpModel model:list){
			DeptRequest innerModel=new DeptRequest();
			if(null==model.getpId()){//处理根节点
				innerModel.setId(model.getId());
				innerModel.setTitle(model.getDeptName());
				innerModel.setSpread(true);
				List<DeptRequest> innerList=new ArrayList<DeptRequest>();
				innerModel.setChildren(recursionTree(model.getId(),list,innerList));//递归处理子节点
				resultList.add(innerModel);
			}
		}
	}
	private List<DeptRequest> recursionTree(Integer id, List<DetpModel> list,List<DeptRequest> outerList) {
		for(DetpModel model:list){
			DeptRequest innerModel=new DeptRequest();
			if(id==model.getpId()){
				innerModel.setId(model.getId());
				innerModel.setTitle(model.getDeptName());
				innerModel.setSpread(false);
				List<DeptRequest> innerList=new ArrayList<DeptRequest>();
				innerModel.setChildren(recursionTree(model.getId(),list,innerList));//递归处理子节点
				outerList.add(innerModel);
			}
		}
		return outerList;
	}
	@Override
	public ResultResponse deleteDeptForChecked() {
		try {
			deptMapper.deleteDeptForChecked(null);
			return ResultUtil.success();
		} catch (Exception e) {
			logger.error("DeptServiceImpl.deleteDeptForChecked Error:", e);
			return ResultUtil.error("删除失败");
		}
	}
	@Override
	public ResultResponse addDeptTree(DetpModel model) {
		try {
			deptMapper.saveDept(model);
			return ResultUtil.success();
		} catch (Exception e) {
			logger.error("DeptServiceImpl.addDeptTree Error:", e);
			return ResultUtil.error("保存失败");
		}
	}
	@Override
	public ResultResponse updateDeptTree(DetpModel model) {
		try {
			deptMapper.saveDept(model);
			return ResultUtil.success();
		} catch (Exception e) {
			logger.error("DeptServiceImpl.addDeptTree Error:", e);
			return ResultUtil.error("保存失败");
		}
	}
	@Override
	public ResultResponse deleteDeptTree(DetpModel model) {
		try {
			deptMapper.deleteDeptForChecked(model);
			return ResultUtil.success();
		} catch (Exception e) {
			logger.error("DeptServiceImpl.deleteDeptTree Error:", e);
			return ResultUtil.error("删除失败");
		}
	}
	
	
}
