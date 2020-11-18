package AnimalsTest;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("\nКошка %s бежит!", super.getName());
    }
}
