package JavaCoreBasic.lesson_05;

public class CatMain {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мартин Лютер Кинг", "Афрокот", 7);
        Cat cat2 = new Cat("Барсик", "Русскот", 3);

        System.out.println(cat1.toString());
        System.out.println(cat2.toString());

    }
}
