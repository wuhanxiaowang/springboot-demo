package com.github.mall.thread;

import com.github.mall.entity.Person;
import com.github.mall.util.PersonRestAPIUtil;

import java.util.concurrent.Callable;

/**
 * @Auther: wy
 * @Date: 2020/2/14 14:51
 * @Description:
 */
public class QueryPersonTask implements Callable<Person> {
    private String id;

    public QueryPersonTask(String id) {
        this.id = id;
    }

    @Override
    public Person call() throws Exception {
        return PersonRestAPIUtil.queryPersonFromAPI(this.id);
    }
}
