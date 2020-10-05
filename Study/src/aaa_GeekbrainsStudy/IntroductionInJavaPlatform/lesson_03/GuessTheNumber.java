package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lesson_03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ваша задача угадать число");
        int range = 15;
        int guessNumber = new Random().nextInt(range);
        System.out.println("Угадайте число от 0 до " + range);
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
        scanner.close();
    }
}
