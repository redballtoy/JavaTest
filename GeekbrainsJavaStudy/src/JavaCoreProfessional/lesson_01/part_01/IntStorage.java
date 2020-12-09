package JavaCoreProfessional.lesson_01.part_01;

//некоторый класс хранящий данные
public class IntStorage implements Storage {

    private int[] data;
    private int currentSize;

    public IntStorage(int size) {
        this.data = new int[size];
        this.currentSize = 0;
    }

    public int getIntDataByIndex(int index) {
        return data[index];
    }

    public void addValueByIndex(int value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void addNext(int value) {
        addValueByIndex(value, currentSize);
    }

    public void removeValueByIndex(int index) {
        data[index] = 0;
        currentSize--;
    }

    public boolean findByValue(int value) {
        for (int datum : data) {
            if (value == datum) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int datum : data) {
            System.out.println(datum);
        }
    }

    @Override
    public void add(Object value) {

    }

    @Override
    public void add(Object value, int index) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public boolean find(Object value) {
        return false;
    }

    @Override
    public void display() {

    }

    public void sort() {
        for (int i = 0; i <data.length ; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                int a = data[i];
                int b = data[j];
                if (a > b) {
                    exchange(i, j);
                }
            }

        }
    }

    public int getCurrentSize() {
        return currentSize-1;
    }

    private void exchange(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
