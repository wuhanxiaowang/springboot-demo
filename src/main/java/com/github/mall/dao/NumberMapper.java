package com.github.mall.dao;

import com.github.mall.entity.Number;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Number record);

    int insertSelective(Number record);

    Number selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Number record);

    int updateByPrimaryKey(Number record);

    Number selectNumberByPre(String pre);

    Number selectByNumber(String number);
}