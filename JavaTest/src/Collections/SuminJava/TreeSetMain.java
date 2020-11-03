package Collections.SuminJava;

import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {
        /*аналогична HashSet
            - не хранит дубли
            - не имеет метода get поэтому обращаться можно только в foreach
            - но в отличие от HashSet данные хранятся в сортированном виде и работает
            немного медленнее чем HashSet
          */
        TreeSet<String> names = new TreeSet<>();
        names.add("Вася");
        names.add("Петя");
        names.add("Вася");

        for (String name : names) {
            System.out.println(name);
        }

        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(23);
        numbers.add(17);
        numbers.add(154);
        numbers.add(6);
        for (Integer number : numbers) {
            System.out.println(number);
        }


    }

}
