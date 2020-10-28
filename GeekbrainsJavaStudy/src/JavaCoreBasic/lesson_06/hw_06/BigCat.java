package JavaCoreBasic.lesson_06.hw_06;

public class BigCat extends Animal{

    private static int countAnimal=1;

    public BigCat(String name, int maxRunLenght, float maxJumpLenght) {
        super(name, maxRunLenght, maxJumpLenght);
    }

    public BigCat() {
        this.name = "bigllCat_" + this.countAnimal++;
        this.maxJumpLenght = 2.2f;
        this.maxRunLenght = 400;
        this.maxSwimLenght = 0;
    }

}
