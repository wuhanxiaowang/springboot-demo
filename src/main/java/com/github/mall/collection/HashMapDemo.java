package com.github.mall.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: wy
 * @Date: 2020/5/13 12:41
 * @Description:
 */
public class HashMapDemo {
    public static void main(String[] args) {

        HashMapThread thread0 = new HashMapThread();
        HashMapThread thread1 = new HashMapThread();
        HashMapThread thread2 = new HashMapThread();
        HashMapThread thread3 = new HashMapThread();
        HashMapThread thread4 = new HashMapThread();
       /* thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();*/
       Map<Integer,Integer> map=new HashMap<>();
        Map<Integer, Integer> synchronizedMap = Collections.synchronizedMap(map);



    }


}

class HashMapThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger();
    private static Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void run() {
        while (ai.get() < 1000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }
}