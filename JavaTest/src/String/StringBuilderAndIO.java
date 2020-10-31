package String;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StringBuilderAndIO {

    public static void main(String[] args) throws IOException {

        //String
        /*
        long t1 = System.currentTimeMillis();
        String a = "";
        for (int i = 0; i < 120000; i++) {
            a += "w";
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1); //4646
        */

        //String Builder
        /*
        long t3 = System.currentTimeMillis();
        StringBuilder b = new StringBuilder("");
        for (int i = 0; i < 120000; i++) {
            b.append("w");
        }
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3); //1
        */


        StringBuilder sb = new StringBuilder();
        sb.append(23);
        sb.append("строка");
        System.out.println(sb); //момент объединения в строку


        //Считывать и вывод из файла
        //1 способ через абсолютный путь - не самый лучший вариант
        File file1 = new File("D:\\aaa\\myProg\\Projects\\JavaTest\\JavaTest\\src\\String\\test.txt");
        //2 способ относительный вариант
        StringBuilder stringBuilder = new StringBuilder();
        File file2 = new File("JavaTest/src/String/test.txt"); //работает только относительно проекта
        FileInputStream fileInputStream = new FileInputStream(file2);

        int n; //номер в таблице юникода
        while ((n = fileInputStream.read())!=-1) { //читаем и присваиваем байт пока не дойдем до конца -1
            stringBuilder.append((char) n);
        }
        System.out.println(stringBuilder.toString());


    }
}
