package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lesson_03;

/*
* Изменение цвета текста в терминале
*/

import java.util.Scanner;

public class Color {

    static final String COLOR_RED = "\u001B[31m";
    static final String COLOR_CYAN = "\u001B[36m";
    static final String COLOR_YELLOW = "\u001B[33m";
    static final String COLOR_BLUE = "\u001B[34m";



    public static void main(String[] args) {
        //печать какой цвет выбрать
        showChoice();

        //вести выбор с консоли
        Scanner scanner = new Scanner(System.in);
        changeColor(scanner.next());


    }

    private static void changeColor(String choise) {
        switch (choise) {
            case "1":
                setColor(COLOR_RED);
                break;
            case "2":
                setColor(COLOR_CYAN);
                break;
            case "3":
                setColor(COLOR_YELLOW);
                break;
            case "4":
                setColor(COLOR_BLUE);
                break;
            case "0":
                doExit();
                break;
            default:
                System.out.println("Вы выбрали неверное значение");
        }
    }

    private static void showChoice() {
        System.out.println("Выберите цвет текста терминала:");
        System.out.println("1. Красный");
        System.out.println("2. Бирюзовый");
        System.out.println("3. Желтый");
        System.out.println("4. Синий");
        System.out.println("0. Выход");
    }

    private static void setColor(String color) {
        System.out.println(color);
    }

    private static void doExit(){
        System.exit(0);
    }
}
