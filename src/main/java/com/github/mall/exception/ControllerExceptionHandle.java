package com.github.mall.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: wy
 * @Date: 2020/2/23 16:44
 * @Description: 全局处理器
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandle {
    @ResponseBody
    @ExceptionHandler(value = UserException.class) //自定义的异常类
    public Map<String, Object> handleUserException(UserException u) {
        log.info("进来...............");
        Map<String, Object> map = new HashMap<>();
        map.put("code", u.getConstantEnum().getCode());
        map.put("message", u.getConstantEnum().getMessage());
        map.put("data", null);
        return map;
    }
}
