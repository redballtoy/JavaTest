package Lambda.part_00;


//Пример использования терминальных лямбда выражений:
//  -это лямбды которые не возвращают никакого значения

public class TerminalLambdaSamlpe_03 {
    public static void main(String[] args) {
        //описание реализации метода функционального интерфейса который не возвращает значения
        Printable printable = str -> System.out.println(str);
        printable.print("Пример использования терминальной лямбды");
    }
}
