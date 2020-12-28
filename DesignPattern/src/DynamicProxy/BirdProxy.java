package DynamicProxy;
/*
Actually this is a practice of static proxy - design pattern
 */

public class BirdProxy implements Flyable{

    Flyable flyable;


    @Override
    public void fly() throws InterruptedException {
        //here is enhancement codes. e.g. print the line:
        System.out.println("we're enhancing the flying method to print logs");

        //we're proxy. so don't forget to call original method to do the same job.
        flyable.fly();


    }

    //Constructor,Composition聚合，Object injection
    public BirdProxy(Flyable flyable) {
        this.flyable = flyable;
    }
}
