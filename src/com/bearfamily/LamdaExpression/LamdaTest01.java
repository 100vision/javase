package com.bearfamily.LamdaExpression;

/*
��ϰ��lamda���ʽ��lamda���ʽ��ʵ��һ������������û�з�������ֻ�з����壻
ʹ�ó������﷨�ǣ�ʹ�ô������࣬��Ҫ����ʵ����Щ�������Ľӿڡ�����Runnable�ӿ�
 */

import jdk.swing.interop.SwingInterOpUtils;

public class LamdaTest01 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

                 System.out.println(Thread.currentThread().getName() + "ʹ��Lambdaʵ�ֽӿ�Runnable");

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName() + "ʹ����ͨ����������ʵ�ֽӿ�Runnable");
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
