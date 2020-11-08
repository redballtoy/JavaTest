package JavaCoreAdvanced.lesson_01.hw_01;

public class Threadmill implements Run {
    private int maxRunDistance;


    @Override
    public void run() {
        setMaxRunDistance();
        System.out.println("Беговая дорожка длиной " + getMaxRunDistance() + " метров");

    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    private void setMaxRunDistance() {
        this.maxRunDistance = (int)(Math.random()*1300);
    }

}
