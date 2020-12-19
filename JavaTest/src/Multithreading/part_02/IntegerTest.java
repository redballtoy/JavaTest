package Multithreading.part_02;

public class IntegerTest {
    private static Integer n = new Integer(0);
    private static long SLIP_MS = 1000;


    public static void main(String[] args) {

        //создаем три потока, которые синхронизтруются по одному объекту n
        new Thread(() -> {
            synchronized (n) {
                n++; //при добавлении этих строк потоки начинают выполняться параллельно потому что
                    //якобы объект становится другой и они все захватывают мониторы у разных объектов
                try {
                    System.out.println("t1_start, n="+n);
                    Thread.sleep(SLIP_MS);
                    System.out.println("t1_finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (n) {
                n++;
                try {
                    System.out.println("t2_start, n="+n);
                    Thread.sleep(SLIP_MS);
                    System.out.println("t2_finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (n) {
                n++;
                try {
                    System.out.println("t3_start, n="+n);
                    Thread.sleep(SLIP_MS);
                    System.out.println("t3_finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

}
