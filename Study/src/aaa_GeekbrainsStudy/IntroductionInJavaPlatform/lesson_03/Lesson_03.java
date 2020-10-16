package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lesson_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lib.MyMath.*;

public class Lesson_03 {
    public static void main(String[] args) {
        //сринги по значению и адресу
        //любое изменение строки приводит к созданию новой строки
        testString();

        //перегрузка методов
        testOverload(3, 6);
        testOverload(3.14f, 5.0f);
        testOverload(7);
        testOverload(3, 8, 5, 2);

        //ввод с консоли
        testConsoleInput();

        //рандомизация
        testRandom();


    }

    private static void testRandom() {
        System.out.println("\n\nРандомизация: ");
        //1 вариант рандомизации
        Random random = new Random();

        int max = 10;
        int[] data1 = new int[30];
        int[] data2 = new int[30];
        for (int i = 0; i <data1.length ; i++) {
            //заполнение первым вариантом
            data1[i] = random.nextInt(12)-5;//-5 +6 (-5 +0 + 6) = 12
            //2 способ рандомизации (получение числа с плавающей точкой от 0 до 1 не включая 1)
            data2[i] = (int) (Math.random() * 12)-5;

        }

        showArraysMaxMinInt(data1,"data1");
        showArraysMaxMinInt(data2,"data2");


    }

    private static void showArraysMaxMinInt(int[] datа, String arrayName) {
        System.out.printf("%s: %s",arrayName, Arrays.toString(datа));
        System.out.printf("\nmin %s = %d",arrayName, minMaxInt(datа,"min"));
        System.out.printf("\nmax %s = %d",arrayName, minMaxInt(datа,"max"));
        System.out.printf("\nlenght %s = %d\n",arrayName, datа.length);
    }

    private static void testConsoleInput() {
        //1 способ
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String name=null;
        int takNelsya = 1;
        //name = reader.readLine();
        System.out.print("Введите число: ");
        try {
            takNelsya = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            takNelsya = 1;
        }
        System.out.println(12/takNelsya);
        //System.out.println("Hello " + name);

        //2 вариант с использованием класса Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение a: ");
        int a = scanner.hasNextInt() ? scanner.nextInt() : 0;
        System.out.print("Введите значение b: ");
        //int b = scanner.hasNextInt() ? scanner.nextInt() : 0;
        int b = 0;
        try {
            b = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("\nВведено некорректное значение");
            //e.printStackTrace();
        }
        testOverload(a, b);
    }

    private static int testOverload(int a, int b) {
        int result = a * b;
        System.out.printf("%d * %d = %d\n", a, b, result);
        return result;
    }

    private static float testOverload(float a, float b) {
        float result = a * b;
        System.out.printf("%.2f * %.2f = %.2f\n", a, b, result);
        return result;
    }

    private static double testOverload(double a) {
        double result = a * a;
        System.out.printf("%.2f * %.2f = %.2f\n", a, a, result);
        return result;
    }

    //неихвестное количество будет переквалифицировано на массив
    private static int testOverload(int... a) {
        int result = 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i : a) {
            stringBuilder.append(" * ");
            stringBuilder.append(i);
            result *= i;
        }
        stringBuilder.deleteCharAt(1);
        System.out.println(stringBuilder + " = " + result);
        return result;
    }

    private static void testString() {
        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java");

        System.out.println("str1==str2= " + (str1 == str2));
        System.out.println("str2==str3= " + (str2 == str3));
        System.out.println("str2.equals(str3)= " + (str2.equals(str3)));
    }


}
