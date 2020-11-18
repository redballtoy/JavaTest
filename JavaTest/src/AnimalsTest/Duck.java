package AnimalsTest;

public class Duck extends Animal {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("\nУтка %s бежит!", super.getName());
    }
}
