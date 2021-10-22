package Factory;

/*
工厂模式：通过工厂模式来创建对象，取代new 。把创建对象的任务转移到工厂。
实现重点：
1. 一个超类作为工厂的返回对象。超类可以是接口，抽象类、父类。
2. 工厂根据参数类型返回不同的子类实例（对象）
 */

public class SimpleFactoryTest {

    public static void main(String[] args) {

        //使用工厂AnimalFactory实例对象
        Animal dog = AnimalFactory.CreateAnimal("dog");
        Animal duck = AnimalFactory.CreateAnimal("duck");
        Animal bird = AnimalFactory.CreateAnimal("bird");

        //不同对象的具体实现
        dog.move();
        duck.move();
        bird.move();

    }



}


//AnimalFactory是实例化对象的工厂
class AnimalFactory {
    public static Animal CreateAnimal(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {return  new Dog();}
        else if ("Duck".equalsIgnoreCase(animalType)) {return  new Duck();}
        else if ("Bird".equalsIgnoreCase(animalType)) {return  new Bird();}
        return null;
    }
}

//超类：接口（可以是接口、父类、抽象类）
interface Animal {
    void move();
}

//具体实现类
class Dog implements Animal {

    @Override
    public void move() {
        System.out.println("Dog is running...");
    }
}

class Duck implements Animal {

    @Override
    public void move() {
        System.out.println("Duck is quacking...");
    }
}

class Bird implements Animal {

    @Override
    public void move() {
        System.out.println("Bird is flying...");
    }
}


