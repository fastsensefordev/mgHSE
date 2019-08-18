package com.hs.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.mapper.TemplateMapper;
import com.hs.model.TemplateModel;
import com.hs.model.User;
import com.hs.request.SaveTemplateRequest;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.TemplateService;
import com.hs.service.UserService;
import com.hs.util.Constants;
import com.hs.util.SessionUtils;
/**
 * @desc: 模板管理service 实现类
 * @author: kpchen
 * @createTime: 2019年7月28日 上午10:02:43
 * @history:
 * @version: v1.0
 */
@Service
public class TemplateServiceImpl implements TemplateService {
	@Autowired
	private TemplateMapper templateMapper;
	@Autowired
	private UserService userService;
	/**
	 * @desc 保存模板
	 */
	@Override
	public ResultResponse saveTemplate(SaveTemplateRequest request) {
		try {
			String loginUser = SessionUtils.getLoginUser();
			User existUser = userService.getLoginUser();
			TemplateModel template = request.getTemplate();
			template.setCreateUser(loginUser);
			template.setUserId(existUser.getId());
			template.setStatus(Constants.TEMPLATE_STATUS_DEFAULT);
			templateMapper.saveTemplate(template);
			List<TemplateModel> childrens = request.getChildrens();
			for (TemplateModel temp : childrens) {
				temp.setPid(template.getId());
				temp.setCreateUser(loginUser);
				temp.setUserId(existUser.getId());
				temp.setStatus(Constants.TEMPLATE_STATUS_DEFAULT);
			}
			templateMapper.saveTemplateList(childrens);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("保存失败");
		}
	}
	/**
	 * @desc 查询模板
	 */
	@Override
	public ResultResponse getTemplateList(String serveAddress) {
		try {
			User existUser = userService.getLoginUser();
			List<TemplateModel> models = templateMapper.getTemplateList(existUser.getId());
			for (TemplateModel templateModel : models) {
				templateModel.setHref(serveAddress + templateModel.getHref());
			}
			Map<String, Object> data = new LinkedHashMap<String, Object>();
			data.put("data", models);
			return ResultUtil.success(data);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("查询失败");
		}
	}
	/**
	 * @desc 删除模板
	 */
	@Override
	public ResultResponse deleteTemplate(Integer id) {
		try {
			templateMapper.deleteTemplate(id);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("删除失败");
		}
	}

}

	