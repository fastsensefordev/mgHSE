package com.hs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hs.request.SaveTemplateRequest;
import com.hs.response.ResultResponse;
import com.hs.service.TemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/template")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	/**
	 * @desc: 保存模板
	 * @author: kpchen
	 * @createTime: 2019年7月28日 上午10:01:39
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="保存模板", notes="保存模板")
	@RequestMapping("saveTemplate")
	public ResultResponse saveTemplate(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody SaveTemplateRequest request) {
		ResultResponse resopnse = templateService.saveTemplate(request);
		return resopnse;
	}
	
	@ApiOperation(value="更新模板")
	@RequestMapping("updateTemplate")
	public ResultResponse updateTemplate(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody SaveTemplateRequest request) {
		ResultResponse resopnse = templateService.updateTemplate(request);
		return resopnse;
	}
	/**
	 * @desc: 根据ID查询模板
	 * @author: kpchen
	 * @createTime: 2019年9月1日 上午11:45:00
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param id
	 * @return ResultResponse
	 */
	@ApiOperation(value="查询模板", notes="查询模板")
	@RequestMapping("getTemplateById")
	public ResultResponse getTemplateById(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Integer id) {
		ResultResponse resopnse = templateService.getTemplateById(id);
		return resopnse;
	}
	
	/**
	 * @desc: 查询模板
	 * @author: kpchen
	 * @createTime: 2019年7月28日 上午11:04:58
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return ResultResponse
	 */
	@ApiOperation(value="查询模板", notes="查询已添加模板")
	@RequestMapping("getTemplateList")
	public ResultResponse getTemplateList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		String serveAdd = "http://" + httpServletRequest.getLocalAddr() + ":" + httpServletRequest.getServerPort() + httpServletRequest.getContextPath() +"/";
		ResultResponse resopnse = templateService.getTemplateList(serveAdd);
		return resopnse;
	}
	/**
	 * @desc: 删除模板
	 * @author: kpchen
	 * @createTime: 2019年7月29日 下午9:42:52
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param id
	 * @return ResultResponse
	 */
	@ApiOperation(value="删除模板", notes="删除模板")
	@RequestMapping("deleteTemplate")
	public ResultResponse deleteTemplate(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			Integer id) {
		ResultResponse resopnse = templateService.deleteTemplate(id);
		return resopnse;
	}
	
}

	