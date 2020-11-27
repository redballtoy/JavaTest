package Lambda.part_00;

/*
*  - функциональный интерфейс может быть обобщенным, однако в лямбда выражении использование
*       обобщений не допускается, в этом случае надо типизировать объект интерфейса лпределенным
*       типом который будет потом применяться в лямюда выражении
* - таким образом при применении уже указывается какой тип будут предоставлять параметры и
*       какой тип будет возвращаться
* */


public class GeneralizedFunctionalInterface_06 {
    public static void main(String[] args) {
        IOperationableGeneralize<Integer> operationableInt = (x, y) -> x + y;
        IOperationableGeneralize<String> operationableString = (x, y) -> x + y;

        System.out.println(operationableInt.calculate(20, 10));
        System.out.println(operationableString.calculate("20", "10"));


    }


}
