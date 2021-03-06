package JavaCoreBasic.lesson_06.hw_06;

public abstract class Animal {
    protected String name;
    protected int maxRunLenght;
    protected float maxJumpLenght;
    protected int maxSwimLenght;


    Animal(String name,int maxRunLenght, float maxJumpLenght, int maxSwimLenght) {
        this.maxRunLenght = maxRunLenght;
        this.maxJumpLenght = maxJumpLenght;
        this.maxSwimLenght = maxSwimLenght;
        this.name = name;
    }

    Animal(String name,int maxRunLenght, float maxJumpLenght) {
        this.maxRunLenght = maxRunLenght;
        this.maxJumpLenght = maxJumpLenght;
        this.maxSwimLenght = 0;
        this.name = name;
    }

    Animal() {

    }


    public boolean run(int lenght){
        return hasDo(lenght,maxRunLenght);
    };
    public boolean swim(int lenght){
        return hasDo(lenght,maxSwimLenght);
    };
    public boolean jump(int lenght){
        return hasDo(lenght,maxJumpLenght);
    };

    private boolean hasDo(int lenght,float maxJumpLenght) {
        return ((float)lenght<maxJumpLenght);
    }

    public String getName() {
        return name;
    }

    public int getMaxRunLenght() {
        return maxRunLenght;
    }

    public float getMaxJumpLenght() {
        return maxJumpLenght;
    }

    public int getMaxSwimLenght() {
        return maxSwimLenght;
    }

}
