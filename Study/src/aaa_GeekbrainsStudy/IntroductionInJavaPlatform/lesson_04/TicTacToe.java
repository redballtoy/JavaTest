package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.lesson_04;


import java.util.Random;
import java.util.Scanner;

/*Tik Tac Toe*/
public class TicTacToe {

    //1. constants initialization
    static final int SIZE = 3;

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
        for (int i = 0; i <SIZE ; i++) {
            printOneNumber(i);

        }

    }

    static void printOneNumber(int i){
        System.out.print((i+1)+EMPTY);
    }

    private static void printGameAreaRows() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println();
            printOneNumber(i);
            for (int j = 0; j <SIZE ; j++) {
                System.out.print(gameArea[i][j]+EMPTY);
            }
        }
    }

    private static void playGame() {
        //human
            //make a move
            humanTurn();
            //print map
            printGameArea();
            //check
            //checkend();


        //AI
            //make a move
            aiTurn();
            //print map
            printGameArea();
            //check win
            //checkend();
    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;

        do {
            System.out.print("\nВведите номер строки: ");
            rowNumber = scanner.nextInt();
            System.out.print("Введите номер столбца: ");
            colNumber = scanner.nextInt();
        } while (!isCellValid(rowNumber, colNumber,"human"));
        gameArea[rowNumber - 1][colNumber - 1] = DOT_HUMAN;
        System.out.println("\n\n");
    }

    private static void aiTurn() {
        int rowNumber;
        int colNumber;
        do {
            rowNumber = random.nextInt(SIZE)+1;
            colNumber = random.nextInt(SIZE)+1;
            gameArea[rowNumber - 1][colNumber - 1] = DOT_AI;
            System.out.println("\n\n");
        } while (isCellValid(rowNumber, colNumber, "ai"));

    }

    private static void checkend() {
        //check win or draw


    }

    private static boolean isCellValid(int rowNumber, int colNumber, String human_ai) {
        if (rowNumber < 1 || rowNumber > SIZE || colNumber < 1 || colNumber > SIZE) {
            if(human_ai.equals("human")) {
                System.out.println("\nПроверьте правильность ввода");
            }
            return false;
        }
        if (gameArea[rowNumber - 1][colNumber - 1] != DOT_EMPTY) {
            if(human_ai.equals("human")) {
                System.out.println("\nЯчейка непустая");
            }
            return false;
        }
        return true;
    }


}
