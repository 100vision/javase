package com.bearfamily.MultiThreading;
import java.lang.Thread;

/*

   learn threading priority
 */

public class MT01 {
    public static void main(String[] args) {

        //set a lowest priority for main thread
        Thread.currentThread().setPriority(1);

        //create another thread with highest priority - 10
        Thread t1 = new Thread(new MyThread());
        t1.setName("t1");
        t1.setPriority(10);
        t1.start();


        for(int i=1;i<10000;i++)
        {
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }
    }
}

class MyThread implements Runnable{


    @Override
    public void run() {
        for(int i=1;i<10000;i++)
        {
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }
    }
}
