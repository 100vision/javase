package Singleton;

/**
 * 单实例模式：
 * 应用场景：工具类。因为在内存中只有一个对象实例，可以节省内存资源.
 * 关键实现点：类构造私有，提供一个对外公用方法获取实例
 * 实现模式：饿模式和懒模式。饿模式：不管内存是否有该实例都创建一个；懒模式：如果不存在则创建实例，否则不创建,
 * 懒模式但要考虑多线程下上锁，否则不能保障单实例。
 */


//饿模式
class Singleton {

    private static Singleton singleton = new Singleton();

    //构造方法私有化，则外部无法new实例
    private Singleton() {};

    //开发公共方法供外部调用实例
    public static Singleton getInstance() {
        return singleton;
    }

    public void hungryMethod() {

        System.out.println("使用了饿模式只创建一个对象实例");

    }

}

class SingletonOperation {
    public static void main(String[] args) {

        //会报异常，如果使用以下：
        // Singleton singleton1 = new Singleton();

        Singleton singleton = Singleton.getInstance();
        singleton.hungryMethod();

        SingletonLazyMode singletonLazyMode = SingletonLazyMode.getInstance();
        singletonLazyMode.LazyMethod();
    }
}


class SingletonLazyMode {

    private static SingletonLazyMode singleton = null;

    //构造方法私有化，则外部无法new实例
    private SingletonLazyMode() {};

    //开发公共方法供外部调用实例. 使用synchronized给方法上锁，否则在多线程下，当一个线程创建了实例，当其他线程也会再创建实例。
    public static synchronized SingletonLazyMode getInstance() {
        if (null == singleton)
        {
            singleton = new SingletonLazyMode();
        }

        return singleton;
    }

    public void LazyMethod() {

        System.out.println("使用了懒模式只创建一个对象实例");

    }

}



