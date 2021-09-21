package com.bearfamily.MultiThreading.Basis;

public class MultipleThreadingBasis {

    public static void main(String[] args) {
        // write your code here
        Account account = new Account("增加",1000);

        MyThread [] workers = new MyThread[10];

        for (int i=0;i<10;i++)
        {
            workers[i]= new MyThread("thread" +i,account,200);
            workers[i].start();

        }


    }
}

//需要加锁的对象一般是多线程共享对象，一次操作
//只允许一个线程，否则数据会乱。比如以下Account账号对象就是需要保持线程安全。
//在改对象实例上的方法加上sychronized关键字，任何线程先获取到对象锁，才能操作。

class Account {

    private String code;
    private int cash;

    Account(String code, int cash) {
        this.code = code;
        this.cash = cash;
    }

    public synchronized void oper(int x) throws InterruptedException {
        try {
            Thread.sleep(10L);
            this.cash += x;
            System.out.println(Thread.currentThread().getName() + "运行结束，增加了" + x + ",当前账户余额是：" + this.cash);
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();


        }


    }
}


class MyThread extends Thread {

    private Account account;
    private int y = 0;

    MyThread(String name,Account account,int y) {
        super(name);
        this.account = account;
        this.y = y;
    }

    public void run () {
        try {
            account.oper(y);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
