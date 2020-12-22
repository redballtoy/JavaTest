package JavaCoreProfessional.hw_03_04;

//2. Написать небольшой метод, в котором 3 потока построчно пишут данные
//в файл (по 10 записей с периодом в 20 мс).


import java.io.*;

public class HW_03_04_02 {


    private static String path="GeekbrainsJavaStudy/src/JavaCoreProfessional/hw_03_04/output_hw2.txt";
    public static PrintWriter printWriter;

    public static void main(String[] args) {

        initPrintWritter();

        printTr("t1",printWriter);
        printTr("t2",printWriter);
        printTr("t3",printWriter);
        printTr("t4",printWriter);

        printWriter.close();

      }

    private static void initPrintWritter() {
        try {
            printWriter = new PrintWriter(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static synchronized void printTr(String str,PrintWriter printWriter) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printWriter.println(str+" "+i);
            }
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //printWriter.println("pause");
        t.start();
    }


}
