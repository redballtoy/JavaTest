package Stack;

/*
 * Стэк (стопка) - это абстрактный тип данных, который является списком элементов
 * организованных по принципу LIFO
 * - организуется на базе чего то например связанных списков, массивов
 * - стек используется в JVM для помещения в него переменных при вызове функция
 * - является потокобезопасным потому что для каждого потока создается свой стек
 * - программная реализация стека как правило реализуется в виде однонаправленного
 *   списка либо в качестве одномерного массива с упорядочеными адресами
 * - основные методы:
 *   - Push - добавить элемент
 *   - Pop - удалить элемент
 *   - Peek - просмотреть элемент (самый верхний, в середине посмотреть не получится)
 */

import Algorithms_HW_Geekbrains.ArObj;
import Algorithms_HW_Geekbrains.StackInt;

import java.util.Random;
import java.util.Stack;

public class StackSimple_01 {
    public static void main(String[] args) {
        Stack<ArObj> arObjs = new Stack<>();

        //заполнение стека
        arObjs.push(new ArObj(4, 5));
        arObjs.push(new ArObj(5, 5));
        arObjs.push(new ArObj(1, 8));
        arObjs.push(new ArObj(3, 1));

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
            System.out.println("Индекс стека: "+stackInt.getTop());
        }

        //Стек заполнен
        System.out.println("Стек заполнен: " + !stackInt.isEmpty());

        //Количество элементов в стеке
        System.out.println("Количество элементов в стеке: " + stackInt.size());

        //Показать верхний элемент
        System.out.println("Показать верхний элемент: ");
        System.out.println("top: "+stackInt.getTop()
                        +"\telement: "+stackInt.peek());

        //вывод элементов стека
        System.out.println("Вывод элементов стека stackInt: ");
        while (!stackInt.isEmpty()) {
            System.out.println("top: "+stackInt.getTop()+
                    "\telement: "+stackInt.pop());
        }


    }


}
