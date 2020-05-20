package com.github.mall.thread;

import com.github.mall.entity.Person;
import com.github.mall.util.PersonRestAPIUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: wy
 * @Date: 2020/2/14 14:36
 * @Description:
 */
public class PersonBusiness {
    public static void main(String[] args) {
        //构建100个用户列表
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ids.add(String.valueOf(i));
        }
        List<Person> signleThreadQueryPersons = signleThreadQueryPersons(ids);
        System.out.println(signleThreadQueryPersons);

        List<Person> concurrentQueryPerson = concurrentQueryPerson(ids);
        System.out.println(concurrentQueryPerson);

    }

    //单线程查询
    public static List<Person> signleThreadQueryPersons(List<String> ids) {
        long start = System.currentTimeMillis();
        List<Person> personList = new ArrayList<>();
        for (String id : ids) {
            Person person = PersonRestAPIUtil.queryPersonFromAPI(id);
            personList.add(person);
        }
        long end = System.currentTimeMillis();
        System.out.println("单线程耗时：" + (end - start));
        return personList;
    }

    //多线程查询
    public static List<Person> concurrentQueryPerson(List<String> ids) {
        long start = System.currentTimeMillis();
        List<Person> personList = new ArrayList<>();
        //构建查询多个用户的任务列表
        List<Callable<Person>> tasks = new ArrayList<>();
        for (String id : ids) {
            QueryPersonTask queryPersonTask = new QueryPersonTask(id);
            tasks.add(queryPersonTask);
        }
        //并发运行多个任务,获取并发结果
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        List<Future<Person>> futures = new ArrayList<>();
        try {
            futures = threadPoolExecutor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Future<Person> ret : futures) {
            Person person;
            try {
                person = ret.get();
                if (null != person) {
                    personList.add(person);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        threadPoolExecutor.shutdown();
        System.out.println("多线程耗时:" + (end - start));
        return personList;

    }

}
