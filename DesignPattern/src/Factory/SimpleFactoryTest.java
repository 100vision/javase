package Factory;

/*
����ģʽ��ͨ������ģʽ����������ȡ��new ���Ѵ������������ת�Ƶ�������
ʵ���ص㣺
1. һ��������Ϊ�����ķ��ض��󡣳�������ǽӿڣ������ࡢ���ࡣ
2. �������ݲ������ͷ��ز�ͬ������ʵ��������
 */

public class SimpleFactoryTest {

    public static void main(String[] args) {

        //ʹ�ù���AnimalFactoryʵ������
        Animal dog = AnimalFactory.CreateAnimal("dog");
        Animal duck = AnimalFactory.CreateAnimal("duck");
        Animal bird = AnimalFactory.CreateAnimal("bird");

        //��ͬ����ľ���ʵ��
        dog.move();
        duck.move();
        bird.move();

    }



}


//AnimalFactory��ʵ��������Ĺ���
class AnimalFactory {
    public static Animal CreateAnimal(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {return  new Dog();}
        else if ("Duck".equalsIgnoreCase(animalType)) {return  new Duck();}
        else if ("Bird".equalsIgnoreCase(animalType)) {return  new Bird();}
        return null;
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


