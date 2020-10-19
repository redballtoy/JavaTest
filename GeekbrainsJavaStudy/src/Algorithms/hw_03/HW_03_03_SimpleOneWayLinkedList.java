package Algorithms.hw_03;

    /*
     * Задание 3.3
     * Реализуйте простой односвязный список и его базовые методы.
     */


public class HW_03_03_SimpleOneWayLinkedList {
    public static void main(String[] args) {


        LinkedListManage<String> list = new LinkedListManage<>();

        list.insert("Artem");
        list.insert("Roman");

        list.display();

        System.out.println("\n" + list.find("Artem"));

    }
}


//Программная реализация простого связного однонаправленного списка

//Данный класс реализует отдельный элемент связанного списка
class LinkListItem<T> {
    private T value; //сам элемент произвольного дженерик класса
    private LinkListItem<T> nextItemLink; //ссылка на следующий элемент

    public LinkListItem(T value) {//конструктор
        this.value = value;
    }

    public LinkListItem<T> getNextItemLink() { //возвращает индекс на следующий элемент
        return nextItemLink;
    }

    public void setNextItemLink(LinkListItem<T> nextItemLink) {//переводит с текущего индекса на следующий
        this.nextItemLink = nextItemLink;
    }

    public T getValue() {//получение элемента из объекта
        return value; //
    }
}

//класс который будет управлять отдельными элементами списка
class LinkedListManage<T> {
    private LinkListItem<T> first; //первый элемент должен существовать

    public LinkedListManage() {//конструктор инициализирующий первый элемент списка
        first = null;
    }

    public boolean isEmpty() {//проверка что если первый элемент пустой значит что и весь список пустой
        return first == null;
    }

    public void insert(T link) { //метод добавления элемента
        LinkListItem<T> l = new LinkListItem<>(link);//создание нового элемента в которое передается значение
        l.setNextItemLink(first);
        this.first = l;//добавили новый элемент и вот на него ссылка
    }

    //выполняется в связке с методом if(isEmpty()==false)
    public LinkListItem<T> delete() {
        LinkListItem<T> temp = first;
        first = first.getNextItemLink();//присваиваем текущему значению следующее что исключает
        //объект который теряет ссылку и в последствии будет уничтоден GC
        return temp;
    }

    //обычный вывод всех элементов
    public void display() {
        LinkListItem<T> current = first;
        while (current != null) {//проходимся по всему списку в одну сторону
            System.out.println(current.getValue());
            current = current.getNextItemLink();
        }
    }

    public T find(T searchItem) {
        LinkListItem<T> finfItem = new LinkListItem<>(searchItem);//создаем искомый элемент
        LinkListItem<T> current = first;//счетчик индекса
        while (current != null) {
            if (current.getValue().equals(finfItem.getValue())) {
                return finfItem.getValue();
            }
            current = current.getNextItemLink();
        }
        return null;
    }
}
