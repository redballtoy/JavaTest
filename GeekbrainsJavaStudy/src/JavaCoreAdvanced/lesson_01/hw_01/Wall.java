package JavaCoreAdvanced.lesson_01.hw_01;

public class Wall implements Jump {
    private double maxJumpHeight;

    @Override
    public void jump() {
        setMaxJumpHeight();
        System.out.println("Высота стены " + getMaxJumpHeight() + " метров");
    }

    public double getMaxJumpHeight() {
        return maxJumpHeight;
    }

    private void setMaxJumpHeight() {
        this.maxJumpHeight = Math.random()*13;;
    }
}
