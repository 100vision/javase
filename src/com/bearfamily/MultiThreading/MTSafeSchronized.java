package com.bearfamily.MultiThreading;

/*
practice threading safe mechanism - disable
 */

public class MTSafeSchronized {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(10000,5000);
        Thread t1 = new BankAccountThread(bankAccount);
        Thread t2 = new BankAccountThread(bankAccount);
        t1.setName("T1");
        t2.setName("T2");
        t1.start();
        t2.start();


    }

}

class BankAccount {

    private double balance;
    private double withdrawal;

    public BankAccount(double balance, double withdrawal) {
        this.balance = balance;
        this.withdrawal = withdrawal;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }



    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public BankAccount(double balance) {
        this.balance = balance;
    }


    public void withdraw(double money)
        {
            // Threading synchronization starts in this block.
            synchronized (this) {
                double balance_bef = this.getBalance();
                double balance_after = balance_bef - money;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.setBalance(balance_after);

            }

        }

    }

class BankAccountThread extends Thread {

    BankAccount bankAccount;

    public BankAccountThread(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }

    public void run(){
        bankAccount.withdraw(bankAccount.getWithdrawal());
        System.out.println(Thread.currentThread().getName()+" withdraws "+ bankAccount.getWithdrawal()+"...Current balance is :"+bankAccount.getBalance());


    }
}











