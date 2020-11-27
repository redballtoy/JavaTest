package Lambda.part_00;

/*
https://metanit.com/java/tutorial/9.1.php
Передача параметров в лямбда-выражение:
        - параметры лямбда выражения должны соответствовать типу параметров
        метода в функциональном интерфейсе (при этом в лямбде писать тип
        не обязательно)

        Отложенное выполнение:
        - ключевой момент использования лямбда выражений, возможность отложенного
        выполнения что означает что лямбда может быть определена в одном
        месте программы и затем при необходимости может вызываться в
        других частях программы, это может потребоваться в случаях:
        - выполнения кода в отдельном потоке
        - переиспользование кода
        - выполнение кода в результате события
        - выполнение кода только в случае необходимости
*/




//Пример использования лямбда функции
public class LambdaFirstSample_01 {
    public static void main(String[] args) {

        //декларируем переменную типа функционального интерфейса
        Operationable operationable;
        //для данной переменной описываем реализацию лямбда функции из функционального интерфейса
        operationable = (x, y) -> x + y;

        //вызываеи единственный метод функциоонального интерфейса чью реализацию мы присвоили
        //переменной operationable
        System.out.println("х+y = " + operationable.calculate(7, 7));


        //Можно определить множество лямбда выражений
        Operationable opIntDec = (x, y) -> x - y;
        Operationable opIntMult = (x, y) -> x * y;
        Operationable opIntDiv = (x, y) -> {
            if (y == 0) {
                System.out.println("На ноль делить нельзя");
                return -1;
            } else {
                return x / y;
            }
        };

        int x = 5;
        int y = 0;
        System.out.println("x-y = " + opIntDec.calculate(x, y));
        System.out.println("x*y = " + opIntMult.calculate(x, y));
        System.out.println("x/y = " + opIntDiv.calculate(x, y));

    }
}
