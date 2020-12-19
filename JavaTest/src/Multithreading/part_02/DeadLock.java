package Multithreading.part_02;

//Первый объект ждет что освободится второй а второй что первый
//такая ситуация называется dead lock
/*
    One держит lock1...
    Two держит lock2...
    One ждут lock2...
    Two ждут lock1...
*/


public class DeadLock {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        DeadThreadOne one = new DeadThreadOne();
        one.start();
        DeadThreadTwo two = new DeadThreadTwo();
        two.start();

    }

    static class DeadThreadOne extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("One держит lock1...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("One ждут lock2...");
                synchronized (lock2) {
                    System.out.println("One держит lock1 и lock2 ...");
                }
            }
        }
    }

    static class DeadThreadTwo extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Two держит lock2...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Two ждут lock1...");
                synchronized (lock1) {
                    System.out.println("Two держит lock1 и lock2 ...");
                }
            }
        }
    }


}
