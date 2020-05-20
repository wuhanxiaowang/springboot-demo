package com.github.mall.serviceImpl;

import com.github.mall.ConstantEnum;
import com.github.mall.common.ApiResult;
import com.github.mall.dao.NumberMapper;
import com.github.mall.dao.UserMapper;
import com.github.mall.exception.UserException;
import com.github.mall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: wy
 * @Date: 2020/2/21 10:56
 * @Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    NumberMapper numberMapper;

    @Override
    public ApiResult select() {
        userMapper.selectByPrimaryKey(1123908);
        if (true) {
            throw new UserException(ConstantEnum.USER_NOT_FOUND);
        }
        return ApiResult.success("成功");
    }

    @Override
    public ApiResult insert() {

        return ApiResult.success("成功");
    }

    @Override
    public ApiResult hello() {
        return null;
    }

    @Override
    public ApiResult batchUpdate() {
        return ApiResult.success("成功");
    }
}
