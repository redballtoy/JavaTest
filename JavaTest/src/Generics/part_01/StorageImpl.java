package Generics.part_01;

public class StorageImpl<E> {
    private E[] data;
    private int currentSize;

    public StorageImpl(E[] data) {
        this.data = data;
    }
}
