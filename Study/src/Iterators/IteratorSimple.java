package Iterators;

/*
 * Итератор - это интерфейс предоставляющий доступ к элементам коллекции (массива или контейнера)
 * и навигацтию по ним
 *
 * Метода итераторов:
 * next()/previous() - возвращает текущий элемент и переходит к следующему/предыдущему,
 *   если такого нет генерируется исключение NoSuchElementException
 * hasNext/hasPrevious() - возвращает true если в коллекции имеется следующий/предыдущий
 *   иначе false
 * nextIndex() - возвращает индекс следующего элемента если такого нет то размер списка
 * previousIndex - возвращает индекс предыдущего элемента если такого нет то возвращает -1
 * remote() - удаляет из коллекции последний элемент возвращаемый итератором, этот метод
 *   может быть вызван только после методов next() или previous()
 */


import Algorithms_HW_Geekbrains.ArObj;

import java.util.*;

public class IteratorSimple {
    public static void main(String[] args) {
        //создаем связанный список
        LinkedList<String> mArray = new LinkedList<>();

        //создаем обычный список
        ArrayList<String> mArrayCopy = new ArrayList<>(mArray);

        //добавляем элементы
        mArray.add("One");
        mArray.add("Two");
        mArray.add("Three");
        mArray.add("Four");
        mArrayCopy.addAll(mArray);

        //проверка что списки имеют идентичные элементы
        System.out.println(mArray.equals(mArrayCopy));

        //возврат hash кода списка
        System.out.println(mArray.hashCode());

        //стандартный вывод списка
        System.out.println("mArraym = " + mArray);

        //использование стандартного итератора, он имеет только 3 метода
        Iterator<String> iterator = mArray.iterator();

        //вывод и удаление элементов с использованием итератора
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println("mArraym = " + mArray);

        //Использование расширенного итератора
        LinkedList<ArObj> mArrayObj=new LinkedList<>();
        mArrayObj.add(new ArObj(1, 2));
        mArrayObj.add(new ArObj(3, 2));
        mArrayObj.add(new ArObj(5, 8));

        System.out.println("mArrayObj:");
        for (ArObj r: mArrayObj) {
            r.print();
        }

        System.out.println("mArrayObj.listIterator():");
        ListIterator<ArObj> liTerator = mArrayObj.listIterator();
        while (liTerator.hasNext()) {
            liTerator.next().print();
        }

        System.out.println("ArObj liTerator:");
        Random random = new Random();
        ArObj n;
        while (liTerator.hasPrevious()) {
            n = liTerator.previous();
            n.print();
            liTerator.set(new ArObj(random.nextInt(10), random.nextInt(10)));
        }
        //поменяли на случайно сгенерированные числа
        System.out.println("Random data ArObj liTerator:");
        while (liTerator.hasNext()) {
            liTerator.next().print();
        }
    }
}
