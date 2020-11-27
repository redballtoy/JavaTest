package Lambda.part_00;

/*
* Пример использования локальных переменных на уровне метода
*/


public class LambdaUsedVariableMethodLevel_05 {
    public static void main(String[] args) {
        int n = 70;
        int m = 30;

        Operation operation = ()->{
            //m = 50; //ошибка локальные переменные метода так же можно использовать в лямбде но
                        //менять их нельзя
                        //Variable used in lambda expression should be final or effectively final

            return m + n;

        };
        //m = 10; //Variable used in lambda expression should be final or effectively final
                //используемую в лямбда выражении переменную нельзя менять даже за пределами лямбды
                //фактически переменные метода используемые в лямбдах являются константами

        System.out.println(operation.calculate());

    }
}
