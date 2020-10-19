package Algorithms.hw_03;


import java.util.*;

/*Задание 3.1
     * На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
     * Оцените время выполнения преобразования.
    */

public class HW_03_01_CollectionAndLists {
    public static void main(String[] args) {

        Integer[] mArray = {1, 2, 3, 5, 6, 7, 8, 9};

        long startTimeInsertSorting = System.nanoTime();
        /* такой вариант можно использовать если только читать, для вставки не сработает
        //https://coderoad.ru/2607289/%D0%9F%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%B0-%D0%B2-%D1%81%D0%BF%D0%B8%D1%81%D0%BE%D0%BA-%D0%B2-Java
        List<Integer> mArrayCopy = Arrays.asList(mArray);
        mArrayCopy.add(1);
        */
        List<Integer> mArrayCopy = new ArrayList<Integer>(Arrays.asList(mArray));
        mArrayCopy.add(1);
        long estimatedTimeInsertSorting = System.nanoTime() - startTimeInsertSorting;
        System.out.println(mArrayCopy);
        System.out.println("Время преобразования = " + estimatedTimeInsertSorting);


        int[] mArray_int = {1, 2, 3, 5, 6, 7, 8, 9};
        List<Integer> mArrayCopy_from_int = new ArrayList<>();
        for (int i = 0; i < mArray_int.length; i++) {
            mArrayCopy_from_int.add((Integer) mArray_int[i]);
        }

        System.out.println(mArrayCopy_from_int);


        //создание коллекции из массива
        Collection<Integer> collection = new ArrayList<>();
         Collections.addAll(collection, mArray);
        System.out.println("collection = "+collection);


    }
}

