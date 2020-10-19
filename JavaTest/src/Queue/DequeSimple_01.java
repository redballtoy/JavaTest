package Queue;

/*
* Deque - это структура данных, в которой элементы можно добавлять и удалять как в начале
* так и в конце
* - может быть реализована при помощи двусвязного списка
* - исплользует методы insertLeft/Right и removeLeft/Right
*   - при использованании только insertLeft и removeLeft (или их эквивалентами для правого конца
*        дек работает как стек
*   - при использовании только  insertLeft и removeRight (или противоположной их пары)
*        дек работает как очередь
* - по этой причине деки привосходят и стеки и очереди
*
* - базовые методы:
*   pushBack/Front - добавление в конец/начало очереди
*   popBack/Front - удаление из конца/начала очереди
*   isEmpty - проверка наличия элементов
*   clear - очистка
*
* - методы реализующие добавление элементов
*   - void addFirst/Last(E E)
*   - boolean add(E e)
*   - boolean offer(E e), offerFirst/Last(E e)
*
* - методы реализующие удаление элементов
*   - remove()
*   - removeFirst/Last()
*   - pool(), poolFirst/poolLast()
*   - boolean remove(Object o), boolean removeFirstOccurrence/LastOccurrence(Object o)
*
* - методы работы с элементами
*   - element()
*   - getFirst/Last()
*   - peek(), peekFirst()/Last
*/


import aaa_GeekbrainsStudy.Algorithms.ArObj;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeSimple_01 {
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
        arObjDeque.pollFirst().print();
        arObjDeque.pollLast().print();
        arObjDeque.peekFirst().print();
        arObjDeque.peekLast().print();

    }

}
