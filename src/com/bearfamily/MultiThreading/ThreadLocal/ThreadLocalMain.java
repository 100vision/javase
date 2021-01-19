package com.bearfamily.MultiThreading.ThreadLocal;

/*
线程内部的所有方法之间传递上下文信息（可以看成是“线程局部变量”，可以把ThreadLocal实例：

实际上，可以把ThreadLocal看成一个全局Map<Thread, Object>：每个线程获取ThreadLocal变量时，总是使用Thread自身作为key：

廖雪峰：https://www.liaoxuefeng.com/wiki/1252599548343744/1306581251653666

横跨若干方法调用，需要传递的对象，我们通常称之为上下文（Context），它是一种状态，可以是用户身份、任务信息等。
给每个方法增加一个context参数非常麻烦，而且有些时候，如果调用链有无法修改源码的第三方库，User对象就传不进去了。
Java标准库提供了一个特殊的ThreadLocal，它可以在一个线程中传递同一个对象

注意：使用ThreadLocal要用try ... finally结构，并在finally中清除。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalMain {
    public static void main(String[] args) throws Exception{

        //创建1个线程池（最大3个线程）
        ExecutorService es = Executors.newFixedThreadPool(3);
        List<User> users = new ArrayList<> ();
        users.add(new User("Mark"));
        users.add(new User("Anna"));
        users.add(new User("David"));

        //提交线程到线程池
        users.stream().forEach(x->es.submit(new MyThread(x)));

        //关闭线程池
        es.shutdown();



    }
}


//线程类实现Runnable接口
class MyThread implements Runnable {


    private User user;

    public MyThread(User user){
        this.user=user;
    }

            @Override
            public void run() {

                    try(var context = new ThreadContext(this.user))
                    {

                        new ThreadTask1().dotask1();
                        new ThreadTask2().dotask2();
                        new ThreadTask3().dotask3();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
}

/*
线程上下类。用来封装ThreadLocal(主要是要封装共享对象）
步骤1、把ThreadLocal对象封装到一个上下类实现接口AutoCloseable,实现自动销毁threadlocal.
步骤2、把上下文共享对象user添加到threadloal实例变量中（Map）
 */
class ThreadContext implements AutoCloseable {


    static final ThreadLocal<User> threadContext= new ThreadLocal<>();
    public ThreadContext (User user) {
                threadContext.set(user);
    }

    public static User getUser()
    {
        return threadContext.get();
    }



    @Override
    public void close() throws Exception {
        threadContext.remove();
    }
}

/**
 * 线程任务1、2，3共享一个线程上下文(User对象)
 */

//线程任务1，可以通过封装好的threadLocal获取上下文对象user
class ThreadTask1 {

    public void dotask1() throws InterruptedException {
        Thread.sleep(100);
        System.out.printf("%s is doing task1 on %s \n",Thread.currentThread().getName(),ThreadContext.getUser().getName());
    }

}

//线程任务2,可以通过threadLocal获取上下文对象user
class ThreadTask2 {

    public void dotask2() throws InterruptedException {
        Thread.sleep(100);
        System.out.printf("%s is doing task2 on %s \n",Thread.currentThread().getName(),ThreadContext.getUser().getName());
    }

}

//线程任务3,可以通过threadLocal获取上下文对象user
class ThreadTask3 {

    public void dotask3() throws InterruptedException {
        Thread.sleep(100);
        System.out.printf("%s is doing task3 on %s \n",Thread.currentThread().getName(),ThreadContext.getUser().getName());
    }

}

//一个实体类（线程上下文要共享的对象）
class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}





