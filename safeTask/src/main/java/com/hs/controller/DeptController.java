package com.hs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hs.model.DetpModel;
import com.hs.request.DeptRequest;
import com.hs.request.ZTreeRequest;
import com.hs.response.ResultResponse;
import com.hs.service.DeptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@ApiOperation(value="初始化部门", notes="初始化部门")
	@RequestMapping("initialDeptRoot")
	public ResultResponse initialDeptRoot(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody DetpModel dept) {
		ResultResponse resopnse = deptService.initialDeptRoot(dept);
		return resopnse;
	}
	
	@ApiOperation(value="获取组织架构数据", notes="获取组织架构数据")
	@RequestMapping("getTreeData")
	public ResultResponse getTreeData(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody DeptRequest request) {
		ResultResponse resopnse = deptService.getTreeData(request);
		return resopnse;
	}
	
	@ApiOperation(value="获取组织架构", notes="获取组织架构")
	@RequestMapping("getzTreeData")
	public ResultResponse getzTreeData(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody ZTreeRequest request) {
		ResultResponse resopnse = deptService.getzTreeData(request);
		return resopnse;
	}
	
	@ApiOperation(value="删除组织架构", notes="删除组织架构")
	@RequestMapping("deleteDeptForChecked")
	public ResultResponse deleteDeptForChecked(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		ResultResponse resopnse = deptService.deleteDeptForChecked();
		return resopnse;
	}
	
	@ApiOperation(value="新增部门", notes="新增部门")
	@RequestMapping("addDeptTree")
	public ResultResponse addDeptTree(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody DetpModel model) {
		ResultResponse resopnse = deptService.addDeptTree(model);
		return resopnse;
	}
	
	@ApiOperation(value="更新部门", notes="更新部门")
	@RequestMapping("updateDeptTree")
	public ResultResponse updateDeptTree(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody DetpModel model) {
		ResultResponse resopnse = deptService.updateDeptTree(model);
		return resopnse;
	}
	
	@ApiOperation(value="删除部门", notes="删除部门")
	@RequestMapping("deleteDeptTree")
	public ResultResponse deleteDeptTree(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody DetpModel model) {
		ResultResponse resopnse = deptService.deleteDeptTree(model);
		return resopnse;
	}
}

	