package Multithreading.part_02;

public class ThreadCreateCommon {
    public static void main(String[] args) throws InterruptedException {
        //1 способ через имплементацию Runnable
        //в конструктор Thread поместить класс наследуемый от Runnable который
        //имплементирует метод run
        //можно через анонимный класс
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Выполняющийся поток t1");
            }
        });
        t1.setPriority(10);
        t1.start();
        t1.join();

        //можно через лямбду
        Thread t2 = new Thread(() -> {
            System.out.println("Выполняющийся поток t2");

        });
        t2.setPriority(1);
        t2.start();



        // можно через прямое укание
        class MyRunnableClass implements Runnable {
            @Override
            public void run() {
                System.out.println("Выполняющийся поток t3");

            }
        }
        Thread t3 = new Thread(new MyRunnableClass());
        t3.setPriority(1);
        t3.start();
        t3.join();

        //Демоны это потоки которые выполняются в фоновом режиме
        //чаще всего находятся в режиме ожидания события на которое реагируют
        //его надо в методе перед запуском указать что он демон, после запуска
        //изменить его не получится





    }
}
