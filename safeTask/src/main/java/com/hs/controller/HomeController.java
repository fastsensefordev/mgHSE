package com.hs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @desc: 前台页面控制器
 * @author: kpchen
 * @createTime: 2019年10月16日 下午9:01:59
 * @history:
 * @version: v1.0
 */
@Controller
public class HomeController {

	/**
	 * @desc: 首页
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:07:46
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "/index", "/" })
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("currMenu", "index");
		return modelAndView;
	}

	/**
	 * @desc: 模板管理页面
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:03:38
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "/templateManage" })
	public ModelAndView templateManage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("templateManage");
		modelAndView.addObject("currMenu", "templateManage");
		return modelAndView;
	}

	/**
	 * @desc: 用户管理
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:05:01
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "/authManage" })
	public ModelAndView authManage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("authManage");
		modelAndView.addObject("currMenu", "authManage");
		return modelAndView;
	}

	/**
	 * @desc: 服务器管理
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:05:11
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "/addressManage" })
	public ModelAndView addressManage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addressManage");
		modelAndView.addObject("currMenu", "addressManage");
		return modelAndView;
	}
	
	/**
	 * @desc: 音箱管理
	 * @author: dt
	 * @createTime: 2019年11月12日 下午3:05:09
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "/audioManage" })
	public ModelAndView audioManage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("audioManage");
		modelAndView.addObject("currMenu", "audioManage");
		return modelAndView;
	}

	/**
	 * @desc: 报警管理
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:06:03
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "/warnManage" })
	public ModelAndView warnManage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("warnManage");
		modelAndView.addObject("currMenu", "warnManage");
		return modelAndView;
	}

	/**
	 * @desc: 用户登录
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:06:13
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "/login" })
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	/**
	 * @desc: Dashboard页面
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:02:19
	 * @history:
	 * @param type
	 * @return ModelAndView
	 */
	@RequestMapping({ "/dashboard" })
	public ModelAndView dashboard(String type) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dashboard");
		modelAndView.addObject("type", type);
		return modelAndView;
	}

	/**
	 * @desc: safe小页面
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:02:30
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "safeChart" })
	public ModelAndView safeChart() {
		return new ModelAndView("safeChart");
	}

	/**
	 * @desc: illegal小页面
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:02:46
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "illegalChart" })
	public ModelAndView illegalChart() {
		return new ModelAndView("illegalChart");
	}

	/**
	 * @desc: danger小页面
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:03:02
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "dangerChart" })
	public ModelAndView dangerChart() {
		return new ModelAndView("dangerChart");
	}

	/**
	 * @desc: 总数量统计页面
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:03:16
	 * @history:
	 * @return ModelAndView
	 */
	@RequestMapping({ "totalChart" })
	public ModelAndView totalChart() {
		return new ModelAndView("totalChart");
	}

}
