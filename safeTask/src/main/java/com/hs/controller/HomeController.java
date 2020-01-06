package com.hs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {


	@RequestMapping({ "/index", "/" })
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("currMenu", "index");
		return modelAndView;
	}

	@RequestMapping({ "/authManage" })
	public ModelAndView authManage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("authManage");
		modelAndView.addObject("currMenu", "authManage");
		return modelAndView;
	}

	
	@RequestMapping({ "/deptManage" })
	public ModelAndView deptManage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deptManage");
		modelAndView.addObject("currMenu", "deptManage");
		return modelAndView;
	}
	
	@RequestMapping({ "/login" })
	public ModelAndView login() {
		return new ModelAndView("login");
	}
}
