package JavaCoreProfessional.lesson_01.part_01;

import java.util.Arrays;

public class ObjectStorage implements Storage{

    private Object[] data;
    private int currentSize;


    public ObjectStorage(int size) {
        this.data = new Object[size];
        this.currentSize = 0;
    }

    public Object get(int index) {
        return data[index];
    }

    public void add(Object value) {
        add(value, currentSize);
    }

    public void add(Object value, int index) {
        data[index] = value;
        currentSize++;
    }

    public int getCurrentSize() {
        return currentSize - 1;
    }

    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    public void print() {
        System.out.println(data);
    }

    @Override
    public String toString() {
        return "ObjectStorage{" +
                "data=" + Arrays.toString(data) +
                ", currentSize=" + currentSize +
                '}';
    }

    public boolean find(Object object) {
        for (Object datum : data) {
            if (object.equals(data)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void display() {

    }

    //для сравнения двух объектов онм должны пожжерживать интерфейс comparable
    public void sort() {
        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                Comparable a = (Comparable) data[i];
                Comparable b = (Comparable) data[j];
                if (a.compareTo(b) > 0) {
                    exchange(i, j);
                }
            }
        }
    }

    private void exchange(int i, int j) {
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
