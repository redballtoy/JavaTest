package OOP.Geekbrains;

//при реализации нскольких интерфейсов требуется имплемментировать все их методы
public class Duck extends Animal implements Run, FlyAndVoice {
    private String name;

    public Duck(String name) {
        super();
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println("Утка");

    }

    @Override
    public void run() {

    }

    @Override
    public void showVelosity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void showVoice() {
        System.out.println("Кря! Кря");
    }
}
