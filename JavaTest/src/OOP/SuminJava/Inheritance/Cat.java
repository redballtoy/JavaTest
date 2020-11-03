package OOP.SuminJava.Inheritance;

public class Cat extends CatFamily {
    public Cat(){
       super(2,4,false);
    }

    @Override
    public String eat() {
        //что бы все же использовать метод суперкласса можно использовать конструкцию
        return super.eat() + " Вискас!!!";
        //return "Кушаю Вискас!";
    }
}
