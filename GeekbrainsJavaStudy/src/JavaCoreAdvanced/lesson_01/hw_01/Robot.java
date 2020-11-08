package JavaCoreAdvanced.lesson_01.hw_01;

public class Robot extends Competitors{
    private int maxRunDistance;
    private double maxJumpHeight;


    @Override
    public void run() {
        setMaxRunDistance();
        System.out.println("Этот робот бежит " + getMaxRunDistance() + " метров");

    }

    @Override
    public void jump() {
        setMaxJumpHeight();
        System.out.println("Этот робот прыгает на " + getMaxJumpHeight() + " метров");
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public double getMaxJumpHeight() {
        return maxJumpHeight;
    }

    private void setMaxRunDistance() {
        this.maxRunDistance = (int)(Math.random()*1500);
    }

    private void setMaxJumpHeight() {
        this.maxJumpHeight = Math.random()*15;;
    }
}
