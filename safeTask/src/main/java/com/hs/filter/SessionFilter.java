package com.hs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.hs.util.Constants;

public class SessionFilter implements Filter {

	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        
        session.setMaxInactiveInterval(7200);//失效时间2小时
        
        String domainName = (String) session.getAttribute(Constants.DOMAIN_NAME);
        //过滤以下接口不被拦截
        if (uri.startsWith("/safeTask/static") || uri.startsWith("/static") || uri.contains("login") 
        		|| uri.contains("retrievePassword")) {
        	filterChain.doFilter(request, response);
        	return;
        }
        if (StringUtils.isBlank(domainName)) {
        	response.sendRedirect("login");
        	return;
        } else {
        	filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }

}

	