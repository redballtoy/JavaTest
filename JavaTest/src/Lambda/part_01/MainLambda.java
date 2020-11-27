package Lambda.part_01;

/*
 * По 5 уроку Geekbrains объяснение за лямбды
 *
 *
 * */

import Lambda.part_00.IMyTwoVar;

public class MainLambda {
    private final int VAR_X = 10;
    private final int VAR_Y = 25;
    private IConstVar constVar;
    private String name;

    public MainLambda() {

    }

    public MainLambda(IConstVar constVar) {
        this.constVar = constVar;
    }



    public static void main(String[] args) {
        MainLambda mainLambda = new MainLambda();

        //Задача создать объект который будет реализовывать методы заданные интерфейсами
        //на вход нужно передать экземпляр об

        //1 вариант с созданием отдельного объекта типа интерфейс плохой вариант и подходит
            //только в случае когда данный объект в программе должен использоваться несколько раз

        //2. Вариант решения с использованием анонимного класса
        mainLambda.testNoneVar(new INoneVar() {
            @Override
            public void start() {
                System.out.println("все хорошо! через анонимный класс");

            }
        });

        //3. Вариант. Более короткой записью может служить использование лямбды
        //лямбда является альтернативой создания класса по интерфейсу и создания анонимного класса
        mainLambda.testNoneVar(()->System.out.println("A так это будет с лямбдой!"));

        //переменные a и b это то что передается в метод testTwoVar
        mainLambda.testOneVar(var -> System.out.println("One Var: " + var));
        mainLambda.testTwoVar((a, b) ->
                {
                    System.out.println("Two Vars: a = " + a );
                    System.out.println("Two Vars: b = " + b);
                }
        );

        //через анонимный класс это можно было бы переписать так
        mainLambda.testTwoVar(new ITwoVar() {
            @Override
            public void start(int x, int y) {
                System.out.println("Через анонимный класс Two Vars: a = " + x );
                System.out.println("Через анонимный класс Two Vars: b = " + y);

            }
        });

        //а если использовать свои параметры
        IMyTwoVar myTwoVar = (a,b) ->{
            System.out.println("myTwo Vars: a = " + a );
            System.out.println("myTwo Vars: b = " + b);
        };
        int a = 124, b = 142;
        myTwoVar.start(a, b);

        //MainLambda mainLambda1 = new MainLambda(() -> helloMessage("Vasya"));

    }

    private static void helloMessage(String name) {
        System.out.println("Hello, " + name);
    }

    public void testNoneVar(INoneVar obj) {
        obj.start();
    }

    public void testOneVar(IOneVar obj) {
        obj.start(VAR_X);
    }

    public void testTwoVar(ITwoVar obj) {
        obj.start(VAR_X, VAR_Y);
    }
}
