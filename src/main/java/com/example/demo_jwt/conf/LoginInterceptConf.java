package com.example.demo_jwt.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Conf
 *
 * @author LINMINGLE
 * @version 1.0
 * 2021/4/21 16:22
 **/

@Configuration
public class LoginInterceptConf implements WebMvcConfigurer {

    @Resource
    LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).excludePathPatterns("/login");
    }
}
