package com.github.mall.controller;

import com.github.mall.common.ApiResult;
import com.github.mall.dao.UserMapper;
import com.github.mall.entity.Person;
import com.github.mall.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/17 19:39
 * @ModifyDate 2019/9/17 19:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试")
@Slf4j
public class HelloController {


    //@Autowired
    // RedisUtil redisUtil;

    //  @Autowired
    //  HelloSender helloSender;

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ApiResult select() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();
        try {
            log.info("处理自己的业务");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //异步处理其他业务
        long end = System.currentTimeMillis();
        return ApiResult.success("总耗时:" + (end - start));

    }


    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ApiResult insert() {
        userService.insert();
        return ApiResult.success("成功");
    }

    @RequestMapping(value = "/batchUpdate", method = RequestMethod.GET)
    public ApiResult batchUpdate() {
        userService.batchUpdate();
        return ApiResult.success("成功");
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public ApiResult hello(@Valid @RequestBody Person person) {
        return ApiResult.success("成功");
    }




}
