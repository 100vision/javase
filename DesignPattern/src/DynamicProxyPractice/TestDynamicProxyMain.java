package DynamicProxyPractice;
import java.lang.reflect.Proxy;

/*
Spring 基于切面编程AOP动态代理模式（底层是反射原理），使用切面编程和使用代理的好处和使用场景：
1、不改变类代码的情况下，给类的增强功能。通过给目标类添加一个代理类，使用代理类来包装和增强类。不改变的类的可能原因有：
目标类是官方类，不允许更改。遵守开闭原则。“对修改关闭，对扩展开放”。
2、目标类很多，要给所有目标类添加功能，不能都修改。

实现原理：反射
1、通过反射把目标类的接口的字节码class，并生成一个有构造器的字节码class作为代理类。从而获取到目标类的所有方法。
2、再构造出一个代理对象，对对象增强功能。可以使用反射构造器或是Proxy类的静态方法newProxyInstance直接返回代理类的实例。
3、最后调用目标类的方法。动态代理不像静态代理模式直接调用目标类的方法，使用一个InvocationHandler接口来间接调用。
4、通过一个类来实现InvocationHandler接口并重写invoke方法，注入到proxy实例中，调用目标类方法和增强代码。来给目标类扩展功能完成切面。


 */

public class TestDynamicProxyMain {
    public static void main(String[] args) {
        //创建一个目标类对象
        IAccountService accountService = new AccountServiceImpl();
        //System.out.println("Real object is doing add calculation,the sum is : " +accountService.getSum(5,10));
        ProxyHandler handler = new ProxyHandler();
        IAccountService proxyInstance = (IAccountService)handler.getProxyInstance(accountService);

        //代理实例开始工作
        int proxyInstanceSum = (int)proxyInstance.getSum(5, 10);
        System.out.println(proxyInstanceSum);


    }


}
