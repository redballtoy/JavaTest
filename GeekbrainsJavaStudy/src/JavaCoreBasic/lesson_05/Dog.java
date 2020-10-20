package JavaCoreBasic.lesson_05;

public class Dog {

    public String name;
    String color; //default
    protected int age;
    private int weight;

    public void setWeight(int weight) {
        if (weight > 1 && weight < 35) {
            this.weight = weight;
            return;
        }
        System.out.println("Неверно введен вес!");

    }

    public int getWeight() {
        return weight;
    }
}
