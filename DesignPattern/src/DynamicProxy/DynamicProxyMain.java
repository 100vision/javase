package DynamicProxy;

import StaticProxy.ProxySubject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyMain {
    public static void main(String[] args) throws Throwable {

        //从MyInterface接口字节流中获取代理类的Class字节流
        Class proxyClass = Proxy.getProxyClass(MyInterface.class.getClassLoader(), MyInterface.class);

        //反射：使用反射获取代理类的constructor构造器
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);

        //反射：使用构造器创建一个代理类的实例对象
        MyInterface proxyInstance = (MyInterface) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                MyInterface realSubject = new RealSubject();
                Object result = method.invoke(realSubject);
                return result;
            }
        });

        proxyInstance.dosomething();



    }
}








