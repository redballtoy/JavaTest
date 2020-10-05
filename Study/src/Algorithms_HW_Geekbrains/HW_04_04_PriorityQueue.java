package Algorithms_HW_Geekbrains;

/*
* Задание 4.4
* Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
* Оцените время выполнения операций с помощью базового метода System.nanoTime().
*/


import java.util.PriorityQueue;

public class HW_04_04_PriorityQueue {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        long startTimeInsertSorting = System.nanoTime();
        priorityQueue.add(9);
        priorityQueue.add(3);
        priorityQueue.add(7);
        long estimatedTimeInsertSorting = System.nanoTime() - startTimeInsertSorting;
        System.out.println("Время на добавление новых элементов: " + estimatedTimeInsertSorting);

        System.out.println("Очередь до добавления нового элемента");
        for (Integer p: priorityQueue) {
            System.out.println(p);
        }
        //вставка нового значения
        System.out.println("Очередь после добавления нового элемента");
        priorityQueue.offer(5);

        for (Integer p: priorityQueue) {
            System.out.println(p);
        }

    }
}
