package Factory;

/*
简单工厂模式：又叫做静态工厂方法模式，通过一个工厂创建对象，取代new 。把创建对象的任务转移到工厂。
实现重点：
1. 定义一个超类作为工厂的返回对象。超类可以是接口，抽象类、父类。
2. 工厂根据参数类型返回不同的子类实例（对象）
 */

public class SimpleFactoryTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        //使用工厂AnimalFactory中的普通方法生产实例对象
        Animal dog1 = AnimalFactory.CreateAnimal("dog");
        Animal duck1 = AnimalFactory.CreateAnimal("duck");
        Animal bird1 = AnimalFactory.CreateAnimal("bird");

        //使用工厂AnimalFactory中的反射生产的实例对象
        //Dog.class, Duck.class等是一个字节码类对象
        Animal dog2 = AnimalFactory.getInstance(Dog.class);
        Animal duck2 = AnimalFactory.getInstance(Duck.class);
        Animal bird2 = AnimalFactory.getInstance(Bird.class);
        Animal rat = AnimalFactory.getInstance(Rat.class);


        //不同对象的具体实现
        System.out.println("Creating concret class object using new memthod");
        dog1.move();
        duck1.move();
        bird1.move();

        System.out.println("Creating concret class object using reflection");
        dog2.move();
        duck2.move();
        bird2.move();
        rat.move();
    }



}


//AnimalFactory是实例化对象的工厂
class AnimalFactory {

    //1、使用new对象来生产对象（不推荐！不好扩展，如果需要增加一个新类，需要修改if语句或是switch语句，不符合开闭原则。
    public static Animal CreateAnimal(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {return  new Dog();}
        else if ("Duck".equalsIgnoreCase(animalType)) {return  new Duck();}
        else if ("Bird".equalsIgnoreCase(animalType)) {return  new Bird();}
        return null;
    }

    /*
    2、使用反射和泛型来生产对象实例(推荐！！，方便扩展。如果要增加一种类，只要通过添加一个类实现接口即可可扩展，避免了方法1带来的。
       这样就等同于工厂方法模式。
     */
    // Class<T> animalClass是一个字节码类对象作为泛型方法的形参。例如String.class,或是Integer.class
    public static <T extends Animal> T getInstance(Class<T> animalClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Animal animal = null;
        //animal = (Animal)Class.forName(animalClass.getName()).newInstance();
        animal = (Animal)animalClass.newInstance();
        return (T)animal;
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

class Rat implements Animal {

    @Override
    public void move() {
        System.out.println("Rat is running away...");
    }
}




