package Algorithms.hw_03;

/*
 * Задание 3.5
 * Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
 * Оцените время выполнения операций с помощью базового метода System.nanoTime()
 */

import Algorithms.ArObj;

import java.util.*;

public class HW_03_05_Iterator {
    public static void main(String[] args) {
        //создаем связанный список
        LinkedList<String> mArray = new LinkedList<>();


        //добавляем элементы
        mArray.add("One");
        mArray.add("Two");
        mArray.add("Three");
        mArray.add("Four");


        //использование стандартного итератора, он имеет только 3 метода
        Iterator<String> iterator = mArray.iterator();

        //вывод и удаление элементов с использованием итератора
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println("mArraym = " + mArray);

        //Использование расширенного итератора
        LinkedList<ArObj> mArrayObj = new LinkedList<>();
        mArrayObj.add(new ArObj(1, 2));
        mArrayObj.add(new ArObj(3, 2));
        mArrayObj.add(new ArObj(5, 8));

        System.out.println("mArrayObj:");
        for (ArObj r : mArrayObj) {
            r.print();
        }

        System.out.println("mArrayObj.listIterator():");
        ListIterator<ArObj> liTerator = mArrayObj.listIterator();
        while (liTerator.hasNext()) {
            liTerator.next().print();
        }

        System.out.println("ArObj liTerator:");
        Random random = new Random();
        ArObj n;
        //Время выполнения
        //поменяли на случайно сгенерированные числа
        long startTime = System.nanoTime();
        while (liTerator.hasPrevious()) {
            n = liTerator.previous();
            n.print();
            liTerator.set(new ArObj(random.nextInt(10), random.nextInt(10)));
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения: " + estimatedTime);

        //результат замены
        System.out.println("Random data ArObj liTerator:");
        while (liTerator.hasNext()) {
            liTerator.next().print();
        }
    }
}
