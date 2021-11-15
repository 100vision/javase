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

//����ҵ��ӿ�
interface ISubject {
    void doSomething();
}

//����ҵ����
class RealSubject implements ISubject {

    @Override
    public void doSomething() {
        System.out.println("Real Subjet is doing something now!");
    }
}




//������1����ҵ����������Ӷ��⹦�ܣ�����������
class PasswordCheckProxy implements ISubject {

    //���к�ҵ����һ���Ľӿ�
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


//������2����ҵ����������Ӷ��⹦�ܣ�����ƴд���

class SpellingCheckProxy implements ISubject {

    //���к�ҵ����һ���Ľӿ�
    private ISubject targetSubject;

    public SpellingCheckProxy(ISubject subject) {
        this.targetSubject = subject;
    }

    //��дҵ����ķ����������ǿ����
    @Override
    public void doSomething() {
        enhanceMethod_A();
        targetSubject.doSomething();
        enhanceMethod_B();
    }

    //��ǿ����1
    protected void enhanceMethod_A() {
        System.out.println("Spelling check proxy is running before real subject...");
    }

    //��ǿ����2
    protected void enhanceMethod_B () {
        System.out.println("spelling check proxy is enhancing real subject");
    }
}



//���÷�
class Client {

    //����һ��ҵ����Ľӿ�
    private ISubject subject;
    public Client (ISubject subject) {
        this.subject = subject;
    }

    public void consumeSubject() {
        subject.doSomething();
    }

}


