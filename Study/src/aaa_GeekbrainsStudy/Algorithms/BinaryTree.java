package aaa_GeekbrainsStudy.Algorithms;

/*
 * Дерево - это:
 *   - структура данных имеющая древовидную структуру в виде набора связанных узлов
 *   - является связным графом
 *   - не содержит циклы
 *
 * Преимуществом является то что операции удаления вставки и поиска осуществляются
 *   быстро
 *
 * Составные части:
 *   - корневой узел - самый верхний узел дерева
 *   - корень - одна из вершин по желанию наблюдателя
 *   - лист (терминальный узел) - узел не имеющий дочерних элементов
 *   - внутренний узел - любой узел дерева имеющий потомков и соответственно не
 *       являющийся листом
 *   - дерево считается ориентированным если в корень не заходит ни одно ребро
 */

/*
 * Двоичное (бинарное дерево) это дерево в котором корень имеет не более двух потомков
 *   - самый верхний узел назвается корневым а его дели правыми и левыми наследниками
 *   - не является упорядоченным ориентированным деревом
 *   - имеет строгую структуру
 * */


public class BinaryTree {
    public static void main(String[] args) {
        //создание бинарного дерева через списки

    }

}

//описание данных которые будут храниться в деревьях
class Person {
    public String name;
    public int id;//обязательный атрибут на основе которого будет производиться сортировка (уникальный)
    public int age;

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
}

//это сам узел в связанном списке
class Node {
    public Person person;
    public Node leftChild;//фактически ребра которые являются ссылками на предыдущий и
    public Node rightChild;//последующий элемент

    public void display() {
        System.out.println("Имя: " + person.name + "\tВозраст: " + person.age);
    }

}

//класс создания дерева
class Tree {
    private Node root;//корневой узел, наша точка отчета

    //вставка нового Person (сначала ищет узел для вставки, затем если id<idузла вставит как левый потомок иначе как
    // правый)
    public void insert(Person person) {
        Node node = new Node();
        node.person = person;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (person.id < current.person.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }

    }

    //поиск узла по ключу
    public Node find(int key) {
        Node current = root;
        while (current.person.id != key) {
            if (key < current.person.id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
                if (current == null) {
                    return null;//дошли до листа, что означает что не нашли требуемый узел
                }
            }
        }
        return current;
    }

    //удаление узла по id
    public boolean delete(int id) {//передаем по id потому что id не должен быть повторяющимся

        return true;
    }

    //вывод содержимого всего дерева
    public void display_Tree() {

    }

    //реализация симметричного обхода
    private void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    Node min() {
        Node current = null;
        Node last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    Node max() {
        Node current = null;
        Node last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }


}
