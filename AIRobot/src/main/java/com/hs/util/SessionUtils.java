package com.hs.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * @desc: session工具类
 * @author: kpchen
 * @createTime: 2019年7月27日 上午10:41:41
 * @history:
 * @version: v1.0
 */
public class SessionUtils {
	/**
	 * @desc: 获取session
	 * @author: kpchen
	 * @createTime: 2019年7月27日 上午10:41:32
	 * @history:
	 * @return HttpSession
	 */
	public static HttpSession getSession() {
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = httpServletRequest.getSession();
		return session;
	}
	/**
	 * @desc: 设置session
	 * @author: kpchen
	 * @createTime: 2019年7月27日 上午10:42:57
	 * @history:
	 * @param key
	 * @param value void
	 */
	public static void setAttribute(String key,String value) {
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute(key, value);
	}
	/**
	 * @desc: 获取当前登录用户
	 * @author: kpchen
	 * @createTime: 2019年7月28日 上午10:14:13
	 * @history:
	 * @return String
	 */
	public static String getLoginUser() {
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = httpServletRequest.getSession();
		String domainName = (String) session.getAttribute(Constants.DOMAIN_NAME);
		return domainName;
	}
	
	
	
}

	