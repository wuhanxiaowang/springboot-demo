package com.github.mall.exception;

import com.github.mall.ConstantEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: wy
 * @Date: 2020/2/23 16:39
 * @Description: 自定义业务类异常
 */
@Slf4j
@Data
public class UserException extends RuntimeException {
    ConstantEnum constantEnum;

    public UserException(ConstantEnum constantEnum) {
        this.constantEnum = constantEnum;
    }
}
