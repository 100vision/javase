package StaticProxy;
/*
   静态代理模式。创建一个代理类来代替真实类，不修改真实类的基础上来实现某些附加增强功能。
   实现原理是代理类和真实类继承同一接口
 */
public class ProxySubject implements Subject{

    Subject subject;
    @Override
    public void dosomething() {
        //call realObject method to do same job
        subject.dosomething();

        //make proxy do something else
        dosomethingelse();
    }

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    public void dosomethingelse() {

        System.out.println("hello,doing something else...");
    }
}
