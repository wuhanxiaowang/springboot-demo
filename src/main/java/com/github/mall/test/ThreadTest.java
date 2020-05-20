package com.github.mall.test;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/25 9:21
 * @ModifyDate 2019/9/25 9:21
 * @Version 1.0
 */
public class ThreadTest extends Thread {
    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        t.start();


    }

    @Override
    public void run() {
        System.out.println("我是线程" + this.getName());
    }
}
