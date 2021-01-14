package com.bearfamily.DynamicProxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object targetObj;
    private Interceptor interceptor;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Method [] methods = targetObj.getClass().getMethods();
        //满足拦截器before的拦截逻辑，则执行after(),否则执行目标对象的反射方法

        if(interceptor.before(targetObj))
        {
            interceptor.after(targetObj);
        }else{
            method.invoke(targetObj,args);
        }




        return null;
    }
}
