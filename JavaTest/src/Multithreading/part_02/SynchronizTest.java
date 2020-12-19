package Multithreading.part_02;

public class SynchronizTest {
    private int id;

    public SynchronizTest(int id) {
        this.id = id;
    }

    public synchronized void  firstMeth() {
        System.out.printf("o%d.first - starting\n", id);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.printf("o%d.first-%d\n", id, i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("o%d.first - stopping\n", id);
    }
    public synchronized void secondMeth() {
        System.out.printf("o%d.second - starting\n", id);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.printf("o%d.second-%d\n", id, i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("o%d.second - stopping%n", id);
    }

}

//Для того что бы можно было синхронизировать методы разныз объектов
//необходмимо указать относительно какогого объекта будет проводиться
//синхронизация, и для этого добавляется блок синхронизации с передачей в него объекта
class SynchronizTestInproved {
    private int id;

    public SynchronizTestInproved(int id) {
        this.id = id;
    }

    public void  firstMeth() {
        synchronized (Object.class) {
            System.out.printf("oi%d.first - starting\n", id);
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.printf("oi%d.first-%d\n", id, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("oi%d.first - stopping\n", id);
        }
    }
    public void secondMeth() {
        synchronized (SynchronizTestInproved.class) {
            System.out.printf("oi%d.second - starting\n", id);
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.printf("oi%d.second-%d\n", id, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("oi%d.second - stopping%n", id);
        }
    }

}

class StartText {
    public static void main(String[] args) {
        SynchronizTest o1 = new SynchronizTest(1);
        SynchronizTest o2 = new SynchronizTest(2);

        //вариант запуска одного метода в два потока параллельно
        //для последовательного выполнения для метода надо указать
        // public synchronized void  firstMeth() {
        //new Thread(o1::firstMeth).start();
        //new Thread(o1::firstMeth).start();

        //запуск разных методов
        /* public synchronized void  firstMeth() {
        *  public void secondMeth() {
        * для такого варианта будет выполняться параллельно
        * */
        //new Thread(o1::firstMeth).start();
        //:: упрощенный вариант лямбды, можно записать
        //new Thread(()->o1.secondMeth()).start();

        //для последовательного выполнения оба метода дожны быть synchronized
        //public synchronized void  firstMeth() {
        //public synchronized void secondMeth() {
        //new Thread(o1::firstMeth).start();
        //new Thread(o1::secondMeth).start();

        //для разных объектов даже с синхронайхом будет выполняться параллельно
        //потому что у них разные мониторы
        //new Thread(o1::firstMeth).start();
        //new Thread(o2::firstMeth).start();

        //для синхронизации в методов в разных объектах надо
        //в теле метода указать что при запуске метода будет заблокирован
        //класс объекта определенного типа

        SynchronizTestInproved oi3 = new SynchronizTestInproved(3);
        SynchronizTestInproved oi4 = new SynchronizTestInproved(4);

        //теперь методы будут выполняться последовательно у разных объектов
        //но будет блокировка на уровне самого высокого класса Object
        //new Thread(oi3::firstMeth).start();
        //new Thread(oi4::firstMeth).start();

        //для второго метода указали сан класс SynchronizTestInproved что будет
        //приводить к его блокировке и последовательному выполнению потоков
        new Thread(oi3::secondMeth).start();
        new Thread(oi4::secondMeth).start();

        //если метод следать статическим и вызывать его из двух потоков
        //обратившись в одном через лямбду а в другом через имя класса
        //будет выполняться последовательно поскольку будет блокировать сам себя
        //и пока первый поток не отпустит второй не начнет







    }
}
