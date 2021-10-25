package Factory;

/*
�򵥹���ģʽ���ֽ�����̬��������ģʽ��ͨ��һ��������������ȡ��new ���Ѵ������������ת�Ƶ�������
ʵ���ص㣺
1. ����һ��������Ϊ�����ķ��ض��󡣳�������ǽӿڣ������ࡢ���ࡣ
2. �������ݲ������ͷ��ز�ͬ������ʵ��������
 */

public class SimpleFactoryTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        //ʹ�ù���AnimalFactory�е���ͨ��������ʵ������
        Animal dog1 = AnimalFactory.CreateAnimal("dog");
        Animal duck1 = AnimalFactory.CreateAnimal("duck");
        Animal bird1 = AnimalFactory.CreateAnimal("bird");

        //ʹ�ù���AnimalFactory�еķ���������ʵ������
        //Dog.class, Duck.class����һ���ֽ��������
        Animal dog2 = AnimalFactory.getInstance(Dog.class);
        Animal duck2 = AnimalFactory.getInstance(Duck.class);
        Animal bird2 = AnimalFactory.getInstance(Bird.class);
        Animal rat = AnimalFactory.getInstance(Rat.class);


        //��ͬ����ľ���ʵ��
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


//AnimalFactory��ʵ��������Ĺ���
class AnimalFactory {

    //1��ʹ��new�������������󣨲��Ƽ���������չ�������Ҫ����һ�����࣬��Ҫ�޸�if������switch��䣬�����Ͽ���ԭ��
    public static Animal CreateAnimal(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {return  new Dog();}
        else if ("Duck".equalsIgnoreCase(animalType)) {return  new Duck();}
        else if ("Bird".equalsIgnoreCase(animalType)) {return  new Bird();}
        return null;
    }

    /*
    2��ʹ�÷���ͷ�������������ʵ��(�Ƽ�������������չ�����Ҫ����һ���ֻ࣬Ҫͨ�����һ����ʵ�ֽӿڼ��ɿ���չ�������˷���1�����ġ�
       �����͵�ͬ�ڹ�������ģʽ��
     */
    // Class<T> animalClass��һ���ֽ����������Ϊ���ͷ������βΡ�����String.class,����Integer.class
    public static <T extends Animal> T getInstance(Class<T> animalClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Animal animal = null;
        //animal = (Animal)Class.forName(animalClass.getName()).newInstance();
        animal = (Animal)animalClass.newInstance();
        return (T)animal;
    }

}

//���ࣺ�ӿڣ������ǽӿڡ����ࡢ�����ࣩ
interface Animal {
    void move();
}

//����ʵ����
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




