package Static.SuminJava.test;


//Вопрос можно ли обратиться к статическому полю через объект
//обращение к статическим полям через объект плохая практика
//в обратную сторону из статического метода к нестатическим объектам вообще не работает
public class StaticFieldAccess {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.name);
        dog.name = "MyLittlePony";
        System.out.println(Dog.name);

        //-----------------------------
        //А это вариант не со статическим классом
        Cat cat = new Cat();
        //System.out.println(cat.name); тоже не прокатит

    }
}

class Dog{
    static String name = "MyLittleDog";
}
class Cat{
    private String name = "MyLittleCat";
}

