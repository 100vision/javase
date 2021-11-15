package Proxies;

public class ProxyTest01 {
    public static void main(String[] args) {

        ISubject proxy1 = new PasswordCheckProxy(new RealSubject());
        Client c1 = new Client(proxy1);
        c1.consumeSubject();

        System.out.println("-------------------------\n");

        ISubject proxy2 = new SpellingCheckProxy(new RealSubject());
        Client c2 = new Client(proxy2);
        c2.consumeSubject();

    }

}

//核心业务接口
interface ISubject {
    void doSomething();
}

//核心业务类
class RealSubject implements ISubject {

    @Override
    public void doSomething() {
        System.out.println("Real Subjet is doing something now!");
    }
}




//代理类1：给业务类例如添加额外功能：例如密码检查
class PasswordCheckProxy implements ISubject {

    //持有何业务类一样的接口
    private ISubject targetSubject;

    public PasswordCheckProxy(ISubject subject) {
        this.targetSubject = subject;
    }

    @Override
    public void doSomething() {
        before();
        targetSubject.doSomething();
        after();
    }

    protected void before() {
        System.out.println("Password check proxy is doing sth before real subject...");
    }

    protected void after () {
        System.out.println("Password check proxy is dothing sth after real subject");
    }
}


//代理类2：给业务类例如添加额外功能：例如拼写检查

class SpellingCheckProxy implements ISubject {

    //持有何业务类一样的接口
    private ISubject targetSubject;

    public SpellingCheckProxy(ISubject subject) {
        this.targetSubject = subject;
    }

    //覆写业务类的方法：添加增强方法
    @Override
    public void doSomething() {
        enhanceMethod_A();
        targetSubject.doSomething();
        enhanceMethod_B();
    }

    //增强功能1
    protected void enhanceMethod_A() {
        System.out.println("Spelling check proxy is running before real subject...");
    }

    //增强功能2
    protected void enhanceMethod_B () {
        System.out.println("spelling check proxy is enhancing real subject");
    }
}



//调用方
class Client {

    //持有一个业务类的接口
    private ISubject subject;
    public Client (ISubject subject) {
        this.subject = subject;
    }

    public void consumeSubject() {
        subject.doSomething();
    }

}


