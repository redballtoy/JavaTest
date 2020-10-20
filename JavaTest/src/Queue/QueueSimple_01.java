package Queue;

import Algorithms.ArObj;
import Algorithms.qeue.QueueInt;

import java.util.LinkedList;
import java.util.Queue;

/*
* Очередь - это структура данных построенная по принципу FIFO
* - очередь реализует два интерфейса односторонняя очередь Queue
* - и двусторонняя очередь Deque (элемент можно добавлять и в начало и в конец)
* - основные методы аналогичные спискам но имеют немного другую реадизацию:
*   Функция     Выдает исключение       Возвращает значение
*   push(e)     add(e)                  offer(e)
*   pop()       remove()                poll()
*   peek()      element()               peek() - чтение элемента производится из начала очереди
*/
public class QueueSimple_01 {
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
        queueInt.insert(10);
        queueInt.insert(20);
        queueInt.insert(30);
        queueInt.insert(40);
        queueInt.insert(50);
        queueInt.insert(10);

        queueInt.print();

        queueInt.remove();
        queueInt.remove();

        System.out.println("After remove:");
        queueInt.print();



    }

}
