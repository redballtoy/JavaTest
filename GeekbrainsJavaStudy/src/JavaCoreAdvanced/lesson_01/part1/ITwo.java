package JavaCoreAdvanced.lesson_01.part1;

public interface ITwo {
    default void doMethod() {
        System.out.println("Метод в B");
    }
}
