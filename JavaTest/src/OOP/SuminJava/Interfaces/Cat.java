package OOP.SuminJava.Interfaces;

public class Cat extends  Animal implements Runnable {
    @Override
    public void eat() {
        System.out.println("Кошка ест Вискас");
    }

    @Override
    public void run() {
        System.out.println("Кошка умеет бегать");
    }
}
