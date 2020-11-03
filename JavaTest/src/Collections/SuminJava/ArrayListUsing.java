package Collections.SuminJava;

import java.util.ArrayList;

public class ArrayListUsing {
    public static void main(String[] args) {

        //Автор говорит что в документации написано всегда использовать ArrayList
        //вместо массивов. Использовать массивы если точно знать что меняться он не будет
        //и он достаточно малого размера
        ArrayList<String> employees = new ArrayList<>();
        employees.add("Шахерезада Степановна");
        employees.add("Семен Семенович Горбунков");
        employees.add("Рюриков Иван Васильевич");
        for (String employee : employees) {
            System.out.println(employee);
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i <1000 ; i++) {
            numbers.add(i);
            sum += i;
        }
        System.out.println("Numbers size: "+numbers.size());
        System.out.println("sum: " + sum);



    }
}
