package JavaCoreProfessional.hw_03_04;

/*
 * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C)
 * 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
 */


public class hw_03_04_01_notWork {
    public static void main(String[] args) {
        TypewritterABC typewritterABC = new TypewritterABC();
        Typist typistA = new Typist(typewritterABC, "A", "B", "t1");
        Typist typistB = new Typist(typewritterABC, "B", "C", "t2");
        Typist typistC = new Typist(typewritterABC, "C", "A", "t3");

        Thread t1 = new Thread(typistA);
        Thread t2 = new Thread(typistB);
        Thread t3 = new Thread(typistC);

        t1.start();
        t2.start();
        t3.start();

    }
}

class TypewritterABC {
    private static String checkLetter = "A";

    public synchronized void printLetter(String treadName, String printLetter, String nextLetter) {
        if (!printLetter.equals(checkLetter)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(treadName + ": " + checkLetter );
            checkLetter = nextLetter;
            notifyAll();
        }
    }
}

class Typist implements Runnable {
    private TypewritterABC typewritterABC;
    private String printLetter;
    private String nextLetter;
    private String treadName;
    private int countLetter = 15;
    private volatile int currentCount = 0;

    public Typist(TypewritterABC typewritterABC,
                  String printLetter,
                  String nextLetter,
                  String treadName) {
        this.typewritterABC = typewritterABC;
        this.printLetter = printLetter;
        this.nextLetter = nextLetter;
        this.treadName = treadName;
    }


    @Override
    public void run() {
        for (currentCount=0; currentCount < countLetter; currentCount++) {
            typewritterABC.printLetter(treadName, printLetter, nextLetter);
        }

    }
}



