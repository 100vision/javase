package StaticProxy;

public class StaticProxyMain {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        Subject proxySubject = new ProxySubject(realSubject);
        proxySubject.dosomething();

    }
}
