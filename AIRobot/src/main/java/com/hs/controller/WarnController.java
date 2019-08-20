package com.hs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hs.request.BatchAlarmsRequest;
import com.hs.request.GetWarnListRequest;
import com.hs.response.ResultResponse;
import com.hs.service.WarnService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * @desc: 用户管理
 * @author: kpchen
 * @createTime: 2019年7月20日 下午1:25:36
 * @history:
 * @version: v1.0
 */
@Api
@RestController
@RequestMapping("/warn")
public class WarnController {
	
	@Autowired
	private WarnService warnService;
	
	/**
	 * @author: 报警列表
	 * @createTime: 2019年7月20日 下午2:53:50
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@ApiOperation(value="报警列表", notes="报警列表")
	@GetMapping("getWarnList")
	public ResultResponse getWarnList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,GetWarnListRequest request) {
		return warnService.getWarnList(request);
	}
	
	/**
	 * @desc: 处理告警
	 * @author: kpchen
	 * @createTime: 2019年8月18日 上午11:53:56
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param id
	 * @return ResultResponse
	 */
	@GetMapping("dealAlarmById")
	public ResultResponse dealAlarmById(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Integer id) {
		return warnService.dealAlarmById(id);
	}
	
	/**
	 * @desc: 批量删除
	 * @author: kpchen
	 * @createTime: 2019年8月18日 上午11:54:32
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param id
	 * @return ResultResponse
	 */
	@RequestMapping("batchAlarms")
	public ResultResponse batchAlarms(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody BatchAlarmsRequest request) {
		return warnService.batchAlarms(request);
	}
	
	/**
	 * @desc: 获取报警名称列表
	 * @author: kpchen
	 * @createTime: 2019年8月20日 下午10:34:06
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return ResultResponse
	 */
	@RequestMapping("getAlarmList")
	public ResultResponse getAlarmList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		return warnService.getAlarmList();
	}
	
}

