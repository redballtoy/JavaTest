package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lesson_04;


import java.util.Random;
import java.util.Scanner;

/*Tik Tac Toe*/
public class TicTacToe {

    //1. constants initialization
    static final int SIZE = 3;
    static final int WIN = 3;

    //set game's chars
    static final char DOT_EMPTY = '•'; //Alt + Num 7
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final char HEADER_FIRST_EMPTY = '♣';
    static final String EMPTY = " ";


    static char[][] gameArea = new char[SIZE][SIZE];

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        startGame();

    }

    private static void startGame() {
        initGameArea();
        printGameArea();
        playGame();

    }

    //2. initialization game area
    private static void initGameArea() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gameArea[i][j] = DOT_EMPTY;
            }

        }
    }

    //3. to output array to the console
    private static void printGameArea() {
        //3.1. header print
        printGameAreaHeader();
        //3.2. print a rows of a game area
        printGameAreaRows();
    }


    private static void printGameAreaHeader() {
        //System.out.println("\n\n");
        System.out.print(HEADER_FIRST_EMPTY + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printOneNumber(i);

        }

    }

    static void printOneNumber(int i) {
        System.out.print((i + 1) + EMPTY);
    }

    private static void printGameAreaRows() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println();
            printOneNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(gameArea[i][j] + EMPTY);
            }
        }
    }

    private static void playGame() {
        while (true) {

            //human
            //make a move
            humanTurn();
            //print map
            printGameArea();
            //check
            checkEnd(DOT_HUMAN);


            //AI
            //make a move
            aiTurn();
            //print map
            printGameArea();
            //check win
            checkEnd(DOT_AI);
        }
    }


    private static void humanTurn() {
        int rowNumber;
        int colNumber;

        do {
            System.out.print("\nВведите номер строки: ");
            rowNumber = scanner.nextInt();
            System.out.print("Введите номер столбца: ");
            colNumber = scanner.nextInt();
        } while (!isCellValid(rowNumber, colNumber, "human"));
        gameArea[rowNumber - 1][colNumber - 1] = DOT_HUMAN;
        System.out.println("\nВаш ход!");
    }

    private static void aiTurn() {
        int rowNumber;
        int colNumber;
        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;
        } while (!isCellValid(rowNumber, colNumber, "ai"));

        gameArea[rowNumber - 1][colNumber - 1] = DOT_AI;
        System.out.println("\n\nХод компьютера!");
    }

    private static boolean isCellValid(int rowNumber, int colNumber, String human_ai) {
        if (rowNumber < 1 || rowNumber > SIZE || colNumber < 1 || colNumber > SIZE) {
            if (human_ai.equals("human")) {
                System.out.println("\nПроверьте правильность ввода");
            }
            return false;
        }
        if (gameArea[rowNumber - 1][colNumber - 1] != DOT_EMPTY) {
            if (human_ai.equals("human")) {
                System.out.println("\nЯчейка непустая");
            }
            return false;
        }
        return true;
    }

    //check win or draw
    private static void checkEnd(char dot) {

        boolean isEnd = false;

        //check Win
        if (checkWin()) {
            printWhoWin(dot);
            System.exit(5);

        }

        //is game area full
        if (isGameAreaFull()) {
            System.out.println("\n\nНичья!");
            isEnd = true;
        }

        //end
        if (isEnd) {
            System.exit(0);
        }
    }

    private static void printWhoWin(char dot) {
        //win or draw
        if (dot == DOT_HUMAN) {
            System.out.println("\n\nУра! Вы победили!");
        } else {
            System.out.println("\n\nПобедил AI!");
        }
    }

    private static boolean isGameAreaFull() {
        for (char[] chars : gameArea) {
            for (char aChar : chars) {
                if (aChar == DOT_EMPTY) {
                    return false;
                }
            }

        }
        return true;
    }


    private static boolean checkWin() {
        int winCheckRow = 0;
        int winCheckCol = 0;
        int winCheckD1 = 0;
        int winCheckD2 = 0;

        //check to rows
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 1; j++) {

                if (gameArea[i][j] != DOT_EMPTY && gameArea[i][j] == gameArea[i][j + 1]) {
                    winCheckRow += 1;
                    if (winCheckRow == WIN - 1) {
                        return true;
                    }
                }

            }
            winCheckRow = 0;
        }
        //check to cols
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE - 1; i++) {

                if (gameArea[i][j] != DOT_EMPTY && gameArea[i][j] == gameArea[i + 1][j]) {
                    winCheckCol += 1;
                    if (winCheckCol == WIN - 1) {
                        return true;
                    }
                }

            }
            winCheckCol = 0;
        }
        //check d1
        for (int i = 0; i < SIZE - 1; i++) {
            if (gameArea[i][i] != DOT_EMPTY && gameArea[i][i] == gameArea[i + 1][i + 1]) {
                winCheckD1 += 1;
                if (winCheckD1 == WIN - 1) {
                    return true;
                }
            }
        }
        winCheckD1 = 0;
        //check d2
        for (int i = SIZE - 1; i > 0; i--) {
            if (gameArea[i][i] != DOT_EMPTY && gameArea[i][i] == gameArea[i - 1][i - 1]) {
                winCheckD2 += 1;
                if (winCheckD2 == WIN - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
