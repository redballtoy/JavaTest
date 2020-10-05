package Algorithms_HW_Geekbrains;

public class LinkM {
    public String name;
    public int age;

    public LinkM next;

    public LinkM(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + "\tAde: " + age);
    }
}
