package StaticProxy;

public class RealSubject implements Subject{
    @Override
    public void dosomething() {
        System.out.println("hello RealSubject is doing something");
    }
}
