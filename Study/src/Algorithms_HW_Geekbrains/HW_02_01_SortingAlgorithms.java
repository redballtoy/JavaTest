package Algorithms_HW_Geekbrains;

import java.util.Random;
import java.util.Arrays;
/*
* Методы сортировки массивов
*/



public class HW_02_01_SortingAlgorithms {
    public static void main(String[] args) {
        int[] mArray;
        int[] mArrayCopy;
        mArray = new int[10];
        mArrayCopy = new int[10];
        int key = 3;

        //Заполнение массива
        Random rand = new Random();
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = rand.nextInt(15);
        }

        //Линейный поиск
        boolean foundKey = false;
        for (int i = 0; i < mArray.length; i++) {
            if (mArray[i] == key) {
                foundKey = true;
                System.out.println("Значение найдено, =" + mArray[i]);
                break;
            }
        }
        if (!foundKey) {
            System.out.println("Значение " + key + " не найдено.");
        }
        ;
        System.out.println("mArray= " + Arrays.toString(mArray));

        //Простая сортировка массива
        mArrayCopy = Arrays.copyOf(mArray, mArray.length);
        Arrays.sort(mArrayCopy);
        System.out.println("mArray Sorted= " + Arrays.toString(mArrayCopy));

        //Вызов двоичного поиска, при этом массив должен быть отсортирован
        //результом двоичного поиска является индекс в массиве
        if (Arrays.binarySearch(mArrayCopy, key) < 0) {
            System.out.println("Arrays.binarySearch элемент не найден");
        } else {
            System.out.println("Arrays.binarySearch = " + mArrayCopy[Arrays.binarySearch(mArrayCopy, key)]);
        }

        //Вызов двоичного поиска, при этом массив должен быть отсортирован
        //результом двоичного поиска является индекс в массиве
        if (binarySearch(mArrayCopy, key) < 0) {
            System.out.println("binarySearch элемент не найден");
        } else {
            System.out.println("binarySearch = " + mArrayCopy[Arrays.binarySearch(mArrayCopy, key)]);
        }


        /*
         * Задание 2.3
         * Создайте массив размером 400 элементов.
         * Выполните сортировку с помощью метода sort().
         * Оцените сортировку с помощью базового класса System.nanoTime().
         */

        int[] arr400 = new int[400];
        Random random = new Random();
        for (int i = 0; i < arr400.length; i++) {
            arr400[i] = random.nextInt(1000);
        }
        int[] arr400Sort = Arrays.copyOf(arr400, arr400.length);
        long startTimeSort = System.nanoTime();
        Arrays.sort(arr400Sort);
        long estimatedTime = System.nanoTime() - startTimeSort;



        /*
         * Задание 2.4
         * На основе существующего массива данных из задания 2.3 реализуйте
         * алгоритм сортировки пузырьком.
         * Оцените сортировку с помощью базового класса System.nanoTime().
         * Сравните время выполнения алгоритмы сортировки методом sort() из
         * задания 2.1 и сортировку пузырьком.
         */

        //Сортировка пузьком наиболее простой вариант сортировки но подходит только для
        //небольших массивов

        int[] arr400BubbleSort = Arrays.copyOf(arr400, arr400.length);
        long startTimeBubbleSort = System.nanoTime();
        bubbleSort(arr400BubbleSort);
        long estimatedTimeBubbleSort = System.nanoTime() - startTimeBubbleSort;


        /*
         * Задание 2.5
         * На основе массива данных из задания 2.3 реализуйте алгоритм
         * сортировки методом выбора.
         * Оцените сортировку с помощью базового класса System.nanoTime().
         * Сравните с временем выполнения алгоритмов сортировки из прошлых
         * заданий 2.3 и 2.4.
         */
        int[] arr400SelectionMethod = Arrays.copyOf(arr400, arr400.length);
        long startTimeSelectionMethod = System.nanoTime();
        selectionMethod(arr400SelectionMethod);
        long estimatedTimeSelectionMethod = System.nanoTime() - startTimeSelectionMethod;


        /*
         * Задание 2.6
         * На основе массива данных из задания 2.3 реализуйте алгоритм
         * сортировки методом вставки.
         * Оцените сортировку с помощью базового класса System.nanoTime().
         * Сравните с временем выполнения алгоритмов сортировки из прошлых
         * заданий 2.3, 2.4 и 2.5.
         */
        int[] arr400InsertSorting = Arrays.copyOf(arr400, arr400.length);
        long startTimeInsertSorting = System.nanoTime();
        insertSortingAlgorithm(arr400InsertSorting);
        long estimatedTimeInsertSorting = System.nanoTime() - startTimeInsertSorting;


        //Вывод информации о времени и результатах сортировок

        System.out.println("\n\nСравнение сортировки массивов");
        System.out.println("arr400 (не сортирован) = " + Arrays.toString(arr400));
        System.out.println("arr400Sort = \t\t\t" + Arrays.toString(arr400Sort));
        System.out.println("arr400BubbleSort = \t\t" + Arrays.toString(arr400BubbleSort));
        System.out.println("arr400SelectionMethod = " + Arrays.toString(arr400SelectionMethod));
        System.out.println("arr400InsertSorting = \t" + Arrays.toString(arr400InsertSorting));


        System.out.println("\n\nСравнение времени сортировки:");
        System.out.println("Время сортировки массива arr400Sort методом sort() = "
                + estimatedTime);
        System.out.println("Время сортировки массива arr400BubbleSort методом bubbleSort() = "
                + estimatedTimeBubbleSort);
        System.out.println("Время сортировки массива arr400SelectionMethod методом selectionMethod() = "
                + estimatedTimeSelectionMethod);
        System.out.println("Время сортировки массива arr400InsertSorting методом insertSortingAlgorithm() = "
                + estimatedTimeInsertSorting);
    }


    //реализация двоичного поиска
    public static int binarySearch(int[] arr, int elementToSearch) {
        //задаем начальный и конечный индекс массива
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        //пока индексы не сходятся в общей точке
        while (firstIndex <= lastIndex) {
            //находим средний индекс
            int middleIndex = (firstIndex + lastIndex) / 2;
            //результат найден в средней точке то возвращаем
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            } else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }


    //Пузырьковая сортировка
    public static void swapM_int(int[] a, int first, int last) {
        int buff = a[first];
        a[first] = a[last];
        a[last] = buff;
    }

    public static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i >= 1; i--) {//внешний цикл
            for (int j = 0; j < i; j++) {//внутренний цикл
                if (a[j] > a[j + 1]) //если порядок элементов нарушен
                    swapM_int(a, j, j + 1);//вызвать метод меняющий местами
            }
        }
    }


    //Сортировка методом выбора
    /*  Алгоритм сортировки (ищем наименьший элемент массива и перемещаем его на первое место):
     *       - начиная с элемента под индексом 0 ищем в массиве наименьшее значение
     *       - найденное значение меняем местами с нулевым элементом
     *       - повторяем шаги 1 и 2 уже для следующего индекса в массиве
     */
    public static void selectionMethod(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {//первый цикл слева направо
            int min = i;//вначале считаем что 0 минимальное значение
            for (int j = i + 1; j < a.length; j++) {//идем от второго элемента до конца
                if (a[j] < a[min]) {//если возникает несоответствие текущее значение меньше минимального
                    min = j;//теперь это значение будет минимальным
                }
            }
            swapM_int(a, i, min);//меняем текущее положение значения на новый минимум
        }

    }

    //сортировка методом вставки - является лучшим алгоритмов сортировки среди простых

    public static void insertSortingAlgorithm(int[] a) {
        int in;
        for (int i = 1; i < a.length; i++) {
            int buff = a[i];
            in = i;
            while (in > 0 && a[in - 1] >= buff) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = buff;
        }
    }


}
