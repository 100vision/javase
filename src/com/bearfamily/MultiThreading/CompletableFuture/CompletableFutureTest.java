package com.bearfamily.MultiThreading.CompletableFuture;

//CompletableFuture��
//����һ�ַ������첽�������ͣ����������첽���߳����񡣸��������Ͳ����������߳�, �����ύ���̳߳�ִ�У�Ĭ��ʹ��ϵͳ�ػ����̳�ForkJoinPool.commonPool()

import java.util.concurrent.*;

public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {

        //�Զ���ʹ���һ���н���е�LinkedBlockingQueue�̳߳�
        ExecutorService threadPool = new ThreadPoolExecutor(
                //�����߳�����
                5,
                //���������߳���
                10,
                2L,
                TimeUnit.SECONDS,

                //ʹ�õ���������
                new LinkedBlockingQueue<>(8),
                //�ܾ����ʲ���
                /**
                 * new ThreadPoolExecutor.AbortPolicy() :AbortPolicy(Ĭ��)
                 *      ֱ���׳�RejectedExecutionException�쳣��ֹϵͳ��������
                 * DiscardOldestPolicy�����������еȴ���õ�����Ȼ��ѵ�ǰ������˶�����
                 * �����ٴ��ύ��ǰ����
                 * DiscardPolicy���ò���ĬĬ�ض����޷���������񣬲����κδ���Ҳ���׳��쳣��
                 * �����������ʧ��������õ�һ�ֲ��ԡ�
                 */
                //CallerRunsPolicy�������������С�һ�ֵ��ڻ��ƣ��ò��ԼȲ�����������Ҳ�����׳��쳣�����ǽ�ĳЩ������˵������ߣ��Ӷ������������������
                new ThreadPoolExecutor.CallerRunsPolicy()

        );

        //����1���첽����Ĭ���ύ��JVM���ػ����̣���
        // �����Ҫ����ֵ��ʹ��supplyAsync()�����Ĵ���Ҫ��һ���������÷����з���ֵ��;
        // �������Ҫ����ֵ������ʹ��runAsync();
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(CompletableFutureTest::getDoubleValue,threadPool);

        //��ȡ�첽����ķ���ֵ�����ܻ��������̣߳����߳�Ҫ�ȴ�get()��ɣ�
        Double price = future.get();

        //����첽����ִ�гɹ�
        future.thenAccept((result) -> {
            System.out.println("price: " + result);
        });

        //����첽����ִ�г��ִ���
        future.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        //�����̵߳ȴ�200ms, �����첽�����ύ�����ػ����̻������رգ������첽�����޷���ɡ�
        Thread.sleep(200);

        //���̴߳�ӡ�첽����ķ���ֵ
        System.out.println("main thread is printing the price :" + price);
    }

    //�첽������
    public static Double getDoubleValue()  {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random() <0.3) {
            throw new RuntimeException("Failed to get a Double value");
        }
        return 5 + Math.random()*20;
    }

}
