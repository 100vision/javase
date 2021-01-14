package com.bearfamily.DynamicProxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
  private final Object targetObj;
  private final Class<?> interfaceClass;
//  private InvocationHandler handler;

  public ProxyFactory(Object obj, Class<?> interfaceClass)
  {
      this.interfaceClass=interfaceClass;
      this.targetObj = obj;
     // this.handler = handler;

//      if (obj.getClass().isInstance(interfaceClass))
//      {
//
//      }
  }

    public Object createProxyInstance()
    {
       return Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                method.invoke(targetObj,args);
                return null;
            }
        });
    }
}
