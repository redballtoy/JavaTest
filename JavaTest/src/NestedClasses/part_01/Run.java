package NestedClasses.part_01;

public interface Run {
    default void run() {
        System.out.println("Интерфейс Run для вложенных классов");
    }

    void runsDistance(Distance distance);
}
