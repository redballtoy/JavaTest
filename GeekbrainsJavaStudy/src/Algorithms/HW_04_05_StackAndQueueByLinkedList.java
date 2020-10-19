package Algorithms;

/*
 * Задание 4.5
 * На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
 * Оцените время выполнения операций с помощью базового метода System.nanoTime().
 */


public class HW_04_05_StackAndQueueByLinkedList {
    public static void main(String[] args) {
        //реализация StackList на базе связанного списка LinkedList
        System.out.println("Реализация StackList на базе связанного списка LinkedList:");
        StackListM stackListM = new StackListM();
        stackListM.push("Artem", 30);
        stackListM.push("Viktor", 20);
        stackListM.push("Sergey", 10);

        stackListM.display();//читерство, мы посмотрели все элементы стека

        //классическая реализация pop
        long startTimeInsertSorting = System.nanoTime();
        while (!stackListM.isEmpty()) {
            System.out.println("Элемент " + stackListM.pop() + " удален из стека.");
        }
        long estimatedTimeInsertSorting = System.nanoTime() - startTimeInsertSorting;
        System.out.println("Время удаления из стека: " + estimatedTimeInsertSorting);

        //Реализация Queue на базе связаного списка LinkedListForQueue
        System.out.println("\nРеализация Queue на базе связаного списка LinkedListForQueue:");
        QueueM queueM = new QueueM();
        queueM.insert("Artem", 30);
        queueM.insert("Viktor", 20);

        queueM.display();

    }

}
