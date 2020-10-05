package Queue;

/*
 * Приоритетеная очередь - это очередь в которой укаждого элемента есть ключ
 * Самый приоритетный элемент имеет ключ с наименьшим значением
 * - элемент извлекается как из обычной очереди
 * - вставляется елемент в приоритетную очередь по другому:
 *   - данные которые находятся в приоритетной очереди упорядочены по ключу (в начале очереди
 *       находится элемент с наименьшим значением ключа и с максимальным приоритетом)
 *   - при вставке элемента он занимает позицию в соответствии со значением своего ключа что бы
 *       не нарушить сортировку
 */


import java.util.PriorityQueue;


public class PrioritetQueue_01 {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(9);
        priorityQueue.add(3);
        priorityQueue.add(7);
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
