package com.bearfamily.MultiThreading.threadpools;

import java.util.concurrent.*;

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


        //创建自定义的线程池（推荐）
        //自定义和创建一个有界队列的LinkedBlockingQueue线程池
        ExecutorService threadPool = new ThreadPoolExecutor(
                //核心线程数量
                5,
                //允许最大的线程数
                10,
                2L,
                TimeUnit.SECONDS,

                //使用的阻塞队列
                new LinkedBlockingQueue<>(8),
                //拒绝访问策略
                /**
                 * new ThreadPoolExecutor.AbortPolicy() :AbortPolicy(默认)
                 *      直接抛出RejectedExecutionException异常阻止系统正常运行
                 * DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加人队列中
                 * 尝试再次提交当前任务。
                 * DiscardPolicy：该策略默默地丢弃无法处理的任务，不予任何处理也不抛出异常。
                 * 如果允许任务丢失，这是最好的一种策略。
                 */
                //CallerRunsPolicy：“调用者运行”一种调节机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退到调用者，从而降低新任务的流量。
                new ThreadPoolExecutor.CallerRunsPolicy()

        );

        //提交20个任务到自定义线程池
        for (int i=0;i<20;i++) {
            threadPool.submit(new Task("" +i));
        }

        //关闭线程池
        threadPool.shutdown();



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
        System.out.println("Custom Pool :" + Thread.currentThread().getName() +"Starting task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending task " + name);
    }
}
