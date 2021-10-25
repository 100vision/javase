package Factory;

public class SimpleFactoryReflectionTest {

    public static void main(String[] args) {

        Shape circle = InstanceFactory.getInstance(Circle.class);
        Shape retangle = InstanceFactory.getInstance(Retangle.class);
        Shape square = InstanceFactory.getInstance(Square.class);

        circle.draw();
        retangle.draw();
        square.draw();

    }

}

/*
 Instance Factory using Reflection and Simply Factory method.
 */
class InstanceFactory {

    public static < T extends Shape> T getInstance(Class<T> shapeClass) {

        try {

            //ʹ�÷��䣺ʹ�ô����Classʵ�����ֽ�����󣩣���������1��ʵ��
            Shape shape = shapeClass.newInstance();
            //��Shape shape = (Shape) Class.forName(shapeClass.getName()).newInstance();


            //ǿת
            return (T)shape;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }


}

interface  Shape {
    void draw();
}


// Concret class "Circle"
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Concret class "Retangle"
class Retangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing a Retangle");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

