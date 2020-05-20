package com.github.mall.aop;

import com.github.mall.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyInterceptor
 * @Description 过滤器
 * @Author 王炎
 * @Date 2019/9/12 17:15
 * @ModifyDate 2019/9/12 17:15
 * @Version 1.0
 */
//@Component
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 拦截之前调用（进入Controller之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("进入拦截器了=================================");
        String token = request.getHeader("Authorization");
        String userName = request.getParameter("username");
        log.info("token=" + token + "," + "userName=" + userName);
        if (handler instanceof HandlerMethod) {
            HandlerMethod h = (HandlerMethod) handler;
            boolean b = h.hasMethodAnnotation(LoginOperation.class);
            if (b) {
                String value = h.getMethod().getAnnotation(LoginOperation.class).value();
                if (StringUtils.isNotEmpty(value) && value.equals("login")) {
                    return true;
                }
            }
            String name = h.getMethod().getName();
            log.info("方法名{}", name);


        }
        Boolean verify = JwtTokenUtil.isVerify(token);
        if (verify) {
            return true;
        }

        return true;
    }

    /**
     * 调用方法之后，视图渲染之前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("拦截器掉用完Controller之后，返回modelView之前====================================");

    }

    /**
     * 完成拦截之后，用于清理资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        log.info("完成拦截之后，用于清理资源==============================");
    }


}
