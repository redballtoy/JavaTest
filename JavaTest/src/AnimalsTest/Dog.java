package AnimalsTest;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("\nСобака %s бежит", super.getName());
    }
}
