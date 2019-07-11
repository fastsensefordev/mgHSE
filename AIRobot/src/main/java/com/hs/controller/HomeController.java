package com.hs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping({"/index","/"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }
    /**
     * 
            *  登录
    * @Title: login
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @return    参数
    * @return ModelAndView    返回类型
    * @throws
     */
    @RequestMapping({"/login"})
    public ModelAndView login() {
        return new ModelAndView("login");
    }
    
    
}
