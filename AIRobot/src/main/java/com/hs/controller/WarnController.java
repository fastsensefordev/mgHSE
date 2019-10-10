package com.hs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.hs.model.AlarmExcelModel;
import com.hs.request.BatchAlarmsRequest;
import com.hs.request.GetTotalChartRequest;
import com.hs.request.GetWarnListRequest;
import com.hs.response.ResultResponse;
import com.hs.response.ResultUtil;
import com.hs.service.AlarmService;
import com.hs.service.WarnService;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
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
	@Autowired
	private AlarmService alarmService;

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
	/**
	 * @desc: 获取报警列表
	 * @author: kpchen
	 * @createTime: 2019年9月8日 上午11:35:01
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return ResultResponse
	 */
	@RequestMapping("getAlarmNameList")
	public JSONObject getAlarmNameList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		return warnService.getAlarmNameList();
	}

	/**
	 * @desc: 通过id查询alarm实体
	 * @author: kpchen
	 * @createTime: 2019年9月7日 下午12:23:23
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param alarmId
	 * @return ResultResponse
	 */
	@RequestMapping("getEchartsByAid")
	public ResultResponse getEchartsByAid(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,String alarmId) {
		return warnService.getEchartsByAid(alarmId);
	}

	/**
	 * @desc: 获取综合数据
	 * @author: kpchen
	 * @createTime: 2019年9月7日 下午12:23:10
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @return ResultResponse
	 */
	@RequestMapping("getTotalChart")
	public ResultResponse getTotalChart(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			GetTotalChartRequest request) {
		return warnService.getTotalChart(request);
	}
	/**
	 * @desc: 处理今天数据
	 * @author: kpchen
	 * @createTime: 2019年9月7日 下午12:24:54
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return ResultResponse
	 */
	@RequestMapping("dealWithToday")
	public ResultResponse dealWithToday(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		return alarmService.parseData();
	}
	
	@RequestMapping("dealWithSomeDay")
	public ResultResponse dealWithToday(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,String day) {
		if (StringUtils.isBlank(day)) {
			return ResultUtil.error("day 参数为空");
		}
		return alarmService.parseDataSomeday(day);
	}
	/**
	 * @desc: 获取今天的定时任务是否有异常
	 * @author: kpchen
	 * @createTime: 2019年9月15日 下午7:09:15
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return ResultResponse
	 */
	@RequestMapping("getErrorLog")
	public ResultResponse getErrorLog(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		return alarmService.getErrorLog();
	}
	/**
	 * @desc: 删除报警日志
	 * @author: kpchen
	 * @createTime: 2019年9月15日 下午7:43:32
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return ResultResponse
	 */
	@RequestMapping("deleteErrorLog")
	public ResultResponse deleteErrorLog(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		return alarmService.deleteErrorLog();
	}
	
	/**
	 * @desc: 导出
	 * @author: kpchen
	 * @createTime: 2019年9月8日 下午3:26:01
	 * @history:
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param request
	 * @throws Exception void
	 */
	@RequestMapping("downloadAlarm")
	public void downloadAlarm(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			GetWarnListRequest request) throws Exception {
		List<AlarmExcelModel> alarmExcelModels = warnService.getAllWarnList(request);
		ExportParams params = new ExportParams("极视智能报警详情","报警详情");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("date", new Date());//导出一般都要日期
		data.put("list", alarmExcelModels);//导出list集合
		Workbook book = ExcelExportUtil.exportExcel(params,AlarmExcelModel.class, alarmExcelModels);
		export(httpServletResponse, book, "极视智能报警详情");
	}
	
	 /**
     * export导出请求头设置
     *
     * @param response
     * @param workbook
     * @param fileName
     * @throws Exception
     */
    private static void export(HttpServletResponse response, Workbook workbook, String fileName) throws Exception {
        response.reset();
        response.setContentType("application/x-msdownload");
        fileName = fileName + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("gb2312"), "ISO-8859-1") + ".xls");
        ServletOutputStream outStream = null;
        try {
            outStream = response.getOutputStream();
            workbook.write(outStream);
        } finally {
            outStream.close();
        }
    }

}

