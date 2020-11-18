package Enums.part_1;


//Использование Enum позволяет получать только те варианты выбора что мы задали и
//что ожидаем получить
public class MainTestEnum {
    public static void main(String[] args) {
        Dog dog = new Dog(Color.BLACK);
        System.out.println(dog.color.getRussianColor());
        System.out.println(dog.color.getEnglishColor());

        //Использование ENUM в switch
        //подставляет только те типы которые в свиче и только такого же типа
        switch (dog.color) {
            case BLACK:
                System.out.println("Собачка черная");
                break;
            case BROWN:
                System.out.println("Собачка рыжая");
                break;
            case WHITE:
                System.out.println("Собачка белая");
                break;
        }

        //Использование для сравнения разных классов через общее поле
        if (dog.color == Color.WHITE) {
            System.out.println("При сравнении выяснилось что эта собачка белая");
        }else if (dog.color == Color.BLACK) {
            System.out.println("При сравнении выяснилось что эта собачка черная");
        }


        //Использование перечислений как абстрактные команды
        SQL_Command.SELECT.action();
        SQL_Command.UPDATE.action();



    }


}
