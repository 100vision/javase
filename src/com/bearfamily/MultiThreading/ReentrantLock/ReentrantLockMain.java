package com.bearfamily.MultiThreading.ReentrantLock;

//学习使用java.lang.util.concurent中的reentrantlock锁。比Sychronized更安全，不会产生死锁。

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {

    public static void main(String[] args) throws InterruptedException {

        Caculation calc = new Caculation();
        Thread t1 = new AddThread(calc);
        Thread t2 = new SubThread(calc);


        t1.start();
        t2.start();
        t1.join();
        t2.join();



        System.out.println(calc.getResult());

    }








}

class Caculation {

    private Lock lock =new ReentrantLock();

    //实例变量，多线程修改的对象（需要加锁）
    private int result = 0;

    //加
    public void add() {
        lock.lock();
        try {

            for (int i=0;i<Integer.MAX_VALUE;i++) {
                result++;
            }

        } finally {
            lock.unlock();
        }
    }

    //减
    public void sub() {
        lock.lock();
        try {

            for (int i=0;i<Integer.MAX_VALUE;i++) {
                result = result - 1;
            }

        } finally {
            lock.unlock();
        }
    }

    public int getResult() {return  this.result;}




}

class AddThread extends Thread {

    private Caculation calc;

    public AddThread(Caculation calc) {
        this.calc = calc;
    }

    @Override
    public void run() {

        calc.add();
    }
}

class SubThread extends Thread {

    private Caculation calc;

    public SubThread(Caculation calc) {
        this.calc = calc;
    }

    @Override
    public void run() {

        calc.sub();
    }
}
