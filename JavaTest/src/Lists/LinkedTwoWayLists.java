package Lists;

/*
 *  - как и односвязанный список двусторонний список допускает только последовательный доступ к элементам
 */

import aaa_GeekbrainsStudy.Algorithms.ArObj;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedTwoWayLists {
    public static void main(String[] args) {
        LinkedList<String> mArray = new LinkedList<>();

        //создаем ArrayList копированием из LinkedList
        ArrayList<String> mArrayCopy = new ArrayList<>(mArray);

        //метод добавления к связанному списку аналогичен ArrayList
        mArray.add("One");
        mArray.add("Two");
        mArray.add("Three");

        System.out.println(mArray);

        //Отличие что при вставке переопределяется индекс предыдущего и последующего объектов
        //т.е. переопределяются ссылки а не сдвигается сам массив

        //добавляем и обновляем по индексу никаких отличий от ArrayList
        mArray.add(1, "Four");
        System.out.println(mArray);
        mArray.set(2, "Set");
        System.out.println(mArray);

        //два remove по индексу и по объекту
        mArray.remove(1);
        System.out.println(mArray);
        mArray.remove("Set");
        System.out.println(mArray);

        //Дополнительные методы добавления в начало и конец:
        mArray.addFirst("first");
        mArray.addLast("last");
        System.out.println(mArray);

        //Возможность посмотреть первый и последний элемент без цикла и знания размера
        System.out.println("Первый элемент = " + mArray.peekFirst());
        System.out.println("Последний элемент = " + mArray.peekLast());

        //Методы возвращающие заданный элемент и затем сразу же удаляют его
        System.out.println("Первый элемент = " + mArray.pollFirst());
        System.out.println("Последний элемент = " + mArray.pollLast());
        System.out.println("Все что осталось = " + mArray);

        //Поиск существования запрашиваемого элемента в списке
        if (mArray.contains("Three")) {
            System.out.println("Элемент Three содержится в списке");
        } else {
            System.out.println("Элемент Three НЕ содержится в списке");
        }

        //Работа с объектами в двустороннем списке аналогично ArrayList за исключением вывода
        LinkedList<ArObj> mArrayArObj = new LinkedList<>();

        //добавление и обновление аналогично ArrayList
        mArrayArObj.add(new ArObj(1, 2));
        mArrayArObj.add(new ArObj(3, 2));
        mArrayArObj.add(new ArObj(5, 8));

        mArrayArObj.set(2, new ArObj(8, 5));
        System.out.println(mArrayArObj);
        System.out.println(mArrayArObj.get(2));
        for (ArObj n : mArrayArObj) {
            n.print();
            System.out.println("getX = "+n.getX() + " " + "getY = "+n.getY());
        }
    }
}
