package Lists;

/*
 *Реализация стека и очереди на базе связанного списка нужна для снятия ограничения размера массива
 */

import Algorithms.stack.StackListM;
import Algorithms.qeue.QueueM;

public class StackAndQueueByLinkedList {
    public static void main(String[] args) {
        //реализация StackList на базе связанного списка LinkedList
        System.out.println("Реализация StackList на базе связанного списка LinkedList:");
        StackListM stackListM = new StackListM();
        stackListM.push("Artem", 30);
        stackListM.push("Viktor", 20);
        stackListM.push("Sergey", 10);

        stackListM.display();//читерство, мы посмотрели все элементы стека

        //классическая реализация pop
        while (!stackListM.isEmpty()) {
            System.out.println("Элемент " + stackListM.pop() + " удален из стека.");
        }

        //Реализация Queue на базе связаного списка LinkedListForQueue
        System.out.println("\nРеализация Queue на базе связаного списка LinkedListForQueue:");
        QueueM queueM = new QueueM();
        queueM.insert("Artem", 30);
        queueM.insert("Viktor", 20);

        queueM.display();

        while (!queueM.isEmpty()) {
            System.out.println("Элемент " + queueM.delete() + " удален из списка");
        }
    }
}
