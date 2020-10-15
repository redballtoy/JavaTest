package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lesson_03;

import java.util.Random;
import java.util.Scanner;

public class HW_03_01_WordGame {
    //Инициализация основных переменных
    private static String[] words = {
            "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
            "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static Scanner scanner = new Scanner(System.in);
    static boolean hasGameOn = true;
    static Random random = new Random();

    public static void main(String[] args) {

        while (hasGameOn) {

            //загадываем слово
            String higgenWord = createHiddenWord();
            System.out.println("Test загаданное слово: " + higgenWord);
            showHeader(higgenWord);


            System.out.println("Будешь играть по новой y/n?");
            hasGameOn = hasGame();
            System.out.println(hasGameOn);
        }

   }

    private static void showHeader(String str) {
        System.out.printf("Необходимо угадать слово состоящее из %d букв и начинающееся на %c\n"
                , str.length(), str.charAt(0));
    }

    private static String createHiddenWord() {
        return words[random.nextInt(words.length-1)];
    }

    private static boolean hasGame() {
        String str = scanner.nextLine();
        if (!(str.equals("y") || str.equals("n"))) {
            System.out.println("Повторите ввод");
            while (!(str.equals("y") || str.equals("n"))){
                str=scanner.nextLine();
            }
        }
        return str.equals("y");
    }
}

