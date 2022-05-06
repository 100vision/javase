package com.bearfamily.Async;

//异步编程
/*使用场景
异步编程意味着在主线程之外创建一个独立的线程，
与主线程分隔开，并在上面运行一个非阻塞的任务，然后**通知**主线程进展，成功或者失败

### 实现方式

- [一、通过创建新线程](https://www.jb51.net/article/218715.htm#_label0)
- [二、通过线程池](https://www.jb51.net/article/218715.htm#_label1)
- [三、通过@Async注解](https://www.jb51.net/article/218715.htm#_label2)
- [四、通过CompletableFuture](https://www.jb51.net/article/218715.htm#_label3)
*/

import java.util.concurrent.CompletableFuture;

public class AsyncTest {
    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<Double> future = CompletableFuture.supplyAsync(AsyncTest::getStockPrice);

        //如果异步任务执行成功
        future.thenAccept((result -> System.out.println("price: " + result)));

        future.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        //主线程睡200ms不要立即结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);

    }


    //异步任务，通常是一个耗时的任务
    static Double getStockPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("failed to get stock price");
        }
        return 5+ Math.random()*20;
    }
}
