package OOP.SuminJava.Anonym;

public class AnonymousMain {
    public static void main(String[] args) {
        Director director = new Director();
        Cooker cooker = new Cooker();
        director.force(cooker);

        //Если в коде класс используется один раз, как например повар,
        //то нет смысла его описывать, потом создавать, для этого
        //можно использовать анонимные классы - т.е. классы у которых нет имени
        //в данном случае мы должны передатьо объект класса который реализует объект Cookable
        //и прямо здесь реализовать указанный метод

        director.force(new Cookable() {//анонимный класс часто используется в виде слушателя
            @Override                   //поскольку слушатель это всего лишь интерфейс и нет смысла
            public void cook() {        //для каждой кнопки создавать отдельный объект слушателя
                System.out.println("Повар фантом готовит еду директору!");

            }
        });

    }
}
