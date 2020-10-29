package OOP.SuminJava;

public class Test extends Box {

    public Test(double width, double height, double lenght) {
        super(width, height, lenght);
    }


    //перегрузка методов (должны иметь разные парамеметры)
    public static int multiple(int a, int b) {
        return a * b;
    }
    public static double multiple(double a, double b) {
        return a * b;
    }

    public static int multiple(int a) {
        return a*a;
    }


}
