package com.mdx.springboot.config;

import com.mdx.springboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //定义此类为一个注解类
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //要拦截user下的所有访问请求，必须用户登录后才可访问
        String[] addPathPatterns={
            "/user/**"
        };
        //要排除的路径，排除的路径说明不需要用户登录也可以访问
        String[] excludePathPatterns={
            "/user/out","/user/error","/user/login"
        };

        registry.addInterceptor(new UserInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);

    }
}
