package com.github.mall.config;

import com.github.mall.aop.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName InterceptorConfig
 * @Description 拦截器配置
 * @Author 王炎
 * @Date 2019/9/12 17:14
 * @ModifyDate 2019/9/12 17:14
 * @Version 1.0
 */
//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
