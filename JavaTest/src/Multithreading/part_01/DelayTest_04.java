package Multithreading.part_01;

public class DelayTest_04 {
    private static final int STEP = 10;
    private static final int DELAY = 500;

    //Можно для синхронизации выбирать не только текузий объект в котором находятся
    //синхронизируемые методы но и любой другой объект, создадим такой
    private Object lock = new Object();



    public static void main(String[] args) {
        DelayTest_04 delayTest_04 = new DelayTest_04();
        //new Thread(() -> delayTest_04.methodA()).start();
        //new Thread(() -> delayTest_04.methodB()).start();

        //старт потоков синхронизированных относительно объекта lock
        //теперь будет использоваться монитор объекта obj
        //если верхние потоки не закомментировать будет все выполняться параллельно потому
        //потому что синхронизация используется для двух объектов this и lock
        System.out.println("Старт потоков синхронизированных по obj");
        new Thread(() -> delayTest_04.methodAsynchrObj()).start();
        new Thread(() -> delayTest_04.methodBsynchrObj()).start();

    }

    public synchronized void methodA() {
        System.out.println("Start method_A " + Thread.currentThread());
        for (int i = 0; i < STEP; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nStop method_A");
    }

    public synchronized void methodB() {
        System.out.println("Start method_B " + Thread.currentThread());
        for (int i = 0; i < STEP; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nStop method_B");
    }

    //Для использования синхронизации относительно другого объекта наобходимо не сигнатуру,
    //а тело метода мометить как synchronized и указать в скобках относительного какого объекта
    //будет производиться синхронизация
    public void methodAsynchrObj() {
        synchronized (lock) {
            System.out.println("Start methodAsynchrObj " + Thread.currentThread());
            for (int i = 0; i < STEP; i++) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\nStop methodAsynchrObj");
        }
    }
    public void methodBsynchrObj() {
        synchronized (lock) {
            System.out.println("Start methodBsynchrObj " + Thread.currentThread());
            for (int i = 0; i < STEP; i++) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\nStop methodBsynchrObj");
        }
    }




}
