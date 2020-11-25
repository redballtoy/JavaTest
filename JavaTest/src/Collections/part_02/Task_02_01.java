package Collections.part_02;

import java.util.Set;

//Пример использования вложенных коллекций
//Преобразовать список телефонов с повторяющимися ФИО в которая позволит по имени
//выгружать все относящиеся к сотруднику телефоны
//организовать такое можно Map<String name, Set<String phone number>> т.е. список номеров
//вкладываем в карту с ключами абонентов
public class Task_02_01 {
    public static void main(String[] args) {
        IPhoneBook phoneBook = new PhoneBookImpl();
        phoneBook.add("Trumph", "445-2352-521");
        phoneBook.add("Mushka", "448-352-778");
        phoneBook.add("Petrov", "668-324-25");
        phoneBook.add("Ivanov", "448-352-779");
        phoneBook.add("Ivanov", "448-352-777");

    //Получаем все ключи
        Set<String> allKeysSurname = phoneBook.getAllKeySurnames();
        //перебираем их и по каждому выводим список телефонов
        for (String key : allKeysSurname) {
            Set<String> values = phoneBook.getPhoneNumberBySurname(key);
            System.out.printf("%s: %s%n",key,values);
        }

    }


}
