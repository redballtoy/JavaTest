package Collections.SuminJava;

import java.util.HashSet;

//Коллекция HashSet используется в тех случаях когда надо что бы в коллекции не было
//повторяющихся значений
public class HashSetMain {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();
        names.add("Вася");
        names.add("Мася");
        names.add("Вася");//будет добавлен только один Вася, HashSet не хранит двух одинаковых значений
        //кроме того элементы хранятся беспорядочно и еще к ним нельзя обратиться через метод get
        //это означаем что к элементам коллекции мы можем обращаться только через foreach
        for (String name : names) {
            System.out.println(name);
        }




    }


}
