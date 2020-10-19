package Algorithms.hash;

public class HashTable {
    private int arrSize;
    private Item nonItem; //замена в случае если элемента не существует
    private Item[] hashArr; //хеш таблица состоящая из Items

    public HashTable(int arrSize) {
        this.arrSize = arrSize;
        this.hashArr = new Item[arrSize];
        this.nonItem = new Item(-1);
    }

    //Отображает полную хеш таблицу
    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key) {
        return key % arrSize;
    }

    //Реализация двойного кеширования
    public int hashFuncDouble(int key) {
        int conSt = 5;
        return conSt - key % conSt;//двойное хеширование производит сдвиг
    }

    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        //добавление двойного хеширования
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            hashVal+=stepSize;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);
        //добавление двойного хеширования
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            hashVal+=stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        //добавление двойного хеширования
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            hashVal+=stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    //Перехеширование таблицы
    //определение размера
    private int geyPrime(int min) {
        for (int i = min + 1; true; i++) {
            if (isPrime(i)) {
                return i;
            }

        }
    }

    private boolean isPrime(int n) {
        for (int j = 2; (j * j <= n); j++) {//квадратичное пробирование
            if (n % j == 0) {
                return false;
            }

        }
        return true;
    }


}
