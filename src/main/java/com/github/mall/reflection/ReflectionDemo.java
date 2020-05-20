package com.github.mall.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Auther: wy
 * @Date: 2020/2/22 11:10
 * @Description:
 */
public class ReflectionDemo {
    public String name;

    public Integer age;

    public ReflectionDemo() {

    }

    public ReflectionDemo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ReflectionDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void eat(String name, Integer age) {
        System.out.println(name + ",你妈喊你回家吃饭了");
    }

    public void sleep(String name) {
        System.out.println(name + ",睡觉了");
    }

    public void test() {
        System.out.println("测试=========================");
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        String name = "小王";
        /**
         * 生成class类对象的四种方法
         */
        //第一种,getClass()方法
        ReflectionDemo reflectionDemo = new ReflectionDemo();
        Class<? extends ReflectionDemo> demoClass = reflectionDemo.getClass();
        //第二种,class属性
        Class<ReflectionDemo> class2 = ReflectionDemo.class;
        //第三种,Class的forName方法
        Class<?> class3 = Class.forName("com.github.mall.reflection.ReflectionDemo");
        //第四种,类加载器
        //Class<?> class4 = this.getClass().getClassLoader().loadClass("com.github.mall.reflection.ReflectionDemo");

        /**
         * 获取类的指定方法(getDeclaredMethods()获取所有方法,getMethod()只获取public的方法)
         */
        Method eat = demoClass.getMethod("eat", String.class, Integer.class);
        System.out.println("指定方法名称:" + eat.getName());
        //执行方法,第一个参数是执行对象,第二个参数是方法的参数
        eat.invoke(demoClass.newInstance(), name, 12);
        /**
         * 获取public类的所有方法(getDeclaredMethods[]获取所有类的方法,包括private)
         */
        Method[] methods = demoClass.getMethods();
        for (Method m : methods) {
            if (m.getName().equals("eat")) {
                //方法名
                String methodName = m.getName();
                System.out.println("方法名称:" + methodName);
                //方法的入参
                Parameter[] parameters = m.getParameters();
                for (Parameter p : parameters) {
                    System.out.println("方法的入参" + p.getName());
                }
            }
        }

        /**
         * 获取类的public指定属性(getDeclaredField()获取所有)
         */
        Field name1 = demoClass.getField("name");
        System.out.println("指定属性:" + name1.getName());
        /**
         * 获取public类的所有属性(getDeclaredField[]获取所有)
         */
        Field[] fields = demoClass.getFields();
        for (Field f : fields) {
            System.out.println("类的属性:" + f.getName());
        }


    }


}
