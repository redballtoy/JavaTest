package Lambda.part_00;

//Пример как бы использовали анонимный класс вместо лямбды
public class UsingAsAbstractClass_02 {
    public static void main(String[] args) {

        //создание оъекта и реализация в нем метода функционального интерфейса через
        //анонимный класс
        Operationable operationable = new Operationable() {
            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        };

        System.out.println("х+y = " + operationable.calculate(7, 7));

    }
}
