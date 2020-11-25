package Collections.part_02;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBookImpl implements IPhoneBook {

    private final Map<String, Set<String>> phonesBookList;

    public PhoneBookImpl() {
        //можно использовать TreeMap что бы сразу отсортировывать
        //можно передать компаратор который будет отображать логику ставнения объектов
        phonesBookList = new TreeMap<>();
    }

    @Override
    public void add(String surname, String phoneNumber) {
        //необходимо проверить есть ли такое имя, если есть то добавить телефон в список
        //если нет то создать новую запись в телефонной книге для этого
        //получаем тот сет который относится к заданному имени
        Set<String> phoneNumbersBySurname = getPhoneNumberBySurname(surname);

        //теперь добавляем в набор полученный по заданному имени номер телефона,
        //он либо добавится к существующим если набор не пустой, либо будет первым добавленым
        //если был заведен новый абонент
        phoneNumbersBySurname.add(phoneNumber);
    }

    @Override
    public Set<String> getAllKeySurnames() {
        return phonesBookList.keySet();
    }

    @Override
    public Set<String> getPhoneNumberBySurname(String surname) {
        //по переданному ключу имени мы ищем сет телефонов, если такого нет то создаем
        //новый для этого имени если нашли то просто возвращаем его
        Set<String> receivedPhoneSet = phonesBookList.getOrDefault(surname, new HashSet<>());
        //если если этот набор пустой, значит это новый абонент и его надо добавить в телефонную книгу
        if (receivedPhoneSet.isEmpty()) {
            phonesBookList.put(surname, receivedPhoneSet);
        }
        //возвращаем полученный набор (пустой или заполненный по запрашиваемому имени)
        return receivedPhoneSet;

    }



}
