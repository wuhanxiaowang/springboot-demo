package com.github.mall.test;

/**
 * @ClassName SignleDemo
 * @Description 懒汉式单例
 * @Author 王炎
 * @Date 2019/10/18 16:22
 * @ModifyDate 2019/10/18 16:22
 * @Version 1.0
 */
public class SignleDemo {

    private SignleDemo() {

    }

    private volatile static SignleDemo signleDemo = null;

    public static SignleDemo getInstance() {
        if (signleDemo == null) {
            synchronized (SignleDemo.class) {
                if (signleDemo == null) {
                    signleDemo = new SignleDemo();
                }
            }
        }

        return signleDemo;

    }

    public static void main(String[] args) {
        SignleDemo s1 = SignleDemo.getInstance();
        SignleDemo s2 = SignleDemo.getInstance();
        if (s1 == s2) {
            System.out.println(1);
        }
    }
}
