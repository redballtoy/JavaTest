package Lambda.part_00;


/*
* - лямбда выражение может использовать переменные которые объявлены вне общей области
*       видимости - на уровне класса или метода в которых лямбда выражение определено
* - от того где определены переменные могут различаться способы их использования в лямбдах
*
* Данный пример использование переменных уровня класса:
*/

public class LambdaUsedVariableClassLevel_04 {
    static int x = 10;
    static int y = 20;

    public static void main(String[] args) {
        Operation operation = () ->{
            x = 30;
            return x + y;
        };
        System.out.println(operation.calculate()); // 50 - была переопреленв статическая переменная
        //на уровне класса лямбда выражение может нетолько получать переменные но и переопределять их
    }
}
