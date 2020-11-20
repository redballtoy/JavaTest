package Collections.part_01;

/*
* Иерархия коллекций в Java
*   Iterable - interface - делает возможным перебор коллекции
*
*       Collection - interface - определяет самые основные методы работы с данными
*
*           List - interface - это оболочка для массивов для более компактной работы с ними
*               ArrayList - позволяет работать как с обычным мвссивом не думая о размере
*               LinkedList - нечто среднее между очередью и обычным листом
*               Vector - устаревшие структуры данных
*                   Stack - определяется LIFO
*
*           Queue - interface - очередь реализующая алгоритм FIFO, основаны не на массивах но так же поддерживают
*                               интерфейс Collection
*               PriorityQueue
*               Deque - interface
*                   ArrayDeque - улучшенная реализация стеков и очередь позволяющая уйти от понятия индекса
*
*           Set - interface так же не имеет ничего общего с List и Queue и является множеством, что означает что
*                      не может быть повторов или хранения одного и того же элемента
*               HashSet - порядка нет, ближе к массивам
*               LinkedHashSet - будет запоминать порядок с которым добавляли в массив, ближе к очередям
*               SortedSet - interface
*                   TreeSet - частное представление множества в виде дерева, они всегда будут сбалансированы и
*                       отсортированы
*   Map - interface - позволяют хранить ключ-значение в отличке от коллекций, индексы переходят в ключи
*           - будут задаваться <KeyType String, ValueType Integer>
            - hash функция - это функция которая приводит значение к ключа к соотвествующему ему значению
*       Hashtable
*       LinkedHashMap
*       HashMap
*       SortedMap - interface
*           TreeMap
*
*/

import java.text.MessageFormat;
import java.util.*;
import java.util.function.BiConsumer;

public class CollectionTest {

    public static void main(String[] args) {

        //Array List
        //testArrayList();

        //LinkedList
        //testLinkedList();

        //Set Test
        //testSet();

        //Map
        testMap();

    }

    private static void testMap() {

        //HashMap
        Map<String, String> map = new HashMap<>();
        //Map работает не через интерфейс Collection и соответственно добавление происходит
        //через метод put
        /*Ячейка Entry содержит:
                - hash
                - key
                - next - только для LinkedHashMap
                - value
          */
        map.put("14535453543", "Семен Семенович Горбунков");
        map.put("431535432", "Василиса Премудрая");
        map.put("3654673546", "Кощей Бессмертный");

        //для этого типа Map результат перебора будет случайным
        // 1 (классический) вариант перебора HashMap воспользоваться EntrySet(), позволяет отдавать
        //в формате ключ - значение
        System.out.println("\nHashMap<>() список: ");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            //Для вывода можно использовать другой формат
            //Порядок вывода будет случайным
            System.out.println(MessageFormat.format("Фамилие: {0} Тилифон: {1}",
                    entry.getValue(), entry.getKey()));
        }

        //LinkMap
        Map<String, String> mapLink = new LinkedHashMap<>();
        //Map работает не через интерфейс Collection и соответственно добавление происходит
        //через метод put
        /*Ячейка Entry содержит:
                - hash
                - key
                - next - только для LinkedHashMap
                - value
          */
        mapLink.put("14535453543", "Семен Семенович Горбунков");
        mapLink.put("431535432", "Василиса Премудрая");
        mapLink.put("3654673546", "Кощей Бессмертный");

        // 1 (классический) вариант перебора mapLink воспользоваться EntrySet(), позволяет отдавать
        //в формате ключ - значение
        System.out.println("\n1 вариант вывода \nLinkedHashMap<>() список: ");
        for (Map.Entry<String, String> entry : mapLink.entrySet()) {
            //System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            //Для вывода можно использовать другой формат
            //Порядок вывода будет соотвтетствовать порядку ввода
            System.out.println(MessageFormat.format("Фамилие: {0} Тилифон: {1}",
                    entry.getValue(), entry.getKey()));
        }

        // 2 вариант перебора mapLink c использованием получения ключа и вывода по нему значения
        System.out.println("\n2 вариант вывода \nLinkedHashMap<>() список: ");
        for (String s : mapLink.keySet()) {
            //System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            //Для вывода можно использовать другой формат
            //Порядок вывода будет соотвтетствовать порядку ввода
            System.out.println(MessageFormat.format("Фамилие: {0} Тилифон: {1}",
                    s, mapLink.get(s)));
        }

        // 3 вариант с использованием анонимных классов
        System.out.println("\n3 вариант вывода \nLinkedHashMap<>() список: ");
        //forEach требует на вход объекта BiConsumer объект который отвечает за передачу свойств
        //формируется анонимный класс
        mapLink.forEach(new BiConsumer<String, String>() {
            @Override
            //первое значение принимает ключи второе значения
            public void accept(String key, String value) {
                System.out.println(MessageFormat.format("Фамилие: {0} Тилифон: {1}",
                        value,key));
            }
        });

        //BiConsumer это так же функциональый интерфейс который можно реализовать через лямбды
        /*
        mapLink.forEach((key, value)-> System.out.println(MessageFormat.format("Фамилие: {0} Тилифон: {1}",
                value,key));
         */
    }


    private static void testSet() {
        //всегда проверяется на соответствие текущему значению, в сете не может быть повторений
        Set<String> set = new LinkedHashSet<>();
        set.add("A");
        set.add("C");
        set.add("B");
        set.add("F");
        set.add("B");
        set.add("B");
        set.add("B");
        set.add("F");
        set.add("G");

        //Повторений не будет
        System.out.println("LinkedHashSet: " + set); //[A, C, B, F, G]

        //TreeSet работает по принципу деревьев
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("F");
        treeSet.add("B");
        treeSet.add("B");
        treeSet.add("B");
        treeSet.add("F");
        treeSet.add("G");

        //Повторений не будет и еще и отсортируется
        System.out.println("TreeSet: " + treeSet); //[A, B, C, F, G]


    }

    private static void testLinkedList() {
        //Список в отличие от массива может хранить свои элементы в разных местах, поэтому требуются ссылки на них
        //Linked List - Header - это первый нулевой элемент списка который содержит, значение и ссылки на
        //предыдущий и последующие элементы, Header ссылается на нулевой элемент а последний элемент ссылается на
        //Header, отличительной чертоя является то что при добавлении мы добавляем в любое место не изменяя при
        //этом всю конструкцию


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("F");

        System.out.println(linkedList);

        //замена значения
        linkedList.set(1, "Q");
        System.out.println(linkedList);

        //сортировка производится с помощью Collection
        Collections.sort(linkedList);
        System.out.println(linkedList);

        //получить элемент
        System.out.println(linkedList.get(2));
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + "/");

        }


    }

    private static void testArrayList() {

        //По умолчанию всегда создается массив на 10 элементов
        //можно указать требуемый размер, если размер будет увеличиваться в процессе программы то
        //увеличение составит х1,5 + 1 поэтому размер нужно подбирать как можно ближе к количеству элементов
        //если известно сколько их будет
        //ArrayList имеет низкую эффективность работы при добавлении и удалении элемента из середины списка
        // в таком случае лучше использовать LinkedList

        ArrayList<String> arrayList = new ArrayList<>(5);//задаем размер 5 - это значение capacity - вместимости
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        //вывод массива
        System.out.println(arrayList);
        System.out.println(arrayList.size());//количество занятых позиций, сейчас 3 из 5

        //для подгона размера capacity к size используется метод
        arrayList.trimToSize(); //size=3 capacity=3

        //проверить есть ли свобдное место в массиве можно методом ?????
        arrayList.ensureCapacity(4);//в скобках указывается индекс в котором проверяем наличие меса

        //Удаление, удаляет первую которую найдет
        arrayList.remove("B");

        //добавление в нулевую позизицию
        arrayList.add(0, "D");
        //вывод массива
        System.out.println(arrayList);
        System.out.println(arrayList.size());

        //Про итератор, итератор - это объект который позволяет перебирать наш массив по каждому элементу
        //он позволяет обращаться к элементам, проверять их валидность
        Iterator iterator = arrayList.iterator();


        //использование итератора, цикл пока можем есть следующий элемент
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }

        System.out.println();

        //тот же самый итератор записанный более компактно
        for (String s : arrayList) {
            System.out.print(s);
        }
    }

}
