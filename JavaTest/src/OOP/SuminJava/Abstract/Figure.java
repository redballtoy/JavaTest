package OOP.SuminJava.Abstract;

/*Абстрактный класс
    - создается что бы он был просто родительским для других и на основе него
        нельзя было создать объект
    Так же он создается если в нем есть методы не имеющие реализацию но которые должны быть
      реализованы потомками (например здесь метод area который для обобщенной фигуры не имеет
      смысла
*/

/*Использование final
    - для переменной когда хотим что бы ее значение больше не менялось
    - для метода что бы его нельзя было переопределить у потомка
    - для класса что бы от него нельзя было наследоваться
*/


public abstract class Figure {
    protected double a;
    protected double b;

    public Figure(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Figure(double sizes) {
        a = sizes;
        b = sizes;
    }

    public Figure() {
        a = b = 10;
    }

    public abstract double area();

    public abstract void  printFigure();

    //что бы запретить переопределять методы надо указать final


    public final double getA() {
        return a;
    }

    public final double getB() {
        return b;
    }
}
