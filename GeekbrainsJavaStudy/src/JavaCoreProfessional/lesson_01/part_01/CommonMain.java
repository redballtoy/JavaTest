package JavaCoreProfessional.lesson_01.part_01;

public class CommonMain {
    public static void main(String[] args) {
        //intTest();
        objectTest();

    }

    private static void intTest() {
        IntStorage intStorage = new IntStorage(5);
        intStorage.addNext(1);
        intStorage.addNext(2);
        intStorage.addNext(3);
        intStorage.print();

        System.out.println("Есть ли в массиве 2: " + intStorage.findByValue(2));

        System.out.println("Последний элемент в массиве: "
                + intStorage.getIntDataByIndex(intStorage.getCurrentSize()));


    }

    private static void objectTest() {
        //Если хотим использовать объекты и матоды к ним необходимо
        //приводить объекты к определенному типу

    }
}
