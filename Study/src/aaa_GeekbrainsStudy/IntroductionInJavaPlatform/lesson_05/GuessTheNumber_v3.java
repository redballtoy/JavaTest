package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lesson_05;

import java.util.Random;
import java.util.Scanner;

//добавление уровней
public class GuessTheNumber_v3 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //установка 3-х уровней игры
        System.out.println("Ваша задача угадать число");
        for (int range = 10; range <= 30; range += 10) {
            System.out.println("Угадайте число от 0 до " + range);
            playLevel(range);
        }
        scanner.close();
    }

    private static void playLevel(int range) {
        int guessNumber = new Random().nextInt(range);

        while (true) {
            int input_number = scanner.nextInt();
            if (input_number == guessNumber) {
                System.out.println("Вы угадали!");
                break;
            } else if (input_number > guessNumber) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Загаданное число больше");
            }
        }
    }
}
