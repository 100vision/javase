package com.bearfamily.Collections.Queues.LinkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用Linkedlist实现队列FIFO先进先出
 * 因为Linkedlist实现了接口Queue
 */

public class LinkedListOper {

    public static void main(String[] args) {

        //新建一个队列
        Queue<String> q = new LinkedList<>();

        //向队列添加元素
        q.offer("Apple");
        q.offer("Banana");
        q.offer("Watermelon");

        System.out.println(q.poll());   //输出 第一个元素，"Apple"并删除，还有remove()方法，但队列为空时，poll()返回null,remove返回异常
        System.out.println(q.poll()); //输出 第2个元素，"Apple"
        System.out.println(q.poll());  //输出 第3个元素，"Apple"
        System.out.println(q.poll());  //队列已空，输出 null
        System.out.println(q.isEmpty());  //输出true




    }
}
