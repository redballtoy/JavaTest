package aaa_GeekbrainsStudy.JavaCore;

import java.util.Arrays;

public class HW_less_02_01_BasicFlowConstruction {


    public static void main(String[] args) {

        System.out.println("\nЗадание 1");
        int[] arr = {1, 0, 1, 0, 0, 1};
        System.out.println("Исходный массив: " + arrayToString(arr));
        System.out.println("Инвертированный массив v1: " + arrayToString(invertArray_v1(arr)));
        System.out.println("Инвертированный массив v2: " + arrayToString(invertArray_v2(invertArray_v1(arr))));


        System.out.println("\nЗадание 2");
        int[] sourceArr2 = {0, 3, 6, 9, 12, 15, 18, 21};
        int[] targetArr2 = new int[sourceArr2.length];
        System.out.println("Исходный массив source: " + arrayToString(sourceArr2));
        System.out.println("Исходный массив target: " + arrayToString(targetArr2));
        fillIntArrayByCycle(sourceArr2, targetArr2);
        System.out.println("Результирующий массив target: " + arrayToString(targetArr2));


        System.out.println("\nЗадание 3");
        int[] sourceArr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив sourceArr3: " + arrayToString(sourceArr3));
        changeArray_t3(sourceArr3);
        System.out.println("Измененный массив sourceArr3: " + arrayToString(sourceArr3));

        System.out.println("\nЗадание 4");
        int[][] sourceArr4 = new int[4][4];
        int number = 1;
        System.out.println("Исходный двумерный массив:");
        print2DimArray(sourceArr4);
        System.out.println("Заполненный number по диагоналям двумерный массив:");
        print2DimArray(fill2DimArray(sourceArr4, 1));


        System.out.println("\nЗадание 5");
        int[] sourceArr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив sourceArr5: " + arrayToString(sourceArr5));
        System.out.println("Минимальное, максимальное значение: " + arrayToString(maxMinArray(sourceArr5)));


        System.out.println("\nЗадание 6");
        //int[] sourceArr6 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] sourceArr6 = {1, 1, 1, 2, 1};
        checkBalance(sourceArr6);
        System.out.println("Найдена ли точка одинаковых сумм? " + checkBalance(sourceArr6));

        System.out.println("\nЗадание 7");
        int[] sourceArr7 = {3, 5, 6, 1};
        int n = -1;
        System.out.println("Исходный массив sourceArr7: " + arrayToString(sourceArr7));
        System.out.println("Результат сдвига массива sourceArr7: " + arrayToString(shiftArray(sourceArr7, n)));


    }

    /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */

    //Вариант 1:
    static int[] invertArray_v1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;

            }
        }
            return arr;
        }

    //Вариант 2:
    static int[] invertArray_v2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i] == 0 ? 1 : 0;
            arr[i] = t;
        }
        return arr;
    }


    static String arrayToString(int[] arr) {
        String str = "[" + String.valueOf(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            str = str + "," + arr[i];
        }
        str += "]";
        return str;

    }

    /*
     * 2. Задать пустой целочисленный массив размером 8. С помощью цикла
     * заполнить его значениями 0 3 6 9 12 15 18 21;
     */

    static void fillIntArrayByCycle(int[] source, int[] target) {
        if (source.length != target.length) {
            System.out.println("Размер массивов не совпадает");
            return;
        }
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }

    /*
     * 3.Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
     *   и числа меньшие 6 умножить на 2;
     */
    static void changeArray_t3(int[] source) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] < 6) {
                source[i] *= 2;
            }
        }
    }

    /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     *   и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */


    static int[][] fill2DimArray(int[][] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = number;
            arr[i][arr.length - 1 - i] = number;
        }
        return arr;
    }


    static void print2DimArray(int[][] arr) {
        int lenght = arr.length;
        for (int i = 0; i < lenght; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    /*
     * 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */

    static int[] maxMinArray(int[] arr) {
        int min = 1000;
        int max = 0;
        int[] min_max = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        min = max;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        min_max[0] = min;
        min_max[1] = max;

        return min_max;
    }

    /* 6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    граница показана символами ||, эти символы в массив не входят.
 */
    static boolean checkBalance(int[] arr) {

        int sum1 = 0;
        int sum2 = 0;


        for (int i = 1; i < arr.length; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < i; j++) {
                sum1 += arr[j];

            }
            for (int j = i; j < arr.length; j++) {
                sum2 += arr[j];

            }

            if (sum1 == sum2) {
                System.out.println("sum1: " + sum1 + " sum2: " + sum2);
                return true;
            }

        }

        System.out.println("sum1: " + sum1 + " sum2: " + sum2);
        return false;
    }

     /* 7. Написать метод, которому на вход подается одномерный массив
              и число n (может быть положительным, или отрицательным), при этом метод должен сместить все
              элементы массива на n позиций. Элементы смещаются циклично.
              Для усложнения задачи нельзя пользоваться вспомогательными массивами.
              Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
              при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
         */


    static int[] shiftArray(int[] arr, int step) {

        int tempArrayElement = 0;


        for (int i = 1; i <= Math.abs(step); i++) {
            if (step > 0) {
                tempArrayElement = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tempArrayElement;
            } else {
                tempArrayElement = arr[0];
                for (int j = 0; j < arr.length-1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tempArrayElement;
            }

        }

        return arr;
    }
}


