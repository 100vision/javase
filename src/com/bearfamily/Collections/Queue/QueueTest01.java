package com.bearfamily.Collections.Queue;


import java.util.LinkedList;
import java.util.Queue;

public class QueueTest01 {

    public static void main(String[] args) {

    /*
    LinkedListʵ����Queue,Ҳʵ����List�ӿڡ�
    ʵ����ʱ����ת��Queue�����LinkedListʵ������Queue��
    ʵ����ʱ����ת��Listʱ�����LinkedListʵ������List�������
     */

       Queue<String> queue = new LinkedList<String>();

       //���3��Ԫ�ص�����
       queue.offer("a");
       queue.offer("b");
       queue.offer("c");

//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());


        //peek������ȡ��ɾ��
        System.out.println(queue.peek());  //���a
        System.out.println(queue.peek()); //���a
        System.out.println(queue.peek()); //���a


    }





}
