package Lambda.part_00;

/*
 * - существуют два типа лямбда выражений однострочное выражение и блок
 * - блочные выражения оформляются фигурными скобками
 * - если блочное лямбда выражение должно возвращать значение то явным образом применяется
 *       оператор return
 * */


public class CodeBlockInLambda_05 {
    public static void main(String[] args) {
        Operationable operationable = (x, y) -> {
            if (y == 0) {
                return 0;
            } else {
                return x / y;
            }
        };

        System.out.println(operationable.calculate(20, 2));
        System.out.println(operationable.calculate(20, 0));
    }
}
