package Collections.SuminJava;

public class MyCustomCollection {
    private String[] array = new String[3]; //изначальный размер массива
    //переменная которая будет хранить количество элементов
    private int size = 0;


    //добавление элемента массива
    public void  add(String s) {
        array[size] = s;
        size++;
        //если конец массива надо увеличть массив в 2 раза и скопировать в него исходный
        if (size == array.length) {
            String[] newArray = new String[array.length * 2];
            //скопировать элементы из первого массива  во второй
            for (int i = 0; i <array.length ; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public String removeElement(int index) {
        if (index >= 0 && index <= size) {
        String deletedElement=array[index];
        //алгоритм состоит в присваивании удаляемого элемента значения следующего
        //за ним и так до конца массива сдвигая при этом указатель
        for (int i = index; i < size-1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deletedElement;
        }
        return "элемент не найден";
    }

    //перегруженный метод с использованием строки
    public String removeElement(String elementName) {
        for (int i = 0; i <size ; i++) {
            if (array[i].equals(elementName)) {
               return removeElement(i);
            }
        }
        return "элемент не найден";
    }

    public int getSize() {
        return size;
    }

    public String getElement(int index) {
        if (index >= 0 && index <= size) {
            return array[index];
        }
        return "неверный индекс";
    }
    public int getLenght() {
        return array.length;
    }
    public void printSizes(){
        System.out.println("Количество сотрудников "+getSize());
        System.out.println("Размер массива "+getLenght());
    }

    public void printElements() {
        System.out.println("Сотрудники:");
        for (int i = 0; i <size ; i++) {
            System.out.println(array[i]);
        }
    }
}
