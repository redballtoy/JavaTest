package OOP.Geekbrains;

public interface FlyAndVoice extends Fly, Voice {
    @Override
    void fly();

    @Override
    void showVoice();
}
