package JavaCoreAdvanced.lesson_01.OOP;

public class Polimorfizm {

    public static void main(String[] args) {
        Shape shapeCircle = new Circle();
        Shape shapeTriangle = new Triangle();
        testPoly(shapeCircle);
        testPoly(shapeTriangle);

    }

    public static void testPoly(Shape shape) {
        shape.draw();
    }

}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }
}
