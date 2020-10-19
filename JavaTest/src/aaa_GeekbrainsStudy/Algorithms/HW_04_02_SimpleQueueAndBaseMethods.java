package aaa_GeekbrainsStudy.Algorithms;

/*
* Задание 4.2
* На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
* Реализуйте вспомогательные методы.
* Оцените время выполнения операций с помощью базового метода System.nanoTime().
*/


import java.util.LinkedList;
import java.util.Queue;

public class HW_04_02_SimpleQueueAndBaseMethods {
    public static void main(String[] args) {
        Queue<ArObj> quArrObj = new LinkedList<>();

        quArrObj.add(new ArObj(5, 1));
        quArrObj.add(new ArObj(1, 1));
        quArrObj.add(new ArObj(3, 2));

        //Вывод элемента в начале очереди
        System.out.println("Вывод элемента в начале очереди: "+quArrObj.peek().getYX());

        //Вывод и удаление элементов очереди
        System.out.println("Вывод и удаление элементов очереди: ");
        while (!quArrObj.isEmpty()) {
            quArrObj.poll().print();
        }

        //реализация пользовательской очереди
        QueueInt queueInt = new QueueInt(5);

        //Время вставки в очередь:
        long startTimeInsertSorting = System.nanoTime();
        queueInt.insert(10);
        queueInt.insert(20);
        queueInt.insert(30);
        queueInt.insert(40);
        queueInt.insert(50);
        queueInt.insert(10);
        long estimatedTimeInsertSorting = System.nanoTime() - startTimeInsertSorting;
        System.out.println("Время заполнения очереди = " + estimatedTimeInsertSorting);

        queueInt.print();

        queueInt.remove();
        queueInt.remove();

        System.out.println("After remove:");
        queueInt.print();



    }

}
