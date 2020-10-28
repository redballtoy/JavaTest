package JavaCoreBasic.lesson_06;

public class MainHorse {
    public static void main(String[] args) {
        Horse horse = new Horse();
        Animal animal = new Animal();
        horse.setHorseName("Vasya");
        horse.print();
        animal.print();
    }
}
