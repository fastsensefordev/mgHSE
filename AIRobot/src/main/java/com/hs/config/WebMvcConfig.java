package com.hs.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.hs.filter.SessionFilter;
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 解决静态资源无法访问
		registry.addResourceHandler("/**").addResourceLocations("classpath:/");
		// 解决swagger无法访问
		registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		// 解决swagger的js文件无法访问
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public FilterRegistrationBean<SessionFilter> someFilterRegistration1() {
		//新建过滤器注册类
		FilterRegistrationBean<SessionFilter> registration = new FilterRegistrationBean<SessionFilter>();
		// 添加我们写好的过滤器
		registration.setFilter(new SessionFilter());
		// 设置过滤器的URL模式
		registration.addUrlPatterns("/*");
		return registration;
	}
}

