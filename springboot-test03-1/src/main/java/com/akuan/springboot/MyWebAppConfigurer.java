package com.akuan.springboot;

import com.akuan.springboot.interceptor.Interceptor01;
import com.akuan.springboot.interceptor.Interceptor02;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new Interceptor01()).addPathPatterns("/*");
        registry.addInterceptor(new Interceptor02()).addPathPatterns("/*");
        super.addInterceptors(registry);
    }

}