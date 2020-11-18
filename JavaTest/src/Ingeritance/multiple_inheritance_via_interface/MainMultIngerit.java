package Ingeritance.multiple_inheritance_via_interface;

/*
* Возможна ситуация когда в двух разных интерфейсах есть дефолтные методы с одинаковой
* сигнатурой. При применении этих методов к объекту может возникнуть конфликт
*
* */


public class MainMultIngerit {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.showInfo();
    }
}
