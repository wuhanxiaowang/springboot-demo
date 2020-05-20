package com.github.mall.thread;

import java.util.concurrent.*;

/**
 * @Auther: wy
 * @Date: 2020/2/14 16:38
 * @Description:
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // executorService.execute(new ThreadRunTest());
        executorService.submit(new ThreadCallTest());
        executorService.shutdown();
    }


}
