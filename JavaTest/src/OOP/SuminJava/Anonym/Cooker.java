package OOP.SuminJava.Anonym;

//Повар который будет готовить
public class Cooker implements Cookable {
    @Override
    public void cook() {
        System.out.println("Все готово! Пожалуйте кушать!");
    }
}
