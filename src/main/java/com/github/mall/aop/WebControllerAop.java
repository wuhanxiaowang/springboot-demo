package com.github.mall.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ClassName WebControllerAop
 * @Description AOP
 * @Author 王炎
 * @Date 2019/9/25 11:12
 * @ModifyDate 2019/9/25 11:12
 * @Version 1.0
 */
//@Aspect //这个注解的作用就是将一个类定义为切面
//@Component
@Order(1)//切面类处理的优先级
@Slf4j
public class WebControllerAop {

    @Pointcut("execution(public * com.github.mall.controller.*.*(..))")
    public void webLog() {

    }

    /**
     * 前置通知，方法调用前被调用
     *
     * @param joinPoint
     */
    /*@Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("AOP前置通知,方法调用之前========================");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        log.info("方法：" + signature.getName());
        //AOP代理类的名字
        log.info("方法所在包:" + signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] strings = methodSignature.getParameterNames();
        log.info("参数名：" + Arrays.toString(strings));
        log.info("参数值ARGS : " + Arrays.toString(joinPoint.getArgs()));
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        // 记录下请求内容
        log.info("请求URL : " + req.getRequestURL().toString());
        log.info("HTTP_METHOD : " + req.getMethod());
        log.info("IP : " + req.getRemoteAddr());
    }*/

    /**
     * 处理完请求返回内容
     *
     * @param ret
     * @throws Throwable
     */
   /* @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        ApiResult apiResult=(ApiResult) ret;
        // 处理完请求，返回内容
        log.info("AOP方法处理完的返回值:" + apiResult.getData());
    }*/

    /**
     * 后置异常通知
     *
     * @param jp
     */
  /*  @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp) {
        log.info("AOP后置异常通知==============================");
    }*/

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     *
     * @param jp
     */
   /* @After("webLog()")
    public void after(JoinPoint jp) {
        log.info("AOP后置通知,方法调用结束===========================");
    }*/

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     *
     * @param pjp
     * @return
     */
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        try {
            log.info("环绕通知调用方法前====================");
            //获取目标方法的参数信息
            Object[] obj = pjp.getArgs();
            Signature signature = pjp.getSignature();
            //代理的是哪一个方法
            log.info("方法：" + signature.getName());
            //AOP代理类的名字
            log.info("方法所在包:" + signature.getDeclaringTypeName());
            //AOP代理类的类（class）信息
            signature.getDeclaringType();
            MethodSignature methodSignature = (MethodSignature) signature;
            String[] strings = methodSignature.getParameterNames();
            log.info("参数名：" + Arrays.toString(strings));
            log.info("参数值ARGS : " + Arrays.toString(pjp.getArgs()));
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest req = attributes.getRequest();
            // 记录下请求内容
            log.info("请求URL : " + req.getRequestURL().toString());
            log.info("HTTP_METHOD : " + req.getMethod());
            log.info("IP : " + req.getRemoteAddr());
            Object o = pjp.proceed();
            log.info("环绕通知调用方法后====================");
            //  ApiResult apiResult = (ApiResult) o;
            //可以修改返回值
            //  apiResult.setData("1");
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

}
