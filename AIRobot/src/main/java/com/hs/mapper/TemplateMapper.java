package com.hs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hs.model.TemplateModel;

public interface TemplateMapper {
	/**
	 * @desc: 保存模板
	 * @author: kpchen
	 * @createTime: 2019年7月28日 上午10:40:15
	 * @history:
	 * @param template
	 * @return int
	 */
	public int saveTemplate(TemplateModel template);
	/**
	 * @desc: 保存子模板
	 * @author: kpchen
	 * @createTime: 2019年7月28日 上午10:43:29
	 * @history:
	 * @param childrens void
	 */
	public int saveTemplateList(@Param("list") List<TemplateModel> list);
	/**
	 * @desc: 获取当前用户模板
	 * @author: kpchen
	 * @createTime: 2019年7月28日 上午11:13:46
	 * @history:
	 * @param id
	 * @return List<TemplateModel>
	 */
	public List<TemplateModel> getTemplateList(@Param("userId") Integer userId);
	/**
	 * @desc: 删除模板
	 * @author: kpchen
	 * @createTime: 2019年7月29日 下午9:44:20
	 * @history:
	 * @param id
	 * @return List<TemplateModel>
	 */
	public int deleteTemplate(@Param("id") Integer id);

}

	