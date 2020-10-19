package Arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraySearch {
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



        //заполнение массива
        Arrays.fill(mArray, 1);
        System.out.println(Arrays.toString(mArray));
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
}

