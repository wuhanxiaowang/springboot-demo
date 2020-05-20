package com.github.mall.test;

/**
 * @Auther: wy
 * @Date: 2020/5/13 11:53
 * @Description:
 */
public class TestDemo {
    String name;
    public TestDemo() {
    }

    public TestDemo(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TestDemo testDemo1=new TestDemo("wang");
        TestDemo testDemo2=new TestDemo("wang");



    }
}
