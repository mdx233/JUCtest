package com.example.springboot04web.config;

import com.example.springboot04web.filter.MyFilter;
import com.example.springboot04web.listener.MyListener;
import com.example.springboot04web.servlet.MyServlet;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;
import java.util.Arrays;

@Configuration
public class MyServerConfig {
    //注册三大组件

    //注册servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return registrationBean;
    }

    //注册过滤器
    @Bean
    public FilterRegistrationBean myFilter(){
       FilterRegistrationBean registrationBean = new FilterRegistrationBean();
       registrationBean.setFilter(new MyFilter());
       registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
       return registrationBean;
    }

    //注册监听器
    @Bean
    public ServletListenerRegistrationBean myListener(){
     ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
     return registrationBean;
    }

//    //配置嵌入式的Servlet容器
//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer(){
//        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
//            //定制嵌入式的Servlet容器的相关规则
//            @Override
//            public void customize(ConfigurableWebServerFactory factory) {
//                factory.setPort(8081);
//            }
//        };
//    }
}
