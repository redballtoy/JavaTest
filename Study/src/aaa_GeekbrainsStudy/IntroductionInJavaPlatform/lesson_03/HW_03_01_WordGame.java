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
    static char[] wordPattern;

    public static void main(String[] args) {

        while (hasGameOn) {

            //загадываем слово
            String higgenWord = createHiddenWord();
            //System.out.println("Test загаданное слово: " + higgenWord);
            System.out.printf("Необходимо угадать слово состоящее из %d букв и начинающееся на %c\n"
                    , higgenWord.length(), higgenWord.charAt(0));
            int attemptsMax = random.nextInt(higgenWord.length() - 2) + 2;
            System.out.printf("Угадать необходимо с %d попыток\n", attemptsMax);

            //инициализация шаблона
            wordPattern = inicialPatternWord(higgenWord);
            String patternWord = new String(wordPattern);
            int attempts = attemptsMax;

            //сравнение полученных строк
            while (!patternWord.equals(higgenWord) && attempts > 0) {
                //получаем введенное слово, оно должно быть такого же размера как hiddenWork
                System.out.printf("У вас осталось %d попыток\n", attempts--);
                String testWord = getWord(higgenWord.length());
                System.out.println("Вы ввели: " + testWord);
                patternWord = matchesWord(higgenWord, testWord, wordPattern);
                System.out.println(patternWord);
            }

            if (attempts >= 0) {
                System.out.println("Ура вы выиграли");
                System.out.printf("Вы угадали слово %s за %d попытки\n", higgenWord, attemptsMax - attempts);
            } else {
                System.out.println("Вы проиграли :(");
                System.out.println("Загаданное слово: " + higgenWord);
            }


            System.out.println("Будешь играть по новой y/n?");
            hasGameOn = hasGame();
            System.out.println(hasGameOn);
        }

    }

    private static String matchesWord(String higgenWord, String testWord, char[] wordPatternInit) {
        for (int i = 0; i < testWord.length(); i++) {
            for (int j = 0; j < wordPatternInit.length; j++) {
                if (testWord.charAt(i) == higgenWord.charAt(j) && wordPatternInit[j] == '#') {
                    wordPatternInit[j] = testWord.charAt(i);
                }
            }
        }

        wordPattern = wordPatternInit;
        return new String(wordPatternInit);
    }

    private static char[] inicialPatternWord(String higgenWord) {
        char[] wordPattern = new char[higgenWord.length()];
        for (int i = 0; i < higgenWord.length(); i++) {
            wordPattern[i] = '#';
        }
        return wordPattern;
    }

    private static String getWord(int length) {
        String testWord = scanner.nextLine();
        while (length != testWord.length()) {
            System.out.println("Повторите ввод количество символов не совпадает:");
            testWord = scanner.nextLine();
        }
        return testWord;
    }


    private static String createHiddenWord() {
        //System.out.println(words.length - 1);
        //System.out.println(random.nextInt(words.length - 1));
        return words[random.nextInt(words.length - 1)];
    }

    private static boolean hasGame() {
        String str = scanner.nextLine();
        if (!(str.equals("y") || str.equals("n"))) {
            System.out.println("Повторите ввод");
            while (!(str.equals("y") || str.equals("n"))) {
                str = scanner.nextLine();
            }
        }
        return str.equals("y");
    }
}

