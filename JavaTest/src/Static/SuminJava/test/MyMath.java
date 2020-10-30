package Static.SuminJava.test;

public class MyMath {
    public static int square (int number) {
        return number * number;
    }

    public static double square(double number) {
        return number * number;
    }

    public static double lenghtOfCyrcle(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double volumeOfCircle(double radius) {
        return Math.PI * square(radius);
    }

    public static int sumInt(int ...numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }

}
