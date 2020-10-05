package Algorithms_HW_Geekbrains;


public class StackListM {

    private LinkedListForStack listM;

    public StackListM() {
        this.listM = new LinkedListForStack();
    }

    public void push(String name, int age) {
        listM.insert(name, age);
    }

    public String pop() {
        return listM.delete().name;
    }

    public boolean isEmpty() {
        return listM.isEmpty();
    }

    public void display() {
        listM.display();
    }


}