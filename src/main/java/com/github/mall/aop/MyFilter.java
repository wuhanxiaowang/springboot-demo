package com.github.mall.aop;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName MyFilter
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/25 10:59
 * @ModifyDate 2019/9/25 10:59
 * @Version 1.0
 */
//@Component
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("系统启动时间:" + new Date());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器调方法之前==================================");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("过滤器调方法之后==================================");
    }

    @Override
    public void destroy() {
        log.info("容器销毁==================================");
    }
}
