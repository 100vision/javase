package com.bearfamily.MultiThreading.BlockingQueue;

import java.util.concurrent.*;

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Product> queue = new LinkedBlockingQueue<>(1);

        //��Ʒ
        Product p1 = new Product("1","Dell Desktop Oplex 7000MT");

        //����������
        Producer producer = new Producer(queue,p1);
        Consumer consumer = new Consumer(queue);

        //ʹ��2����ͨ�߳���������
        new Thread(producer).start();
        new Thread(consumer).start();

        //ʹ���̳߳ز���
/*
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.submit(producer);
        threadPool.submit(consumer);

        Thread.sleep(1000);
        threadPool.shutdown();
*/

    }
}

//��Ʒ
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

//��������
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
            //�ж϶����Ƿ��ǿյġ�����Ŀ��
            if(queue.isEmpty()) {

                System.out.println("���п�, " +Thread.currentThread().getName() + "��ʼ����һ��");
                try {

                    //������У���������������������ˣ��÷�����ȴ����������������
                    queue.put(product);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("��ǰ������������ͣ����");
            }

        }
    }
}

//��������
class Consumer implements Runnable {

    private BlockingQueue queue;

    public Consumer(BlockingQueue<Product> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //ģ��������
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "��ʼ����" );

                //ȡ����Ʒ�����Ӷ���ɾ������������ǿգ���������
                Product product = (Product) queue.take();
                System.out.println(Thread.currentThread().getName() + "�������һ��"+ product.getProductName() );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
