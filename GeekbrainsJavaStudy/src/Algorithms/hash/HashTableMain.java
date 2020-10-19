package Algorithms.hash;

import java.util.Random;

public class HashTableMain {
    public static void main(String[] args) {
        Item aDataItem;
        int aKey;
        int size = 66;

        HashTable hashTable = new HashTable(size);
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            aKey = random.nextInt(999);
            aDataItem = new Item(aKey);
            hashTable.insert(aDataItem);
        }

        hashTable.insert(new Item(999));
        hashTable.insert(new Item(203));

        hashTable.display();

        hashFunc2(999, 203);

        hashTable.delete(203);

        hashTable.display();

    }

    public static void hashFunc2(int k, int size) {
        System.out.println(k % size);
    }


}
