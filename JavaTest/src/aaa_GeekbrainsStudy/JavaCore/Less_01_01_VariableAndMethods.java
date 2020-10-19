package aaa_GeekbrainsStudy.JavaCore;

public class Less_01_01_VariableAndMethods {

    //2. Создать переменные всех пройденных типов данных и инициализировать их значения.
    private byte m_byte =   Byte.MAX_VALUE;
    private short m_short = Short.MAX_VALUE;
    private int m_int = Integer.MAX_VALUE;
    private long m_long = Long.MAX_VALUE;
    private float m_float = Float.MAX_VALUE;
    private double m_double = Double.MAX_VALUE;
    private char m_char = 'a';
    private boolean m_bool = true;
    private String m_str = "string";


    public static void main(String[] args) {
        System.out.println("Hello, World");

        //3 - задание
        float a = 12.23f;
        float b = 13.2f;
        float c = 14.3f;
        float d = 0f;
        System.out.println("Результат: "+getRes(a, b, c, d));
        System.out.println("Результат: "+getResIE(a, b, c, d));


        //4 - задание
        int int_a = 8;
        int int_b = 2;
        System.out.println("Сумма 8+2=10 находится в диапахоне от 10 до 20 - " + isInRange(int_a, int_b));

        //5 - задание
        isSignPrint(0);

        //6 - задание
        System.out.println("Число -12 отрицателдьное? " + isSign(-12));

        //7 - задание
        getGreeting("Олег");

        //* - задание
        isLeap(2020);
        isLeap(2021);


        //вывод форматированного char заданного int - русский алфавит
        /*
        int letter_min = 1040;
        int letter_max = 1103;
        printFormat(letter_min, letter_max);
        */


        //инеременд декремент
        /*
        int ic = 0;
        System.out.println(ic++);
        System.out.println(++ic);
        System.out.println(ic--);
        System.out.println(--ic);
        System.out.println(ic);

        int aa = 1;
        System.out.println("(1++ + 3 * 2) = " + (aa++ + 3 * 2));
        */

    }


    /*
     * 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     *  где a, b, c, d – аргументы этого метода, имеющие тип float.
     * На ноль делить нельзя
     */
    static float getRes(float a, float b, float c, float d) {
        if (d == 0) {
            System.out.println("Делить на 0 нельзя");
            return -1f;
        } else {
            return a * (b + (c / d));
        }
    }

    static float getResIE(float a, float b, float c, float d) {
         //Для чисел с плавающей точко все сложнее
        try {
            if (1/d==Float.POSITIVE_INFINITY || 1/d==Float.NEGATIVE_INFINITY)
                throw new ArithmeticException();
        } catch (ArithmeticException ae) {
            ae.printStackTrace();
            System.out.println("ArithmeticException occured!");
        }
        return a * (b + (c / d));
    }


    /*
     * 4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма
     * лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
     * в противном случае – false.
     */
    static boolean isInRange(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * 5. Написать метод, которому в качестве параметра передается целое число, метод должен
     * напечатать в консоль, положительное ли число передали или отрицательное.
     * Замечание: ноль считаем положительным числом.
     */

    static void isSignPrint(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " является положительным");
        } else {
            System.out.println("Число " + number + " является отрицательным");
        }
    }


    /*
     * 6. Написать метод, которому в качестве параметра передается целое число.
     * Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */
    static boolean isSign(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }


    /*
     * 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
     * Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
     */

    static void getGreeting(String name) {
        System.out.println("Привет, " + name + "!");
    }

    /*
     * *Написать метод, который определяет, является ли год високосным, и выводит сообщение
     * в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом
     * каждый 400-й – високосный.
     */

    static void isLeap(int year) {
        if (year % 4 == 0) {
            if ((year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year + "- год является високосным");
            } else {
                System.out.println(year + "- год не является високосным");
            }
        } else {
            System.out.println(year + "- год не является високосным");
        }
    }


    static void printFormat(int i_min, int i_max) {
        for (int i = i_min; i <= i_max; i++) {
            System.out.printf("Символ номер %d: %c%n", i, i); //%n - перенос работает только в форматированном выводе
        }
    }

}
