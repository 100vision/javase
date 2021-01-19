package com.bearfamily.MultiThreading.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
使用线程池。
来自廖雪峰的JAVA教程：
https://www.liaoxuefeng.com/wiki/1252599548343744/1306581130018849
Java语言虽然内置了多线程支持，启动一个新线程非常方便，但是，创建线程需要操作系统资源（线程资源，栈空间等），频繁创建和销毁大量线程需要消耗大量时间。

那么我们就可以把很多小任务让一组线程来执行，而不是一个任务对应一个新线程。这种能接收大量小任务并进行分发处理的就是线程池。

简单地说，线程池内部维护了若干个线程，没有任务的时候，这些线程都处于等待状态。如果有新任务，就分配一个空闲线程执行。如果所有线程都处于忙碌状态，新任务要么放入队列等待，要么增加一个新线程进行处理。
 */
public class ThreadpoolMain {
    public static void main(String[] args) {
        //创建一个固定大小的线程池
        /*
            FixedThreadPool：线程数固定的线程池；
            CachedThreadPool：线程数根据任务动态调整的线程池；
            SingleThreadExecutor：仅单线程执行的线程池。

         */
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i=0;i<6;i++) {
            es.submit(new Task("" +i));
        }

        //关闭线程池
        es.shutdown();

    }
}


//创建线程任务类
class Task implements Runnable{

    private final String name;

    Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending task " + name);
    }
}
