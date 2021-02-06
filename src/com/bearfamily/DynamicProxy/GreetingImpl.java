package com.bearfamily.DynamicProxy;

public class GreetingImpl implements Greeting {
    @Override
    public void sayHi(String name) {
        System.out.println("hello"+" "+name);
    }
}
