package servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.activemq.web.AjaxServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//注册servlet有误，js无法访问，写在application里可以？？？
@Configuration
public class ServletBean {


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
                servletContext.setInitParameter("org.apache.activemq.brokerURL", "tcp://127.0.0.1:61616");
            }
        };
    }
}



