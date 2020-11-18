package Wrappers;


//Прикол в том что обертка Integer являющаяся объектом фактически является
//обычным int - при работе с оболочками фактически мы работаем со значением хранящимся в нем
//создавая два разных объекта мы создаем для них два разных поля и эти поля будут храниться в стеке
public class IntegerSample {
    public static void main(String[] args) {

        Integer intValue = 4;
        Integer otherValue = intValue;//здесь задается не ссылка а реальная переменная
        otherValue++;
        System.out.println("intValue и otherValue - это физически числа а не ссылки на них\n" +
                "intValue: " + intValue + "\notherValue: " + otherValue);

        //то что это не ссылки подтверждает то что мы не можем задать null
        //на самом деле работает
        Integer intValueN = null;
        System.out.println(intValueN);

    }

}
