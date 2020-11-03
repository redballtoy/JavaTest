package OOP.SuminJava.Abstract;

public class Triangle extends Figure {

    protected double c;

    public Triangle() {
        super();
        this.c = 10;
    }

    public Triangle(double a, double b, double c) {
        super(a, b);
        this.c = c;
    }

    public Triangle(double size) {
        super(size);
        this.c = size;
    }

    @Override
    //Расчет площади треугольника по площади Герона
    public double area() {
        double p = (a + b + c) / 2;
        double s = p * (p - a) * (p - b) * (p - c);
        return Math.sqrt(s);
    }

    @Override
    public void printFigure() {
        System.out.printf("\nТреугольник со сторонами a = %f, b= %f, c= %f имеет площадь s= %f",
                a,b,c,area());
    }

}
