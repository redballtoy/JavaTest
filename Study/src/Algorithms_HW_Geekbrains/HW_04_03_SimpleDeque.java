package Algorithms_HW_Geekbrains;

/*
* Задание 4.3
* На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
* Оцените время выполнения операций с помощью базового метода System.nanoTime().
*/


import java.util.ArrayDeque;
import java.util.Deque;

public class HW_04_03_SimpleDeque {
    public static void main(String[] args) {
        Deque<ArObj> arObjDeque = new ArrayDeque<>();

        arObjDeque.add(new ArObj(5, 1));
        arObjDeque.add(new ArObj(1, 1));
        arObjDeque.add(new ArObj(3, 2));

        //добавление элементов в начало и конец очереди
        arObjDeque.addFirst(new ArObj(0, 0));
        arObjDeque.addLast(new ArObj(9, 9));

        for (ArObj a: arObjDeque) {
            a.print();
        }

        //Вывод и удаление элементов
        System.out.println("Вывод и удаление элементов:");
        while (!arObjDeque.isEmpty()) {
            arObjDeque.poll().print();
        }
        //Очередь пуста
        System.out.println("arObjDeque.isEmpty(): " + arObjDeque.isEmpty());

        //Добавляем новые элементы
        arObjDeque.add(new ArObj(2, 2));
        arObjDeque.addFirst(new ArObj(0, 0));
        arObjDeque.addLast(new ArObj(9, 9));


        System.out.println("Poll and peek");
        long startTimeInsertSorting = System.nanoTime();
        arObjDeque.pollFirst().print();
        arObjDeque.pollLast().print();
        arObjDeque.peekFirst().print();
        arObjDeque.peekLast().print();
        long estimatedTimeInsertSorting = System.nanoTime() - startTimeInsertSorting;
        System.out.println("Poll and peek (время выполнения): " + estimatedTimeInsertSorting);

    }


}
