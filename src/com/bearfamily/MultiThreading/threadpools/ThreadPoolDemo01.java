package com.bearfamily.MultiThreading.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo01 {

    public static void main(String[] args) {

        //固定线程数的线程池，例如5个
        //ExecutorService es = Executors.newFixedThreadPool(5);

        //不固定线程数的线程池。线程池有空闲的线程则复用，如果没有,则开启新线程
        ExecutorService es = Executors.newCachedThreadPool();
        MyThreadTask task = new MyThreadTask();

        for (int i=0;i<10;i++)

            //提交10次任务到线程池
            es.submit(task);

    }




}

class MyThreadTask implements Runnable {
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() +" Thread ID:"+ Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
