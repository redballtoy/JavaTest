package Ingeritance.multiple_inheritance_via_interface;

public interface Run {
    default void showInfo() {
        System.out.println("Я из интерфейса Run");
    }
}
