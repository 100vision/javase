package com.bearfamily.MultiThreading.CompletableFuture;

//CompletableFuture，
//这是一种非阻塞异步任务类型，用来创建异步的线程任务。改任务类型不会阻塞主线程, 可以提交到线程池执行，默认使用系统守护进程池ForkJoinPool.commonPool()

import java.util.concurrent.*;

public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {

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

        //创建1个异步任务（默认提交到JVM的守护进程），
        // 如果需要返回值，使用supplyAsync()，它的传参要是一个方法（该方法有返回值）;
        // 如果不需要返回值，可以使用runAsync();
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(CompletableFutureTest::getDoubleValue,threadPool);

        //获取异步任务的返回值。可能会阻塞主线程，主线程要等待get()完成；
        Double price = future.get();

        //如果异步任务执行成功
        future.thenAccept((result) -> {
            System.out.println("price: " + result);
        });

        //如果异步任务执行出现错误
        future.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        //让主线程等待200ms, 否则异步任务提交到的守护进程会立即关闭，导致异步任务无法完成。
        Thread.sleep(200);

        //主线程打印异步任务的返回值
        System.out.println("main thread is printing the price :" + price);
    }

    //异步方法。
    public static Double getDoubleValue()  {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random() <0.3) {
            throw new RuntimeException("Failed to get a Double value");
        }
        return 5 + Math.random()*20;
    }

}
