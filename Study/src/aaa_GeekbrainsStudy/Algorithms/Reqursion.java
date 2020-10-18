package aaa_GeekbrainsStudy.Algorithms;

/*Рекурсия - это определение, описание изображение какого либо объекта или процесса
 * внутри самого этого объекта или процесса, т.е. когда объект является частью самого себя
 * чаще всего это метод вызывающий сам себя
 *
 * Стек вызовов (call stack)  - это стек, хранящий информацию для возврата управления из под
 *   программ (методов или функций) в программу или подпрограмму (при вложенных или рекурсивных
 *   вызовах)
 *   - это место куда подрограмма должна вернуть результат вызова после своего завершения
 *       (адрес возврата)
 */

import java.util.Arrays;
import java.util.Random;

public class Reqursion {
    static final int ARRAY_SIZE = 10;
    static int[] arr = new int[ARRAY_SIZE];
    static Random random = new Random();

    public static void main(String[] args) {

        //Факториал n!=n*(n-1)!

        //числа Фибоначчи F0 = 0, F1 = 1, Fn = Fn-1 + Fn-2

        int n = 10;
        //countdown(n); //Бесконечная рекурсия
        //countdownCorrect(n); //Правильная рекурсия

        //Рекурсивный двоичный поиск
        printReqursionBinFind();

        //Сортировка методом выбора
        printMergeSort();


    }

    //Бесконечная рекурсия - это рекурсия из которой мы не можем выйти
    private static int countdown(int n) {
        System.out.println(n);
        return countdown(n - 1);
    }

    //Правильная рекурсия - это бесконечная рекурсия с условием для выхода из нее
    private static int countdownCorrect(int n) {
        System.out.println(n);
        if (n == 1) return 1;
        return countdownCorrect(n - 1);
    }

    //Рекурсивный двоичный поиск
    static int recBinaryFind(int searchKey, int low, int high, int[] arr) {
        if (low > high) {
            System.out.println("Значение не найдено.");
            return arr.length;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == searchKey) { //условие выхода из рекурсии
            return mid;
        } else if (arr[mid] < searchKey) {
            return recBinaryFind(searchKey, low + 1, high, arr);
        } else {
            return recBinaryFind(searchKey, low, high - 1, arr);
        }
    }

    //Вывод результатов рекурсивного бинарного поиска
    static void printReqursionBinFind() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Сортируем массив: " + Arrays.toString(arr));
        int rezFin = recBinaryFind(4, 0, arr.length - 1, arr);
        System.out.println("Элемент arr[" + rezFin + "] = " + arr[rezFin]);
    }

    //Сортировка методом выбора
    private static int[] sortMerge(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }
        int middle = len / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, len)));


    }

    static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex,result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex,result, ++i, a.length - aIndex);
                break;
            }
        }

        return result;
    }

    static void printMergeSort() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        System.out.println("\nСортировка методом выбора: ");
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Отсортированный массив массив: ");
        System.out.println(Arrays.toString(sortMerge(arr)));
    }


}
