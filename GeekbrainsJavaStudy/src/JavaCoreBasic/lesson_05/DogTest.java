package JavaCoreBasic.lesson_05;

public class DogTest {
    public static void main(String[] args) {
        Dog dog3 = new Dog();
        dog3.name = "Тот же пакет";
        dog3.color = "default";
        dog3.age = 12;//protected  - лучше использовать по умолчанию img185
        dog3.setWeight(34); //доступ к prived

        System.out.println(dog3.getWeight());
    }
}
