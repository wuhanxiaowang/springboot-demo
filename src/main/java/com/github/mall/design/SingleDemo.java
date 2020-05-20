package com.github.mall.design;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.*;

/**
 * @Auther: wy
 * @Date: 2020/3/11 10:52
 * @Description:
 */
public class SingleDemo {
    private SingleDemo() {

    }
    //饿汉式单例,没有线程安全问题，缺点是浪费内存空间
    // private static SingleDemo singleDemo=new SingleDemo();

  /*  public static SingleDemo getSingle(){
        return singleDemo;
    }*/

    //懒汉式单例,线程不安全

    private static SingleDemo singleDemo;

    public static SingleDemo getSingle() {
        System.out.println("线程" + Thread.currentThread().getName() + "在" + DateUtil.now() + "进来创建对象啦!");
        if (singleDemo == null) {
            singleDemo = new SingleDemo();
        }
        return singleDemo;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SingleDemo singleDemo;
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            Future<SingleDemo> submit = fixedThreadPool.submit(new Demo());
            System.out.println("没有get方法");
        }
        fixedThreadPool.shutdown();


    }

}

class Demo implements Callable<SingleDemo> {
    @Override
    public SingleDemo call() throws Exception {
        Thread.sleep(3000);
        return SingleDemo.getSingle();
    }
}
