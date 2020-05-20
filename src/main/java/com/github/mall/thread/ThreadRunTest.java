package com.github.mall.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: wy
 * @Date: 2020/2/13 16:56
 * @Description:
 */
@Slf4j
public class ThreadRunTest implements Runnable {
    @Override
    public void run() {
        log.info("线程" + Thread.currentThread().getName() + "任务开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("线程" + Thread.currentThread().getName() + "任务完成");
    }
}
