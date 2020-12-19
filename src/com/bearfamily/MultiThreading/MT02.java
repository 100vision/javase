package com.bearfamily.MultiThreading;
import java.lang.Thread;

/*
learn to gracefully stop a thread
 */

public class MT02 {
    public static void main(String[] args)  {

        //create another thread with highest priority - 10
        MyThread2 t1 = new MyThread2();
        Thread t2 = new Thread(t1);
        t2.setName("t1");
        t2.start();

        System.out.println(t2.getName()+",i need you stop in 5 sec!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //set the boolean to a 'false' to stop a running thread.
        t1.isRuning = false;






    }
}

class MyThread2 implements Runnable {

    boolean isRuning = true;

    @Override
    public void run() {


        for (int i = 0; i < 10000; i++) {

            if (isRuning) {

                System.out.println(Thread.currentThread().getName() + "--->" + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                return;
            }
        }
    }
}









