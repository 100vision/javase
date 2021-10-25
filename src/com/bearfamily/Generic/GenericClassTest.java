package com.bearfamily.Generic;

/*
泛型练习之泛型类

泛型有点类似类的模板。

一、泛型的使用场景

1. 当类中要操作的引用数据类型不确定的时候，过去使用 Object 来完成扩展，JDK 1.5后推荐使用泛型来完成扩展，同时保证安全性。
2. 假设我们需要一个数据的包装类，通过传入不同类型的数据，可以存储相应类型的数据。泛型类最常用的使用场景就是“元组”的使用。我们知道方法return返回值只能返回单个对象。
如果我们定义一个泛型类，定义2个甚至3个类型参数，这样我们return对象的时候，构建这样一个“元组”数据，通过泛型传入多个对象，这样我们就可以一次性方法多个数据了。

 二、注意：
 1. 泛型不能使用基本数据类型（int,long等），因为需要擦除成引用类型的根类Object.

 2.温习：

 类：引用类型（Object类）和基本数据类型

 3. 泛型通配符

 三、有界泛型。

 泛型中有三种通配符形式：

1.<?>无限制通配符

2.<? extends E> extends 关键字声明了类型的上界，表示参数化的类型可能是所指定的类型，或者是此类型的子类。

3.<? super E> super 关键字声明了类型的下界，表示参数化类型可能是指定类型，或者是此类型的父类。
 通配符比较

无限制通配符 < ?> 和 Object 有些相似，用于表示无限制或者不确定范围的场景。

< ? super E> 用于灵活写入或比较，使得对象可以写入父类型的容器，使得父类型的比较方法可以应用于子类对象。

< ? extends E> 用于灵活读取，使得方法可以读取 E 或 E 的任意子类型的容器对象

 */
public class GenericClassTest {
    public static void main(String[] args) {

        //DataHolder<Integer,Integer> dataHolder = new DataHolder<>(10,20);
        //泛型类作为数据包装类，在本例中来包装Person和Computer
        DataHolder<Person,Computer> combo = ReturnComboData();


        //取出泛型类包装的多个对象
        Person p = combo.GetDataX();
        Computer c = combo.GetDataY();

        p.GetName();
        c.GetName();

        System.out.println("hello" instanceof String);


    }

    //泛型类作为数据包装类，在本例中来包装Person和Computer。泛型类包含更多类型的对象，这样返回一个数据丰富的对象。
    static DataHolder<Person,Computer> ReturnComboData() {
        return new DataHolder<>(new Person("tim"),new Computer("DELL Latitude"));
    }
}



//定义一个泛型类（用来存储多个类型对象，做元祖）
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


