package OOP.SuminJava.Inheritance;

public class Main {
    public static void main(String[] args) {
        CatFamily cat = new Cat();
        CatFamily lion = new Lion();
        System.out.println(cat + " " + cat.eat());
        System.out.println(lion + " " + lion.eat());

    }
}
