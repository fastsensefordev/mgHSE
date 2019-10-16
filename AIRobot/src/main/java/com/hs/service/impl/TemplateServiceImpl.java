package com.hs.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hs.mapper.TemplateMapper;
import com.hs.model.TemplateModel;
import com.hs.model.User;
import com.hs.request.SaveTemplateRequest;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.TemplateService;
import com.hs.service.UserService;
import com.hs.util.Constants;
import com.hs.util.InterfaceConfig;
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
	
	private final Logger logger = LoggerFactory.getLogger(TemplateServiceImpl.class);
	@Autowired
	private TemplateMapper templateMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private InterfaceConfig interfaceConfig;
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
			logger.error("LoginServiceImpl.saveTemplate Error:", e);
			return ResultUtil.error("保存失败");
		}
	}
	/**
	 * @desc 更新模板
	 */
	@Override
	public ResultResponse updateTemplate(SaveTemplateRequest request) {
		try {
			TemplateModel template = request.getTemplate();
			templateMapper.updateTemplate(template);
			List<TemplateModel> childrens = request.getChildrens();
			String alarmIdStr = template.getAlarmId();
			@SuppressWarnings("unchecked")
			Map<String, String> alarmMap = (Map<String, String>) JSON.parse(alarmIdStr);
			for (TemplateModel temp : childrens) {
				Integer pid = template.getId();
				if (temp.getHref().equals("safeChart")) {
					templateMapper.updateChildTemplate(pid, temp.getHref(), alarmMap.get("safeAlarmId"));
				} else if (temp.getHref().equals("illegalChart")) {
					templateMapper.updateChildTemplate(pid, temp.getHref(), alarmMap.get("illegalAlarmId"));
				} else if (temp.getHref().equals("dangerChart")) {
					templateMapper.updateChildTemplate(pid, temp.getHref(), alarmMap.get("dangerAlarmId"));
				} else {
					templateMapper.updateChildTemplate(pid, temp.getHref(), template.getAlarmId());
				}

			}
			return ResultUtil.success();
		} catch (Exception e) {
			logger.error("LoginServiceImpl.updateTemplate Error:", e);
			return ResultUtil.error("更新失败");
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
			logger.error("LoginServiceImpl.getTemplateList Error:", e);
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
			logger.error("LoginServiceImpl.deleteTemplate Error:", e);
			return ResultUtil.error("删除失败");
		}
	}

	@Override
	public ResultResponse getTemplateById(Integer id) {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		try {
			TemplateModel templateModel = templateMapper.getTemplateById(id);
			data.put("template", templateModel);
			data.put("imgServer", interfaceConfig.getImgServer());
			return ResultUtil.success(data);
		} catch (Exception e) {
			logger.error("LoginServiceImpl.getTemplateById Error:", e);
			return ResultUtil.error("未查询到数据", data);
		}
	}

}
