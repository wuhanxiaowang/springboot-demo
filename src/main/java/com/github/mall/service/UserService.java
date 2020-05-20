package com.github.mall.service;

import com.github.mall.common.ApiResult;

public interface UserService {
    ApiResult select();

    ApiResult insert();

    ApiResult hello();

    ApiResult batchUpdate();
}
