package DynamicProxy;

import java.util.Random;

public class Bird implements Flyable{

    @Override
    public void fly() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("The bird is flying...");
        Thread.sleep(new Random().nextInt(1000));
        long endTime = System.currentTimeMillis();
        System.out.println("Flying time =" + (endTime-startTime));

    }
}
