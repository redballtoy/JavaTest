package Collections.part_02;

import java.util.HashMap;
import java.util.Map;

//Пример заполнения Map на основе данных  массива

//Нужно было составить список не повторяющихся элементов массива и для
//Каждого из элементов указать сколько раз он в массиве встречался
public class Task_01_01 {
    private static final String[] INPUT_DATA = {
            "a"
            , "b"
            , "c"
            , "d"
            , "e", "e"
            , "f"
            , "g", "g", "g"
            , "h"
            , "g"
            , "i"
    };

    public static void main(String[] args) {
        /* 1 вариант создать мапу в которой ключами будут значения исходного массива
            естественно без повтора, в значением будет количество повторяющихся элементов
            Алгоритм таков для каждого элемента массива получаем по ключу значение из мапы
            если оно нулевое значит такого элемента в мапе нет, заводит ключ и значение=1 в мапу,
            если есть то увеличиваем на 1 значение для данного элемента
         */
        Map<String, Integer> mapWords = new HashMap<>();

        for (String inputData : INPUT_DATA) {
            //1 способ заполнения value в зввисимости от совпадения ключа с элементом массива
            /*
            Integer mapWordsValue = mapWords.get(inputData);//Работая с объектной оболочкой мы
            if (mapWordsValue == null) {
                mapWordsValue = 0;                          //фактически работаем со значением
            }
            */

            //Второй вариант с использованием дефортного значения если value ==null
            Integer mapWordsValue = mapWords.getOrDefault(inputData, 0);

            mapWords.put(inputData, ++mapWordsValue);

        }

        // 1 вариант вывод коллекции после заполнения построчно entry
        /*
        for (Map.Entry<String, Integer> entry : mapWords.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        */


        //2 вариант с использованием итератора по ключу получаеми получением значения по ключу
        /*
        for (String s : mapWords.keySet()) {
            Integer mapWordsValue = mapWords.get(s);
            System.out.println(s+" " + mapWordsValue);
        }
        */

        //3 вариант с использованием лямбда выражения
        mapWords.forEach((inputData, mapWordsValue) ->
                System.out.println(inputData + " : " + mapWordsValue));
    }
}
