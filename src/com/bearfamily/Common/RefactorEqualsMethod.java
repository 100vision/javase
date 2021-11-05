package com.bearfamily.Common;

public class RefactorEqualsMethod {

    public static void main(String[] args) {

        Product p1 = new Product("A01","Apple iPhone 7plus",10);
        Product p2 = new Product("A01","Apple iPhone 7plus",10);
        Product p3 = p1;

        //原生的hascode方法根据对象的内存地址计算出来的hashcode(int类型）。
        //如果业务需要，如果要得到不同同的hashcode，需要重写hashcode()方法
        System.out.println(p1.hashCode());  //打印出142666848
        System.out.println(p1.hashCode());  //打印出142666848


        //equals方法是根据引用对象的内存地址值比较，使用的是==比较符，不是比较真正的对象值（object1 == object2）
        //如果业务需要，需要比较对象的值，需要重写equals方法
        System.out.println("p1是== p2:" + (p1 == p2));   //输出false
        System.out.println("p1是否equals p2:" + p1.equals(p2));  //输出false
        System.out.println("p1是否equals p3:" + p1.equals(p3)); //输出true
        System.out.println("hello"=="hello");


    }
}
