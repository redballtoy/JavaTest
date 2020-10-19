package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lesson_03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW_03_01_WordGame_monolit {

    private static String[] words = {
            "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
            "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //компьютер загадывает слово
        Random random = new Random();
        int ran = random.nextInt(words.length);
        String hiddenWord = words[ran];
        int attemptsMax = random.nextInt(hiddenWord.length() - 2) + 2;
        System.out.println("Test: было загадано: " + hiddenWord);
        String attemptsName = (attemptsMax < 5) ? "попытки" : "попыток";

        //отгадываем слово
        System.out.printf("Угадайте слово за %d %s\n", attemptsMax, attemptsName);
        int attempts = 0;
        System.out.printf("В этом слове %d букв и начинается оно на \"%c\"\n", hiddenWord.length()
                , hiddenWord.charAt(0));

        System.out.print(":");
        String testWord = null;
        char[] wordPattern = new char[hiddenWord.length()];
        for (int i = 0; i < hiddenWord.length(); i++) {
            wordPattern[i] = '#';
        }

        while (true) {
            testWord = scanner.nextLine();
            if (testWord.length() != hiddenWord.length()) {
                System.out.println("Количество символов не совпадает с исходным");
            }
            for (int i = 0; i < testWord.length(); i++) {
                for (int j = 0; j < wordPattern.length; j++) {
                    if (testWord.charAt(i) == hiddenWord.charAt(j) && wordPattern[j] == '#') {
                        wordPattern[j] = testWord.charAt(i);
                    }
                }
            }
            attempts++;
            if (testWord.equals(new String(hiddenWord)) && attempts <= attemptsMax) {
                attemptsName = (attempts < 5) ? "попытки" : "попыток";
                System.out.printf("Ура! Вы угадали за %d %s\n", attempts, attemptsName);
                hasContinue();
            } else {

                if (attempts < attemptsMax) {
                    System.out.println("Попробуйте еще раз:");
                    System.out.println(new String(wordPattern));
                    attemptsName = (attemptsMax - attempts < 5) ? "попытки" : "попыток";
                    System.out.printf("Осталось %d %s\n:", attemptsMax - attempts, attemptsName);
                } else {
                    System.out.println("Игра окончена!");
                    System.out.println("Было загадано слово: " + hiddenWord);
                    hasContinue();
                }
            }
        }
    }

    static void hasContinue() {
        System.out.println("Хотите продолжить, y/n?");
        if (scanner.nextLine().charAt(0) == 'n') {
            System.exit(0);
        }
    }
}
