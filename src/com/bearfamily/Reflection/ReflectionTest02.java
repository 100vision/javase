package com.bearfamily.Reflection;

import java.lang.reflect.Method;

public class ReflectionTest02 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        //��ȡһ���ֽ������Ͷ���ķ���
        //����1��ʹ��������ֱ�ӻ�ȡһ���ֽ������Ͷ�����Class��һ��ʵ��������򵥵ķ�ʽ��ȡһ��Class����
        Class c1 = String.class;
        String s1 = (String)c1.newInstance();

        //����2��ʹ��Class�ľ�̬����forname���������������String��
        Class c2 = Class.forName("Java.lang.String");

        //��ȡ���з���
        Method [] methods = c1.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());

        }

    }

}
