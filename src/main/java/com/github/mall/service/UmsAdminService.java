package com.github.mall.service;

import com.github.mall.common.ApiResult;
import com.github.mall.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author wy
 * @since 2019-09-12
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    ApiResult getUser();
}
