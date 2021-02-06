package com.bearfamily.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyMain {
    public static void main(String[] args) {
        Greeting proxy = (Greeting) Proxy.newProxyInstance(Greeting.class.getClassLoader(), new Class[] {Greeting.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("sayHi"))
                {
                    method.invoke(this,args);
                }
                return null;
            }
        });

        proxy.sayHi("Tim");
    }
}
