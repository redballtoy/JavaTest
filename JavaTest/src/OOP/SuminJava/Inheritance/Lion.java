package OOP.SuminJava.Inheritance;

public class Lion extends CatFamily {
    public Lion() {
        super(2, 4, true);
    }

    @Override
    public String eat() {
        //что бы все же использовать метод суперкласса можно использовать конструкцию
        return super.eat() + " Антылопу!!!";
        //return "Кушаю антилопу!";
    }
}
