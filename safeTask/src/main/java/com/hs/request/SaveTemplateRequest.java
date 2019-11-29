package com.hs.request;
/**
 * @desc: 保存模板实体类
 * @author: kpchen
 * @createTime: 2019年7月28日 上午10:34:34
 * @history:
 * @version: v1.0
 */

import java.util.List;

import com.hs.model.TemplateModel;

public class SaveTemplateRequest {

	private TemplateModel template;
	private List<TemplateModel> childrens;
		
	public TemplateModel getTemplate() {
		return template;
	}
	public void setTemplate(TemplateModel template) {
		this.template = template;
	}
	public List<TemplateModel> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<TemplateModel> childrens) {
		this.childrens = childrens;
	}
	
}

	