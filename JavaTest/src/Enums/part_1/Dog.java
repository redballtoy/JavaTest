package Enums.part_1;

public class Dog {

    protected Color color;

    public Dog(Color color) {
        this.color = color;
    }

    public void print() {
        System.out.println(this);

    }

    @Override
    public String toString() {
        return "Dog{" +
                "color='" + color.getRussianColor() + '\'' +
                '}';
    }
}
