package Multithreading.part_02;


//Пример совместно работающих потоков

public class VolatileTest {

    private volatile static int myInt = 0;

    public static void main(String[] args) {

        //создадим два потока в классах которые будем запускать
        new ChangeListener().start();
        new ChangeMaker().start();

    }

    //это класс слушателя который будет реагировать на
    //события в другом потоке (на изменение статической переменной)
    //к сожалению статическая переменная может меняться отдельно к кеше каждого из
    //потоков что может привести к их рассинхронизации
    //если методы пометить как синхронизированные то будет потеряна параллельность выполнения
    //решением является указание volatile для переменных в общей памяти, это указывает что
    //работа с ней будет вестись напрямую а не из кеша каждого потока (т.е. это поля с которыми
    // теоретически будет взаимодействие из разных потоков)
    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int localVar = myInt;
            System.out.println("t1 ChangeListener, myInt=" + myInt);
            while (localVar < 5) {
               //если наша локальная переменная успела обновиться
                if (localVar != myInt) {
                    System.out.println("t1 Изменилась myInt=" + myInt);
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
                System.out.println("t2 ChangeMaker, myInt=" + myInt);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }




}
