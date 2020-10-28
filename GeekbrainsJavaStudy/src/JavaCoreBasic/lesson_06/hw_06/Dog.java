package JavaCoreBasic.lesson_06.hw_06;

public class Dog extends Animal {

    private static int countAnimal=1;

    public Dog(String name, int maxRunLenght, float maxJumpLenght, int maxSwimLenght) {
        super(name, maxRunLenght, maxJumpLenght, maxSwimLenght);
    }
    public Dog() {
        this.name = "dog_" + this.countAnimal++;
        this.maxJumpLenght = 0.2f;
        this.maxRunLenght = 600;
        this.maxSwimLenght = 10;
    }
}
