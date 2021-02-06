package DynamicProxyPractice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

    private Object targetObj;

    public Object getProxyInstance(Object targetObj) {
        this.targetObj = targetObj;
        return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(), targetObj.getClass().getInterfaces(), this);

    }

    @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            //代理类的增强代码在目标类的方法之前执行这里开始（AOP切面编程代码
            System.out.println("this is enhancement code block archived by proxy instance ");

            //执行真实目标类的方法和返回值
            Object returnObjectOfMethod = method.invoke(targetObj,args);
            return returnObjectOfMethod;

            //代理类的增强代码在目标类的方法之后执行这里开始（AOP切面编程代码
        }
    }

