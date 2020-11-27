package Multithreading.part_01;

public class SomeThreadsTesting_02 {
    public static void main(String[] args) {
        //Создание новых потоков нужно создавать только вторым способом

        // 1. Способ создать класс MyThread и отнаследовать его от Thread (плохо работает)
        //создаем потоки от нашего класса
        Thread myThread_01 = new MyThread();
        Thread myThread_02 = new MyThread();

        //запускаем потоки методом start который будет вызывать метод run
        //данные потоки будут вызываться асинхронно и мы не контролировали порядок их действия
        //поэтому вывод будет вперемешку например так:
        //0 0 1 1 2 3 4 2 5 3 6 7 8 9 4 5 6 7 8 9
        myThread_01.start();
        myThread_02.start();

        //2 способ использовать интерфейс Runnable
        //функциональный интерфейс Runnable имеет одини метод run и он передается в
        //в конструктор класса Thread

        Thread myThread_2_01 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }, "A");

        Thread myThread_2_02 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }, "B");

        //можно использовать лямбду без создания объекта
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }

        }, "C").start();

        myThread_2_01.setPriority(1);
        myThread_2_02.setPriority(1);
        System.out.println("\nСтарт 2 способа:");
        myThread_2_01.start();
        myThread_2_02.start();


    }
}