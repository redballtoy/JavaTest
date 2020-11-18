package OOP.Geekbrains;

public class Instanceof {
    public static void main(String[] args) {
        String s = "Hello";
        int i = 1;
        String string = null;
        if (s instanceof String) {
            System.out.println("s is a String");
        }
        if ((Integer) i instanceof Integer) {
            System.out.println("int is Integer");
        }
        if (string instanceof String) {
            System.out.println("s is a String");
        }
    }
}
