package com.bearfamily.MultiThreading.BlockingQueue;

import java.util.concurrent.*;

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Product> queue = new LinkedBlockingQueue<>(1);

        //产品
        Product p1 = new Product("1","Dell Desktop Oplex 7000MT");

        //生产者任务
        Producer producer = new Producer(queue,p1);
        Consumer consumer = new Consumer(queue);

        //使用2个普通线程运行任务；
        new Thread(producer).start();
        new Thread(consumer).start();

        //使用线程池测试
/*
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.submit(producer);
        threadPool.submit(consumer);

        Thread.sleep(1000);
        threadPool.shutdown();
*/

    }
}

//产品
class Product {
    private  String id;
    private  String name;

    Product(String id, String name) {
        this.id=id;
        this.name=name;
    }

    public String getProductName() {
        return this.name;
    }

}

//生产者类
class Producer implements Runnable {

    private BlockingQueue queue;
    private Product product;
    Producer(BlockingQueue<Product> queue,Product product) {
        this.queue = queue;
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            //判断队列是否是空的。测试目的
            if(queue.isEmpty()) {

                System.out.println("队列空, " +Thread.currentThread().getName() + "开始生产一个");
                try {

                    //放入队列（即生产）。如果队列满了，该方法会等待和阻塞后面的任务；
                    queue.put(product);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("当前队列已满！暂停生产");
            }

        }
    }
}

//消费者类
class Consumer implements Runnable {

    private BlockingQueue queue;

    public Consumer(BlockingQueue<Product> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //模拟慢消费
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "开始消费" );

                //取出产品，并从队列删除。如果队列是空，则阻塞。
                Product product = (Product) queue.take();
                System.out.println(Thread.currentThread().getName() + "消费完毕一个"+ product.getProductName() );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
