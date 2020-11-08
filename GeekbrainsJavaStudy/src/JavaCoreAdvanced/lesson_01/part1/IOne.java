package JavaCoreAdvanced.lesson_01.part1;

public interface IOne {
    String str = "Hello";


    default void doMethod() {
        System.out.println("Метод в B");
    }
}
