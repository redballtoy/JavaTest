package Multithreading.part_02;


//Пример совместно работающих потоков

public class VolatileTest {

    private static int myInt = 0;

    public static void main(String[] args) {

        //создадим два потока в классах которые будем запускать
        new ChangeListener().start();
        new ChangeMaker().start();

    }

    //это класс слушателя который будет реагировать на
    //события в другом потоке (на изменение статической переменной)
    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int localVar = myInt;
            System.out.println("ChangeListener t1, myInt=" + myInt);
            while (myInt < 5) {
               //если наша локальная переменная успела обновиться
                if (localVar != myInt) {
                    System.out.println("Изменилась myInt=" + myInt);
                    //обновляем значение нашей переменной
                    localVar = myInt;
                }


            }
        }



    }

    //создает изменения
    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int localVar = myInt;
            while (myInt < 5) {
                myInt = ++localVar;
                System.out.println("ChangeMaker t2, myInt=" + myInt);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }




}
