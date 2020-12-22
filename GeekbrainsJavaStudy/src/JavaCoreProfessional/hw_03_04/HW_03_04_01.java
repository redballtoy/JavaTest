package JavaCoreProfessional.hw_03_04;

public class HW_03_04_01 {
    public static void main(String[] args) {
        Typewritter typewritter = new Typewritter();
        TypistA typistA = new TypistA(typewritter);
        TypistB typistB = new TypistB(typewritter);
        TypistC typistC = new TypistC(typewritter);

        Thread t1 = new Thread(typistA);
        Thread t2 = new Thread(typistB);
        Thread t3 = new Thread(typistC);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Typewritter {
    private static volatile String letter = "A";
    private int ia = 0;
    private int ib = 0;
    private int ic = 0;

    public int getIa() {
        return ia;
    }

    public int getIb() {
        return ib;
    }

    public int getIc() {
        return ic;
    }

    public synchronized void printLetterA() {
        if (printLetter("A", "B", "t1")) {
            ia++;
            //System.out.println("printLetterA = "+ia+"letter = "+letter);
        }
    }

    public synchronized void printLetterB() {
        if (printLetter("B", "C", "t2")) {
            ib++;
            //System.out.println("printLetterB = "+ib+"letter = "+letter);
        }
    }

    public synchronized void printLetterC() {
        if (printLetter("C", "A", "t3")) {
            ic++;
            //System.out.println("printLetterC = "+ic+"letter = "+letter);
        }
    }

    private boolean printLetter(String currentLetter, String nextLetter, String threadName) {
        if (!currentLetter.equals(letter)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        } else {
            System.out.println(threadName + ": " + currentLetter);
            letter = nextLetter;
            notifyAll();
            return true;
        }
    }
}

class TypistA implements Runnable {
    Typewritter typewritter;
    private int countLetter =5;


    public TypistA(Typewritter typewritterABC) {
        typewritter = typewritterABC;
    }

    @Override
    public void run() {
        while (typewritter.getIa()<countLetter) {
            typewritter.printLetterA();
        }
    }
}
class TypistB implements Runnable {
    Typewritter typewritter;
    private int countLetter =5;


    public TypistB(Typewritter typewritterABC) {
        typewritter = typewritterABC;
    }

    @Override
    public void run() {

        while (typewritter.getIb()<countLetter) {
            typewritter.printLetterB();
        }
    }
}
class TypistC implements Runnable {
    Typewritter typewritter;
    private int countLetter =5;


    public TypistC(Typewritter typewritterABC) {
        typewritter = typewritterABC;
    }

    @Override
    public void run() {
        while (typewritter.getIc()<countLetter) {
            typewritter.printLetterC();
        }
    }
}