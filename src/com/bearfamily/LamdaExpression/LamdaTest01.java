package com.bearfamily.LamdaExpression;

/*
练习：lamda表达式。lamda表达式其实是一个匿名方法，没有方法名，只有方法体；
使用场景：语法糖，使用代码更简洁，主要用来实现那些单方法的接口。例如Runnable接口
 */

import jdk.swing.interop.SwingInterOpUtils;

public class LamdaTest01 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

                 System.out.println(Thread.currentThread().getName() + "使用Lambda实现接口Runnable");

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName() + "使用普通的匿名方法实现接口Runnable");
            }
        });



        (new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        })).start();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
