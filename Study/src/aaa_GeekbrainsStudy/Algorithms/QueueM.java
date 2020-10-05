package aaa_GeekbrainsStudy.Algorithms;

class LinkedListForQueue {
    public LinkM first;
    public LinkM last;

    public LinkedListForQueue() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(String name, int age) {
        LinkM linkM = new LinkM(name, age);
        if (this.isEmpty()) {
            first = linkM;
        } else {
            last.next = linkM;
        }
        last = linkM;
    }

    public String delete() {
        LinkM temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first = first.next;
        }
        return temp.name;
    }

    public void display() {
        LinkM current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }
}


public class QueueM {
    private LinkedListForQueue queue;

    public QueueM() {
        queue = new LinkedListForQueue();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void insert(String name, int age) {
        queue.insert(name, age);
    }

    public String delete() {
        return queue.delete();
    }

    public void display() {
        queue.display();
    }

}
