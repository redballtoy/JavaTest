package JavaCoreBasic.lesson_02;

import java.util.Scanner;

public class InputFromConsole {
    public static void main(String[] args) {
        //консольный калькулятор:
        System.out.println("Введите операцию:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");

        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        switch (operation) {
            case 1:
                System.out.print(operation + ". Сложение\n");
                break;
            case 2:
                System.out.print(operation + ". Вычитание\n");
                break;
            case 3:
                System.out.print(operation + ". Умножение\n");
                break;
            case 4:
                System.out.print(operation + ". Деление\n");
                break;
        }

        System.out.println("Введите первое число: ");
        int first = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int second = scanner.nextInt();
        float result = 0f;
        String oper = "";

        switch (operation) {
            case 1:
                result = first + second;
                oper = " + ";
                break;
            case 2:
                result = first - second;
                oper = " - ";
                break;
            case 3:
                result = first * second;
                oper = " * ";
                break;
            case 4:
                result = (float) first / (float) second;
                oper = " / ";
                break;
            default:
                System.out.println("Выберите корректный оператор");
        }
        ;
        System.out.println(first + oper + second + " = " + result);
    }
}
