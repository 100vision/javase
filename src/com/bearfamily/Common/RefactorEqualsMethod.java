package com.bearfamily.Common;

public class RefactorEqualsMethod {

    public static void main(String[] args) {

        Product p1 = new Product("A01","Apple iPhone 7plus",10);
        Product p2 = new Product("A01","Apple iPhone 7plus",10);
        Product p3 = p1;

        //ԭ����hascode�������ݶ�����ڴ��ַ���������hashcode(int���ͣ���
        //���ҵ����Ҫ�����Ҫ�õ���ͬͬ��hashcode����Ҫ��дhashcode()����
        System.out.println(p1.hashCode());  //��ӡ��142666848
        System.out.println(p1.hashCode());  //��ӡ��142666848


        //equals�����Ǹ������ö�����ڴ��ֵַ�Ƚϣ�ʹ�õ���==�ȽϷ������ǱȽ������Ķ���ֵ��object1 == object2��
        //���ҵ����Ҫ����Ҫ�Ƚ϶����ֵ����Ҫ��дequals����
        System.out.println("p1��== p2:" + (p1 == p2));   //���false
        System.out.println("p1�Ƿ�equals p2:" + p1.equals(p2));  //���false
        System.out.println("p1�Ƿ�equals p3:" + p1.equals(p3)); //���true
        System.out.println("hello"=="hello");


    }
}
