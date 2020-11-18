package Ingeritance.multiple_inheritance_via_interface;

public interface Fly {
    default void showInfo() {
        System.out.println("Я из интерфейса Fly");
    }
}
