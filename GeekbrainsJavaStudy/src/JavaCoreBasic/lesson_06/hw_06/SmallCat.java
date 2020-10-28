package JavaCoreBasic.lesson_06.hw_06;

public class SmallCat extends Animal {

    private static int countAnimal=1;

        public SmallCat(String name, int maxRunLenght, float maxJumpLenght) {
        super(name, maxRunLenght, maxJumpLenght);
    }

    public SmallCat() {
        this.name = "smallCat_" + this.countAnimal++;
        this.maxJumpLenght = 2;
        this.maxRunLenght = 200;
        this.maxSwimLenght = 0;
    }
}
