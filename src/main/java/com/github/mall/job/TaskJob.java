package com.github.mall.job;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: wy
 * @Date: 2020/1/27 21:33
 * @Description:
 */
//@Component
@Slf4j
public class TaskJob {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //@Scheduled(fixedRate = 1000)
    public void testTasks() {
        log.info("定时任务执行时间：" + dateFormat.format(new Date()));
    }

}
