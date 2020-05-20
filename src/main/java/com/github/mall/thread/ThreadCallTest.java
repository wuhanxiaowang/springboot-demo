package com.github.mall.thread;

import java.util.concurrent.Callable;

/**
 * @Auther: wy
 * @Date: 2020/2/13 16:58
 * @Description:
 */
public class ThreadCallTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "你好,老表";
    }

}
