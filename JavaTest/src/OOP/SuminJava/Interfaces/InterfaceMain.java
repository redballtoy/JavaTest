package OOP.SuminJava.Interfaces;

import java.util.ArrayList;

public class InterfaceMain {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal fish = new Fish();
        Animal bird = new Bird();

        //Пример Up Cast приведение к родительскому классу, все методы
        //которые есть в классе наследнике и отсутствуют в базовом классе
        //становятся недоступными
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        animals.add(fish);
        animals.add(bird);

        //пример полиморфизма, один интерфейс множество реализаций
        for (Animal animal : animals) {
            animal.eat();//один и тот же метод ведет себя по разному в зависимсти от
                        //того у какого животного он вызван
        }

        //Интерфейс определяет что умеет делать объект, по своей сути является
        //абстрактным классом который не имеет полей а только методы

        //Используя интерфейс можно поместить в коллекцию тип Animal разных животных
        //у которых у кого то есть метод run а у кого то нет, например у рыб
        //иначе нам бы пришлось создать этот метод в Animal но тогда его бы
        //пригшлось реализовывать в Animal

        //Теперь можно создать массив всех кто может реализовать интерфейс,
        //например бегать

        ArrayList<Runnable> animalWhoCanRun = new ArrayList<>();
        animalWhoCanRun.add((Dog) dog);
        animalWhoCanRun.add((Cat) cat);
        animalWhoCanRun.add(new Bird());
        for (Runnable canRun : animalWhoCanRun) {
            canRun.run();
        }

        ArrayList<Flyable> flyables=new ArrayList<>();
        Bird bird1 = new Bird();
        flyables.add(bird1);
        flyables.add((Flyable) bird);
        for (Flyable flyable : flyables) {
            flyable.fly();
        }




    }
}
