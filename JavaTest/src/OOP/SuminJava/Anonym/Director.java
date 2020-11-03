package OOP.SuminJava.Anonym;

public class Director {
    //Умеет заставлять готовить того кто умеет готовить
    void force(Cookable cookable) {
        cookable.cook();
    }
}
