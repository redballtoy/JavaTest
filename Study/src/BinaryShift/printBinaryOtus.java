package BinaryShift;

public class printBinaryOtus {
    public static void main(String[] args) {
        /*Целочисленные типы данных
         *  - byte 8 бит 1 байт max 127
         *  - short     2 байта
         *  - int       4 байта
         *  - long      8 байт
         */

        byte a = 127;
        printBinary(a, 8);
        a = -1;
        printBinary(a, 8);
        a = -128;
        printBinary(a, 8);

    }

    //выводит на печать как выглядит число в битах
    public static void printBinary(byte value, int sizeValueBytes) {
        System.out.print(value+" = \t");
        for (int i = sizeValueBytes - 1; i >= 0; i--) {
            long mask = 1 << i;
            long result = (mask & value) >> i;
            System.out.print(result);
        }
        System.out.println();
    }
}
