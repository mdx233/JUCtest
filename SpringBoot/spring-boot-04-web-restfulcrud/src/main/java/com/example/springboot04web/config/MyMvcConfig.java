package com.example.springboot04web.config;

import com.example.springboot04web.component.LoginHandlerInterceptor;
import com.example.springboot04web.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//扩展SpringMvc
//@EnableWebMvc 这个注解使改配置类全面接管SpringMvc,SpringBoot原来的自动配置都失效
//实现WebMvcConfigurer接口来扩展SpringMvc的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /mdx 请求到 success页面
        registry.addViewController("/mdx").setViewName("success");

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");

        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器路径/**（/下的所有资源都拦截）
        //excludePathPatterns放行登录页面，初始页面以及静态资源
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
