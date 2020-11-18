package OOP.Geekbrains;

public class AirPlane implements  FlyAndVoice{
    @Override
    public void fly() {
        System.out.println("Самолет");
    }

    @Override
    public String toString() {
        return "Самолет";
    }

    @Override
    public void showVoice() {
        System.out.println("Самолет голос: Пук! Пук!");
    }
}
