package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lesson_04;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber_v2 {

    private  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ваша задача угадать число");
        int range = 10;
        int guessNumber = new Random().nextInt(range);
        System.out.println("Угадайте число от 0 до " + range);
        playLevel(range,guessNumber);
        scanner.close();
    }
    private static void playLevel(int range, int guessNumber){
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
