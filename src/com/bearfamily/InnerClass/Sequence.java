package com.bearfamily.InnerClass;

/**
 * 学习内部类的使用和迭代器模式。例子代码来自《JAVA编程思想》page 192的。
 * 内部类型封装了一个数组对象
 */
public class Sequence {
    //定义一个对象数组作为容器
    private Object[] items;

    private int next = 0;

    //构造方法（构造出一个数组
    public Sequence (int size) {this.items = new Object[size]; }

    public void add(Object x) {
        if(next < items.length) {
            items[next++] = x;
        }
    }

    //定义一个内部类（内部类可以引用他的外部类的所有属性。这个内部类其实是一个迭代器
    //在本例中，内部类的所有方法都引用了items数组对象
    private class SequenceSelector implements Selector //Selector是迭代器接口
     {

        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {if(i < items.length)  i++; }
    }

    //开放一个公用方法来构造一个内部类迭代器
    public Selector selector() {
        return  new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i=0;i<10;i++) {sequence.add(Integer.toString(i));}

        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() +" ");
            selector.next();
        }


    }



}
