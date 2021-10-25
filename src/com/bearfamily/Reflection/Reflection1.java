package com.bearfamily.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/*
Field类，
Method类
Constructor类

Java的反射API提供的Field类封装了字段的所有信息：

通过Class实例的方法可以获取Field实例：getField()，getFields()，getDeclaredField()，getDeclaredFields()；

通过Field实例可以获取字段信息：getName()，getType()，getModifiers()；

通过Field实例可以读取或设置某个对象的字段，如果存在访问限制，要首先调用setAccessible(true)来访问非public字段。

通过反射读写字段是一种非常规方法，它会破坏对象的封装。

 */
public class Reflection1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        try {

            //获取Student的字节码对象,即student.class
            Class c1 = Class.forName("com.bearfamily.Reflection.Student");
            Object obj = c1.newInstance();

            //获取方法对象getMethods()可以获取报铪父类型的所有方法，getdeclaredMethods()获取自己的方法
            Method[] methods =c1.getMethods();
            for(Method method:methods) {
                System.out.println(method.getName());
            }

            //获取filed属性字段

            Field[] fields = c1.getDeclaredFields();
            for(Field f :fields) {
                System.out.println(f.getName());

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
