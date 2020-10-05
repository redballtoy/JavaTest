package Lists;

/*
 * Коллекции и списки
 */

//Коллекция - это программный объект, содержащий в себе набор значений
//одного или различных типов и позволяющий обращаться к этим значениям
/*Collection - это базовый интерфейс от которого наследуются интерфейсы:
    - Set interface
        - HashSet
        - LinkedHashSet
        - SortedSet
            - TreeSet
    - List interface
        - ArrayList
        - Vector
        - LinkedList
    - Queue interface
        - LinkedList
        - PriorityQueue
*/

//List - списки, это абстрактный тип данных, представдяющий собой упорядоченный
//набор значений в котором некоторое значение может встречаться более одного раза
//ArrayList - это список реализованный на основе массива, представляет
//собой динамический массив в котором не надо указывать размерность
//LinkedList - это связанный список, основанный на объектах с сылками между ними

/*Основные методы работы со списками
 *   add(String item) - добавляет новый элемент в конец списка
 *   add(String item, int position) - добавляет новый элемент в position
 *   Insert(int index, T item) - вставка элемента item на позицию index
 *   AddRange(Collection collection) - добавление в список коллекции или массива
 *   remove(String item) - удаление позиции из списка по его item
 *   remove (int position) - удаление элемента в определеннй позиции
 *   removeAll() - удалить все позиции
 *   get() - получение определенного элемента по индексу
 * */


import aaa_GeekbrainsStudy.Algorithms.ArObj;

import java.util.ArrayList;

public class ListBaseMethods {

    public static void main(String[] args) {
        ArrayList<String> mArray = new ArrayList<>();


        //add(String item) - добавляет новый элемент в конец списка
        mArray.add("One");
        mArray.add("Two");
        mArray.add("Three");
        System.out.println("mArray = " + mArray);

        //Способ копирование листа
        ArrayList<String> mArrayCopy = new ArrayList<>(mArray);
        System.out.println("mArrayCopy = " + mArrayCopy);

        //второй вариант копирования
        mArrayCopy.clear();
        System.out.println("mArrayCopy (cleared) = " + mArrayCopy);
        mArrayCopy.addAll(0, mArray);
        System.out.println("mArrayCopy (addAll) = " + mArrayCopy);

        //третий вариант копирования
        mArrayCopy = null;
        System.gc(); //гарантированное удаление сборщиком мусора
        mArrayCopy = (ArrayList<String>) mArray.clone();
        System.out.println("mArrayCopy (clone) = " + mArrayCopy);


        //add(String item, int position) - добавляет новый элемент в position смещая вправо имеющийся элемент
        System.out.println("before mArray.get(2) = " + mArray.get(2));
        mArray.add(1, "Four");
        //меняет элемент в выбранной позиции
        mArray.set(2, "Set");//переопределение элемента на данном индексе
        System.out.println(mArray);
        System.out.println("after mArray.get(2) = " + mArray.get(2));

        //remove (int position) - удаление элемента в определеннй позиции
        mArray.remove(1);
        //remove(String item) - удаление позиции из списка по его item
        mArray.remove("Set");
        System.out.println(mArray);

        //Список объектов ArObj, приммитивы в списке нельзя использовать,
        //но внутри классов объектов помещенных в список можно
        ArrayList<ArObj> mArrayArObj = new ArrayList<>();

        mArrayArObj.add(new ArObj(1, 2));
        mArrayArObj.add(new ArObj(3, 2));
        mArrayArObj.add(new ArObj(5, 8));

        //замена элемента
        mArrayArObj.set(2, new ArObj((1), 2));
        mArrayArObj.forEach((n) -> n.print());

        //или вывод стандартным foreach
        System.out.println("или вывод стандартным foreach");
        for (ArObj n: mArrayArObj) {
            n.print();
        }

    }

}


