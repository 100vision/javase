package com.bearfamily.Annotation;
/*

Retrieve class annotation info by using Java Reflection
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.bearfamily.Annotation.MyClass");
        if(c1.isAnnotationPresent(MyAnnotation1.class))
        {
            MyAnnotation1 myAnnotation1 = (MyAnnotation1)c1.getAnnotation(MyAnnotation1.class);
            String  name = myAnnotation1.name();
            String number = myAnnotation1.number();
            System.out.println(name+"--->"+number);
        }


    }
}
