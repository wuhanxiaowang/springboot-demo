package com.github.mall.util.json;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JsonDemo
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/19 17:47
 * @ModifyDate 2019/9/19 17:47
 * @Version 1.0
 */
public class JsonDemo {
    public static void main(String[] args) {
        //GSON用法
        Gson gson = new Gson();

        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("asda");
        String s = gson.toJson(list);
        System.out.println(s);
        List<String> stringList = gson.fromJson(s, new TypeToken<List<String>>() {
        }.getType());
        System.out.println(stringList);


    }
}
