package Throwable.part_01;

/*Пример создания пользовательского исключения
1. создаем класс, 2 наследуеися от нужного типа исключения
В данном случае не хотим егл постоянно в коде обрабатывать поэтому пусть
генерируется в процессе выполнения
 */


public class CustomRuntimeExceptionByAnimalType extends RuntimeException {
    //после создания необходимо прописать почему произошла ошибка через конструкторы которые здесь определены

    public CustomRuntimeExceptionByAnimalType(String message) {
        //Данное сообщение будет вызвано в момент stackTrace
        super(message + " вам здесь не рады. Мы вас ссключаем!");
    }

    public CustomRuntimeExceptionByAnimalType(int i) {
        super("Засланец затаился под номером " + i);
    }
}
