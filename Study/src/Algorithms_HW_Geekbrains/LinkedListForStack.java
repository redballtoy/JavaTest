package Algorithms_HW_Geekbrains;

public class LinkedListForStack {
    public LinkM first;

    public LinkedListForStack() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(String name, int age) {
        LinkM newLink = new LinkM(name, age);
        newLink.next = first;
        first = newLink;
    }

    public LinkM delete() {
        LinkM temp = first;
        first = first.next;
        return temp;
    }

    public void display() {
        LinkM current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }
}