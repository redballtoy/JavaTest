package String;

public class StringCommon {
    public static void main(String[] args) {
        String strNull = null;
        //позволяет избежать null point exeption
        String notNull = String.valueOf(strNull);
        System.out.println(notNull);

        //Конкатенация - используется когда одним из операндов является строка
        String b1 = "Число ";
        int b2 = 10;
        String b3 = b1 + b2;
        //то же самое
        b3 = b1.concat(String.valueOf(b2));
        System.out.println(b3);


        //Методы String
        String str2 = "Вагон";
        String str3 = "Ваня";


        //разделение строки на символы
        for (char c : str2.toCharArray()) {
            System.out.println(c);
        }

        //Регулярные выражения - паттерны, шаблоны того что нужно
        //используются для ваоидации вставки или удаления
        //можно так же разделять текст с исользовнием регулярных выражений
        String s1 = "Hello my world";
        for (String word : s1.split(" ")) {//в сплит должно подставляться регулярное
            System.out.println("Слово " + word);
        }

        //сравнение строк на равно и больше меньше
        System.out.println("сравнение строк на равно и больше меньше");
        System.out.println(str2.equals(str3));
        System.out.println(str2.compareTo(str3));//сравнивает посимвольно

        String space = " ";
        System.out.println(space.isEmpty());

        //substring - позволяет выделить подстроку в строке
        System.out.println(str3.substring(1,4));

        //replace - что и на что будем менять
        System.out.println(str3.replace('В','М'));

        //нахождение символа в строке
        System.out.println(str3.charAt(1));
        System.out.println(str3.indexOf('а'));


    }


}

