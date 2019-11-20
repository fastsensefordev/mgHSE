package com.hs;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.activemq.web.AjaxServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.hs.util.InterfaceConfig;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.hs.mapper")
@EnableScheduling
//@ServletComponentScan
public class Application {
	@Autowired
	private InterfaceConfig interfaceConfig;
	@Bean
    public ServletRegistrationBean<AjaxServlet> amqServletRegistrationBean() {
        ServletRegistrationBean<AjaxServlet> registrationBean = new ServletRegistrationBean<AjaxServlet>();
        registrationBean.setServlet(new AjaxServlet());
        registrationBean.setLoadOnStartup(1);
        registrationBean.setEnabled(true);
        registrationBean.setAsyncSupported(true);
        List<String> urlMappings=new ArrayList<String>();
        urlMappings.add("/amq/*");
        registrationBean.setUrlMappings(urlMappings);
        return registrationBean;
    }

    @Bean
    public ServletContextInitializer initializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
            	servletContext.setInitParameter("org.apache.activemq.brokerURL", interfaceConfig.getAmqUrl());
            }
        };
    }
	
    /**
     * Start
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
