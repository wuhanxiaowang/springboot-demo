package com.github.mall.util;

import com.github.mall.entity.Person;

/**
 * @Auther: wy
 * @Date: 2020/2/14 14:18
 * @Description:
 */
public class PersonRestAPIUtil implements Runnable {

    public static Person queryPersonFromAPI(String id) {
        Person person = new Person();
        person.setId(id);
        person.setName("名字是:" + id);
        return person;

    }

    @Override
    public void run() {
        try {
            System.out.println("睡觉2秒钟....................");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
