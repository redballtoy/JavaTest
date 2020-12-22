package JavaCoreProfessional.hw_03_04;

/*
* 3. Написать класс МФУ, на котором возможно одновременно выполнять печать и сканирование
* документов, но нельзя одновременно печатать или сканировать два документа.
* При печати в консоль выводится сообщения «Отпечатано 1, 2, 3,... страницы»,
* при сканировании – аналогично «Отсканировано...». Вывод в консоль с периодом в 50 мс.
*
* */


public class HW_03_04_03 {
    public static void main(String[] args) {
        MFU mfu1 = new MFU(3, 5);
        mfu1.startDoing();

    }
}

class MFU {
    private int printCount = 0;
    private int scanCount = 0;
    private final String PRINT = "print";
    private final String SCAN = "scan";

    public MFU(int printCount, int scanCount) {
        this.printCount = printCount;
        this.scanCount = scanCount;
    }

    public void startDoing() {
        if (printCount!=0) print();
        if (scanCount!=0) scan();

    }

    private void print() {
        printAndScan(PRINT);
    }
    private void scan() {
        printAndScan(SCAN);
    }


    private void printAndScan(String whatDoing) {
            Thread t = new Thread(() -> {
                if (whatDoing.equals(PRINT)) {
                    System.out.print("\nОтпечатано: ");
                    for (int i = 1; i <= printCount; i++) {
                        System.out.print(i + ", ");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.print("\nОтсканировано: ");
                    for (int i = 1; i <= scanCount; i++) {
                        System.out.print(i + ", ");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(" страницы");
            });
            t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

