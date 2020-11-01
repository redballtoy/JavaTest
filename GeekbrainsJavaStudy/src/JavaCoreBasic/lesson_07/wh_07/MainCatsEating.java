package JavaCoreBasic.lesson_07.wh_07;

public class MainCatsEating {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Борис Николаевич");
        Plate plateByCat1 = new Plate(15);

        plateByCat1.showInfo();
        plateByCat1.addFood(15);
        plateByCat1.showInfo();

        plateByCat1.addFood(1);
        plateByCat1.showInfo();

        cat1.eat(plateByCat1);
        plateByCat1.showInfo();



    }
}
