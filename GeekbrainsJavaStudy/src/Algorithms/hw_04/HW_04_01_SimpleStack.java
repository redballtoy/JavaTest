package Algorithms.hw_04;

/*
 * Задание 4.1
 * На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
 * Оцените время выполнения операций с помощью базового метода System.nanoTime().
 */

import Algorithms.ArObj;
import Algorithms.trees.StackInt;

import java.util.Random;
import java.util.Stack;

public class HW_04_01_SimpleStack {
    public static void main(String[] args) {
        Stack<ArObj> arObjs = new Stack<>();

        //заполнение стека
        long startTimeInsertSorting = System.nanoTime();
        arObjs.push(new ArObj(4, 5));
        arObjs.push(new ArObj(5, 5));
        arObjs.push(new ArObj(1, 8));
        arObjs.push(new ArObj(3, 1));
        long estimatedTimeInsertSorting = System.nanoTime() - startTimeInsertSorting;
        System.out.println("Время заполнения стека: " + estimatedTimeInsertSorting);

        //вывод верхнего элемента
        arObjs.peek().print();

        //очистка стека с выводом удаляемых элементов
        System.out.println("Removing elements:");
        while (!arObjs.isEmpty()) {
            arObjs.pop().print();
        }
        System.out.println(arObjs.isEmpty());

        //реализация пользовательского стека
        StackInt stackInt = new StackInt(5);
        Random random = new Random();

        //максимальный размер стека
        System.out.println("Максимальный размер стека: " + stackInt.maxSize());

        //Стек пуст
        System.out.println("Стек пуст: " + stackInt.isEmpty());

        //заполнение стека
        while (!stackInt.isFull()) {
            stackInt.push(random.nextInt(10));
            System.out.println("Индекс стека: " + stackInt.getTop());
        }

        //Стек заполнен
        System.out.println("Стек заполнен: " + !stackInt.isEmpty());

        //Количество элементов в стеке
        System.out.println("Количество элементов в стеке: " + stackInt.size());

        //Показать верхний элемент
        System.out.println("Показать верхний элемент: ");
        System.out.println("top: " + stackInt.getTop()
                + "\telement: " + stackInt.peek());

        //вывод элементов стека
        System.out.println("Вывод элементов стека stackInt: ");
        while (!stackInt.isEmpty()) {
            System.out.println("top: " + stackInt.getTop() +
                    "\telement: " + stackInt.pop());
        }


    }


}
