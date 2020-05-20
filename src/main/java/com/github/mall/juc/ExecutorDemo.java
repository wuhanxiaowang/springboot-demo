package com.github.mall.juc;

import java.util.concurrent.*;

/**
 * @Auther: wy
 * @Date: 2020/2/28 09:38
 * @Description: 线程池, 工作流程, 先判断核心线程数, 在判断队列, 最后判断最大线程数
 */
public class ExecutorDemo {

    public static void main(String[] args) {

        /**
         * corePoolSize,核心线程数,开始执行任务时创建所有核心线程数
         * maximumPoolSize,最大线程数,线程池中最大的线程数
         * keepAliveTime,线程池里面大于核心线程的新线程，在空余时间超过keepAliveTime,就会被回收,核心线程不会回收(除非设置)
         * TimeUnit,时间单位
         * BlockingQueue,阻塞队列,(无界队列(LinkedBlockingQueue容量无穷大),有界队列(ArrayBlockingQueue自己定义),直接交接(SynchronousQueue,没有容量))
         * ThreadFactory,线程工厂,一般用默认工厂
         * RejectedExecutionHandler,拒绝策略,(ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。 ThreadPoolExecutor.DiscardPolicy：丢弃任务，但是不抛出异常。 ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新提交被拒绝的任务 ThreadPoolExecutor.CallerRunsPolicy：由调用线程（提交任务的线程）处理该任务)
         */
        /**
         * java提供四种创建线程池的方法
         */
        //1.固定线程池,核心线程数等于最大线程数,采用LinkedBlockingQueue(无边界队列)
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            // fixedThreadPool.execute(new Task());
        }
        fixedThreadPool.shutdown();
        //2.单例线程池,核心线程数和最大线程数都是1,采用无边界队列
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            //  singleThreadExecutor.execute(new Task());
        }
        singleThreadExecutor.shutdown();
        //3.缓存线程池,核心线程数是0，最大线程数Interger最大值,有任务来就创建新线程,直接交接队列
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            // cachedThreadPool.execute(new Task());
        }
        cachedThreadPool.shutdown();
        //4.周期性线程池,可以用作定时任务或者定时器,核心线程数自己定义,最大线程数是Integer最大值,采用延迟队列
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 20; i++) {
            //2秒后执行
            //  scheduledExecutorService.schedule(new Task(),2000, TimeUnit.MILLISECONDS);
            //1秒后执行,每隔3秒执行一次
            //  scheduledExecutorService.scheduleAtFixedRate(new Task(),1000,3000,TimeUnit.MILLISECONDS);
        }
        scheduledExecutorService.shutdown();

        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                60,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        for (int i = 0; i < 22; i++) {
            threadPoolExecutor.execute(new Task());
        }
        threadPoolExecutor.shutdown();


    }
}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行任务");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "任务执行结束");
    }
}
