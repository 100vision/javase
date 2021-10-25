package com.bearfamily.Reflection;

import java.lang.reflect.Method;

public class ReflectionTest02 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        //获取一个字节码类型对象的方法
        //方法1：使用字面量直接获取一个字节码类型对象，是Class的一个实例。是最简单的方式获取一个Class对象
        Class c1 = String.class;
        String s1 = (String)c1.newInstance();

        //方法2：使用Class的静态方法forname方法配合类型名（String）
        Class c2 = Class.forName("Java.lang.String");

        //获取所有方法
        Method [] methods = c1.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());

        }

    }

}
