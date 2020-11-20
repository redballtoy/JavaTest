package JavaCoreAdvanced.lesson_03.HW_03;

import java.util.*;
/*
 * 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.
 *
 * */


public class HW_03_01 {


    public static void main(String[] args) {
        System.out.println("Исходный массив");
        ArrayList<String> arrayList = createArrayList();
        printArray(arrayList);

        System.out.println("Массив без повторов");
        HashSet<String> distinctArray = getDistinctArray(arrayList);
        printArray(distinctArray);

        System.out.println("Вывод массива без повторов с указанием сколько слово встречается в первом массиве");
        Map<String, Integer> reportList = getListWithRepeatCount(distinctArray, arrayList);
        System.out.println(reportList);


    }

    private static Map<String, Integer> getListWithRepeatCount(HashSet<String> distinctArray, ArrayList<String> arrayList) {
        Map<String, Integer> map = new HashMap<>();
        Iterator iteratorHashSet = distinctArray.iterator();
        //Iterator iteratorArrayList = arrayList.iterator();

        String hashSetElement, arrayListElement;
        int count;
        while (iteratorHashSet.hasNext()) {
            count = 0;
            hashSetElement = iteratorHashSet.next().toString();
            Iterator iteratorArrayList = arrayList.iterator();
            while (iteratorArrayList.hasNext()) {
                arrayListElement = iteratorArrayList.next().toString();
                if (hashSetElement.equals(arrayListElement)) {
                    count++;
                }
            }
            map.put(hashSetElement, count);
        }
        return map;
    }


    private static void printArray(Collection s) {
        System.out.println("Массив: " + s);
        System.out.println("Элементов массива: " + s.size());
        System.out.println();
    }

    private static HashSet<String> getDistinctArray(ArrayList<String> arrayList) {
        //добавить его в SetHash
        HashSet hashSet = new HashSet<String>();
        for (int i = 0; i < arrayList.size(); i++) {
            hashSet.add(arrayList.get(i));

        }

        return hashSet;
    }


    private static ArrayList<String> createArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Мама");
        arrayList.add("мыла");
        arrayList.add("раму");
        arrayList.add("Шла");
        arrayList.add("Саша");
        arrayList.add("по");
        arrayList.add("шоссе");
        arrayList.add("и сосала");
        arrayList.add("сушку");
        arrayList.add("Мама");
        arrayList.add("запретила");
        arrayList.add("Саша");
        arrayList.add("есть ");
        arrayList.add("сушку");
        arrayList.add("пока");
        arrayList.add("она");
        arrayList.add("мыла");
        arrayList.add("раму");

        return arrayList;
    }

}
