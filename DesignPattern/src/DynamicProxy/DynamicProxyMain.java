package DynamicProxy;

public class DynamicProxyMain {
    public static void main(String[] args) throws InterruptedException {

        Bird bird = new Bird();
        BirdProxy proxy=new BirdProxy(bird);
        proxy.fly();



    }
}
