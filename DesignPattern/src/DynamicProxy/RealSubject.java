package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RealSubject implements MyInterface {


    @Override
    public void dosomething() {
        System.out.println("RealSubject is doing something...");
    }
}
