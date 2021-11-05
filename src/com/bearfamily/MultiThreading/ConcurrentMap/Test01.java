package com.bearfamily.MultiThreading.ConcurrentMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 练习：使用线程安全的hashmap --->Concurrenthashmap
 * ConcurrentHashMap内部实现了同步，所以是线程安全的
 */

public class Test01 {
    public static void main(String[] args) throws InterruptedException {

        Map<String,String> map = new ConcurrentHashMap<>(10);

        Thread t1 = new Thread(new Thread1(map));
        Thread t2 = new Thread(new Thread2(map));

        ExecutorService es = Executors.newFixedThreadPool(2);
        for (int i=0;i<10;i++) {
            es.submit(t1);
            es.submit(t2);
        }

        es.shutdown();






    }

}

class Thread1 implements Runnable {
    private  Map<String,String> map;
    public Thread1 (Map<String,String> map) { this.map =map;}


    @Override
    public void run() {
        map.put("t","tim");
        String output = map.get("t");
        System.out.println(Thread.currentThread().getName() + "---->" +output);
    }
}


class Thread2 implements Runnable {

    private  Map<String,String> map;
    public Thread2 (Map<String,String> map) { this.map =map;}

    @Override
    public void run() {
        map.put("t","tom");
        String output = map.get("t");
        System.out.println(Thread.currentThread().getName() + "---->" +output);
    }
}