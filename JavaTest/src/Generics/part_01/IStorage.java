package Generics.part_01;

//при работе с коллекцией принято использовать параметризированный тип Е
//при работе с Map <K,V>
public interface IStorage<E> {

    void add(E value);

    void add(E value, int index);

    void remove(int index);

    E get(int index);

    boolean find(E value);

    void display();

    void sort();

    int getCurrentSize();
}
