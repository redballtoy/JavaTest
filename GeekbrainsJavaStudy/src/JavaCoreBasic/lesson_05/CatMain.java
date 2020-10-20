package JavaCoreBasic.lesson_05;

import JavaCoreBasic.lesson_04.TicTacToe;

public class CatMain {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мартин Лютер Кинг", "Афрокот", 7);
        Cat cat2 = new Cat("Барсик", "Русскот", 3);
        Cat cat3 = new Cat("Слоник");

        System.out.println(cat1.toString());
        System.out.println(cat2);//toString автоматически вызывается через println
        cat2.printCat();

        cat1.voice();
        cat2.voice();
        cat3.voice("Уууууу!");

        //права доступа
        Dog dog = new Dog();
        dog.name = "Шарик";

        //static
        Cat.printCatsCount();

        //сборщик мусора
        cat2 = null; //кота удалили но он не пропал
        //просим выполнить - вызывает finalize, может не выполняться
        System.gc();


        Cat.printCatsCount();
        //теперь вызовем сборщик мусора
            //применяется при логировании например в данном случае (когда удаляется объект)
            //когда работаем с C++ поскольку нет сборщика мусора
        //с 8 depreciadet


        Cat.printCatsCount();

        TicTacToe.startGame();

    }
}
