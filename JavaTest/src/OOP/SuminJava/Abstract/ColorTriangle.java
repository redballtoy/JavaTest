package OOP.SuminJava.Abstract;

//использование final вместе с классами запрещает наследоваться от него

public final class ColorTriangle extends Triangle {
    protected String color;


    public ColorTriangle(){
        super();
        color = "White";
    }

    public ColorTriangle(double a, double b, double c, String color) {
        super(a, b, c);
        this.color=color;
    }

    public ColorTriangle(double size, String color) {
        super(size);
        this.color = color;
    }

    public ColorTriangle(String color) {
        super();
        this.color = color;
    }

    @Override
    public void printFigure() {
        System.out.printf("\n%s треугольник со сторонами a = %f, b= %f, c= %f имеет площадь s= %f",
                color,a,b,c,area());
    }
}
