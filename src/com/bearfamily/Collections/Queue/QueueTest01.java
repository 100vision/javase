package com.bearfamily.Collections.Queue;


import java.util.LinkedList;
import java.util.Queue;

public class QueueTest01 {

    public static void main(String[] args) {

    /*
    LinkedList实现了Queue,也实现了List接口。
    实例化时向上转型Queue，这个LinkedList实例就是Queue；
    实例化时向上转型List时，这个LinkedList实例就是List；较灵活
     */

       Queue<String> queue = new LinkedList<String>();

       //添加3个元素到队列
       queue.offer("a");
       queue.offer("b");
       queue.offer("c");

//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());


        //peek方法获取后不删除
        System.out.println(queue.peek());  //输出a
        System.out.println(queue.peek()); //输出a
        System.out.println(queue.peek()); //输出a


    }





}
