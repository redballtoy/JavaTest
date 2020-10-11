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

class Person{
    public String name;
    public int id;
    public int age;

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
}

class Node{
    public Person person;
    public Node leftChild;
    public Node rightChild;

    public void display(){
        System.out.println("Имя: "+person.name+"\tВозраст: "+person.age);
    }

}
