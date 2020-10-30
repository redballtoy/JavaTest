package AccessModifiers.Sumin.main;

import AccessModifiers.Sumin.box.Box;
import AccessModifiers.Sumin.test.Man;

public class Main {
    public static void main(String[] args) {
        Man man1 = new Man("Василий", 43);
        //man1.age = -40;
        man1.setAge(-40);
        man1.showInfo();

        //Даем доступ только на чтение
        System.out.println("Имя запрашиваемого человека "+man1.getName());

        //Попытка создания коробки из другого пакета
        Box box = new Box();
        box.showDimension("SimpleBox");


    }
}
