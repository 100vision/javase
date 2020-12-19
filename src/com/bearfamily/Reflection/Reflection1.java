package com.bearfamily.Reflection;

import java.lang.reflect.Method;

public class Reflection1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        try {
            Class c1 = Class.forName("com.bearfamily.Reflection.Student");
            Object obj = c1.newInstance();
            Method[] methods =c1.getMethods();
            for(Method method:methods) {
                System.out.println(method.getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
