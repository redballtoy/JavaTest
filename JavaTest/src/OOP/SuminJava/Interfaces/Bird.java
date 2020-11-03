package OOP.SuminJava.Interfaces;

public class Bird extends  Animal implements Runnable, Flyable {
    @Override
    public void eat() {
        System.out.println("Птица ест птичий корм");
    }

    @Override
    public void run() {
        System.out.println("Птицы умеют бегать");
    }

    @Override
    public void fly() {
        System.out.println("Умеет летать!");
    }
}
