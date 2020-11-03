package OOP.SuminJava.Interfaces;

public class Dog extends  Animal implements Runnable {

    @Override
    public void eat() {
        System.out.println("Собака ест кость");
    }

    @Override
    public void run() {
        System.out.println("Собака умеет бегать");
    }
}
