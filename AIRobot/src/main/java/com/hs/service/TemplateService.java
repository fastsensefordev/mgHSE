package com.hs.service;

import com.hs.request.SaveTemplateRequest;
import com.hs.response.ResultResponse;
/**
 * @desc: 模板管理service接口
 * @author: kpchen
 * @createTime: 2019年7月28日 上午10:02:16
 * @history:
 * @version: v1.0
 */
public interface TemplateService {
	/**
	 * @desc: 保存模板
	 * @author: kpchen
	 * @createTime: 2019年7月28日 上午10:02:07
	 * @history:
	 * @param request
	 * @return ResultResponse
	 */
	public ResultResponse saveTemplate(SaveTemplateRequest request);
	/**
	 * @desc: 查询模板
	 * @author: kpchen
	 * @createTime: 2019年7月28日 上午11:05:08
	 * @history:
	 * @return ResultResponse
	 */
	public ResultResponse getTemplateList();
	/**
	 * @desc: 删除模板
	 * @author: kpchen
	 * @createTime: 2019年7月29日 下午9:43:10
	 * @history:
	 * @param id
	 * @return ResultResponse
	 */
	public ResultResponse deleteTemplate(Integer id);

}

	