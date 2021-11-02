package com.bearfamily.Generic;

/*
������ϰ֮������

�����е��������ģ�塣

һ�����͵�ʹ�ó���

1. ������Ҫ�����������������Ͳ�ȷ����ʱ�򣬹�ȥʹ�� Object �������չ��JDK 1.5���Ƽ�ʹ�÷����������չ��ͬʱ��֤��ȫ�ԡ�
2. ����������Ҫһ�����ݵİ�װ�࣬ͨ�����벻ͬ���͵����ݣ����Դ洢��Ӧ���͵����ݡ���������õ�ʹ�ó������ǡ�Ԫ�顱��ʹ�á�����֪������return����ֵֻ�ܷ��ص�������
������Ƕ���һ�������࣬����2������3�����Ͳ�������������return�����ʱ�򣬹�������һ����Ԫ�顱���ݣ�ͨ�����ʹ����������������ǾͿ���һ���Է�����������ˡ�

 ����ע�⣺
 1. ���Ͳ���ʹ�û����������ͣ�int,long�ȣ�����Ϊ��Ҫ�������������͵ĸ���Object.

 2.��ϰ��

 �ࣺ�������ͣ�Object�ࣩ�ͻ�����������

 3. ����ͨ���

 �����н緺�͡�

 ������������ͨ�����ʽ��

1.<?>������ͨ���

2.<? extends E> extends �ؼ������������͵��Ͻ磬��ʾ�����������Ϳ�������ָ�������ͣ������Ǵ����͵����ࡣ

3.<? super E> super �ؼ������������͵��½磬��ʾ���������Ϳ�����ָ�����ͣ������Ǵ����͵ĸ��ࡣ
 ͨ����Ƚ�

������ͨ��� < ?> �� Object ��Щ���ƣ����ڱ�ʾ�����ƻ��߲�ȷ����Χ�ĳ�����

< ? super E> �������д���Ƚϣ�ʹ�ö������д�븸���͵�������ʹ�ø����͵ıȽϷ�������Ӧ�����������

< ? extends E> ��������ȡ��ʹ�÷������Զ�ȡ E �� E �����������͵���������

 */
public class GenericClassTest {
    public static void main(String[] args) {

        //DataHolder<Integer,Integer> dataHolder = new DataHolder<>(10,20);
        //��������Ϊ���ݰ�װ�࣬�ڱ���������װPerson��Computer
        DataHolder<Person,Computer> combo = ReturnComboData();


        //ȡ���������װ�Ķ������
        Person p = combo.GetDataX();
        Computer c = combo.GetDataY();

        p.GetName();
        c.GetName();

        System.out.println("hello" instanceof String);


    }

    //��������Ϊ���ݰ�װ�࣬�ڱ���������װPerson��Computer������������������͵Ķ�����������һ�����ݷḻ�Ķ���
    static DataHolder<Person,Computer> ReturnComboData() {
        return new DataHolder<>(new Person("tim"),new Computer("DELL Latitude"));
    }
}



//����һ�������ࣨ�����洢������Ͷ�����Ԫ�棩
class DataHolder<X,Y> {

    private X x;
    private Y y;


    DataHolder(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    X GetDataX() {
        return x;
    }


    Y GetDataY() {
        return y;
    }
}

class Person {

    private  String name;

    Person(String name) {
        this.name = name;
    }

    public void GetName() {
        System.out.println("My name is:" + name);
    }


}

class Computer {

    private String name;
    Computer(String name) {
        this.name = name;
    }

    public void GetName() {
        System.out.println("My name is:" + name);
    }
}


