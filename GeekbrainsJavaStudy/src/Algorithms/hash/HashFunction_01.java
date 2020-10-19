package Algorithms.hash;

public class HashFunction_01 {
    public static void main(String[] args) {
        String hashstr = "Test";
        char hashchar = 't';
        System.out.println(hashstr.hashCode());
        hash(hashchar);//116!
        hashstr = "t";
        System.out.println(hashstr.hashCode());//116!
        hashFunc(hashchar, 10);

    }

    private static void hash(char x) {
        System.out.println((x >> 15) ^ x);
    }

    private static void hashFunc(char key, int f) {
        System.out.println(key%f);
    }

}
