package com.bearfamily.MultiThreading.WaitAndNotify;
import java.util.*;


/**
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580911915042
 * 线程协同 wait() 和notify(),notifyall()
 * 小结
 *
 * wait和notify用于多线程协调运行：
 *
 *     在synchronized内部可以调用wait()使线程进入等待状态；
 *
 *     必须在已获得的锁对象上调用wait()方法；
 *
 *     在synchronized内部可以调用notify()或notifyAll()唤醒其他等待线程；
 *
 *     必须在已获得的锁对象上调用notify()或notifyAll()方法；
 *
 *     已唤醒的线程还需要重新获得锁后才能继续执行。
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var q = new TaskQueue();
        var ts = new ArrayList<Thread>();
        for (int i=0; i<5; i++) {
            var t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }
        var producerThread = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
            }
        });
        producerThread.start();
        producerThread.join();
        Thread.sleep(100);
        for (var t : ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);

        //通知唤醒在wait()方法上的所有消费者线程
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {

            //如果队列为空，则所有执行getTask()方法的线程到此阻塞等待，并释放锁（这样其他线程（生产者线程）则可以拿到锁）
            this.wait();
        }
        return queue.remove();
    }
}

