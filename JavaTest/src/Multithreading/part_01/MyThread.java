package Multithreading.part_01;

public class MyThread extends Thread {
    //для старта выполнения потока и кода в нем используетмя переопределенный метод run
    @Override
    public void run() {
        //переопределяя метод мы  пишем код который должен выполняться
        for (int i = 0; i < 10; i++) {
            System.out.print(i+" ");
        }
    }
}
