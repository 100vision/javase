package com.bearfamily.Async;

//�첽���
/*ʹ�ó���
�첽�����ζ�������߳�֮�ⴴ��һ���������̣߳�
�����̷ָ߳�����������������һ��������������Ȼ��**֪ͨ**���߳̽�չ���ɹ�����ʧ��

### ʵ�ַ�ʽ

- [һ��ͨ���������߳�](https://www.jb51.net/article/218715.htm#_label0)
- [����ͨ���̳߳�](https://www.jb51.net/article/218715.htm#_label1)
- [����ͨ��@Asyncע��](https://www.jb51.net/article/218715.htm#_label2)
- [�ġ�ͨ��CompletableFuture](https://www.jb51.net/article/218715.htm#_label3)
*/

import java.util.concurrent.CompletableFuture;

public class AsyncTest {
    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<Double> future = CompletableFuture.supplyAsync(AsyncTest::getStockPrice);

        //����첽����ִ�гɹ�
        future.thenAccept((result -> System.out.println("price: " + result)));

        future.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        //���߳�˯200ms��Ҫ��������������CompletableFutureĬ��ʹ�õ��̳߳ػ����̹ر�:
        Thread.sleep(200);

    }


    //�첽����ͨ����һ����ʱ������
    static Double getStockPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("failed to get stock price");
        }
        return 5+ Math.random()*20;
    }
}
