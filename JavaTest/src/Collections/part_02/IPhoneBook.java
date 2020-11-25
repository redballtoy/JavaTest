package Collections.part_02;

import java.util.Set;

public interface IPhoneBook {
    void add(String surname, String phoneNumber);
    Set<String> getAllKeySurnames();
    Set<String> getPhoneNumberBySurname(String surname);
}
