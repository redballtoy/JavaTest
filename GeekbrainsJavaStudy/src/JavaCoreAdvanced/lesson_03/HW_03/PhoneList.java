package JavaCoreAdvanced.lesson_03.HW_03;

import java.util.HashMap;
import java.util.Map;

public class PhoneList {
    private Map<String, String> phoneList = new HashMap<>();

    public void add(String name, String phoneNumber) {
        this.phoneList.put(phoneNumber, name);
    }

    public HashMap<String, String> get(String name) {
        HashMap<String, String> output = new HashMap<>();
        while (phoneList.entrySet().iterator().hasNext()) {
            if (phoneList.containsValue(name)) {
                output.put(phoneList.entrySet().iterator().next().getKey(),
                        phoneList.entrySet().iterator().next().getValue());
            }
        }

        return output;
    }

    public void printPhoneList() {
        /*
        String[] key = phoneList.keySet().toArray(new String[phoneList.size()]);
        String[] value = phoneList.values().toArray(new String[phoneList.size()]);
        for (int i = 0; i < phoneList.size(); i++) {
            System.out.println("[" + value[i] + " , " + key[i] + "]");
        }
         */
        // вывод с использованием  entrySet()
        System.out.println("\nДанные их телефонного справочника:");
        for (Map.Entry<String, String> entry : phoneList.entrySet()) {
            System.out.println(entry.getValue()+" "+entry.getKey());
        }
    }


    //вывод заданного товарища
    public void printPhoneList(String name) {
        boolean hasFoundedUser = false;
        System.out.println("\nДанные их телефонного справочника:");
        for (Map.Entry<String, String> entry : phoneList.entrySet()) {
            if(entry.getValue().equals(name)) {
                hasFoundedUser = true;
                System.out.println(entry.getValue() + " " + entry.getKey());
            }
        }
        if (!hasFoundedUser) {
            System.out.println(name + " не найден в справочнике :(");
        }
    }


}
