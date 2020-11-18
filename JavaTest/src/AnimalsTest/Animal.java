package AnimalsTest;

public abstract class Animal implements Run {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
