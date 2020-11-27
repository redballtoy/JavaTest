package Multithreading.part_01;

public class SynchronizeThreads_03 {
    private static final int STEPS = 5000;
    private int counter;

    public static void main(String[] args) {

        //Будем заполнять counter с использованием двух потоков
        SynchronizeThreads_03 synchTest = new SynchronizeThreads_03();
        Thread t1 = new Thread(() -> synchTest.incCounter());
        Thread t2 = new Thread(() -> synchTest.incCounter());

        //запускаем
        t1.start();
        t2.start();

        //необходимо дождаться выполнения потоков прежде чем двигаться дальше
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //результат увеличения
        System.out.println(synchTest.counter);


        //запись в одну переменную двумя потоками на большом количестве записей
        synchTest.counter = 0;
        Thread t3 = new Thread(()-> synchTest.incCounterBig());
        Thread t4 = new Thread(()-> synchTest.decCounterBig());

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Чем больше будет значение STEP тем больше будет вероятность отклонения
        //это связано с тем что при коллизии записи в один и тот же момент времени
        //будет ссхранено значения не того потока которое в данный момент должно было
        //применится а то которое в данный момент времени пришло последним из двух
        System.out.println("Результат добавления уменьшения counter двумя потоками");
        System.out.println(synchTest.counter);

        //поэтому при работе с одним объектом все потоки являются блокирующими и могут работать
        //только на чтение или запись а не то и другое
        //для решения задачи надо развести оперции записи/чтения и для этого используется синхронизация

        //методы синхронизируются в том объекте в котором они находятся
        //в любом объекте есть так называемый монитор относительно которого происходит синхронизация -
        // поток захватывает монитор и для других потоков он становится недоступен в этом синхронизация
        // потоки начнут выполняться синхронно и используются только в случае если есть вероятность коллизии



    }

    public void incCounter(){
        counter++;
        System.out.println(counter + " промежуточное");
    }

    //для устранения ошибки отклонения синхронизируем работу методов
    public synchronized void incCounterBig(){
        for (int i = 0; i < STEPS; i++) {
            counter++;
        }
    }
    public synchronized void decCounterBig(){
        for (int i = 0; i < STEPS; i++) {
            counter--;
        }
    }

}
