package com.github.mall.config;

import com.github.mall.aop.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

/**
 * @ClassName FilterConfig
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/25 10:59
 * @ModifyDate 2019/9/25 10:59
 * @Version 1.0
 */
//@Configuration
public class FilterConfig {
    @Autowired
    MyFilter myFilter;

    // @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(myFilter);
        registration.addUrlPatterns("/*");
        registration.setName("MyFilter");
        //过滤器执行顺序
        registration.setOrder(1);
        return registration;
    }

}
