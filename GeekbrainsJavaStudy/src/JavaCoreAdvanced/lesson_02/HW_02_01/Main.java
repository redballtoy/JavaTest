package JavaCoreAdvanced.lesson_02.HW_02_01;

import java.util.Random;

public class Main {

    private static final int rowsArray = 4;
    private static final int columnsArray = 4;
    private static final int correctArrayDim = 4;


    public static void main(String[] args) {
        String[][] arr = null;
        //Получается что если прокинуть наверх исключение (на уровень метода создания массива)
        // то при неверных значениях размера массива он даже не будет создаваться
        try {
            arr = createArray(rowsArray, columnsArray);
        } catch (IllegalArgumentException e) {
            System.out.println("MySizeArrayException - размеры создаваемого массива: " + rowsArray + " " + columnsArray);
            e.printStackTrace();
            return;
        }
        printArray(arr);
        System.out.println("Сумма элементов массива: " + sumArrayElements(arr));

    }

    private static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("[" + arr[i][j] + "] ");
            }
            System.out.println();
        }
    }

    private static String[][] createArray(int x, int y) throws IllegalArgumentException {
        checkArrayDimension(x, y);
        String[][] arr = new String[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = String.valueOf(new Random().nextInt(10));
            }
        }
        //Случайный ошибочный элемент
        arr[new Random().nextInt(x - 1)][new Random().nextInt(y - 1)] = "e";
        return arr;
    }

    private static void checkArrayDimension(int x, int y) throws IllegalArgumentException {
        if (x != correctArrayDim || y != correctArrayDim)
            throw new IllegalArgumentException();
    }

    private static int sumArrayElements(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println("MyArrayDataException at: arr[" + i + "][" + j + "] = " + arr[i][j]);
                    e.printStackTrace();
                }
            }

        }
        return sum;
    }

}
