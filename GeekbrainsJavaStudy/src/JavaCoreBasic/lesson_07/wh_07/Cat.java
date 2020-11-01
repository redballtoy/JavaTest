package JavaCoreBasic.lesson_07.wh_07;

import java.util.Random;

public class Cat {

    private int appetite;
    private String catName;

    public Cat(String catName) {
        this.appetite = new Random().nextInt(5) + 1; //котин голоден при создании но насколько не знаем
        this.catName = catName;
    }

    public void eat(Plate plate) {
        System.out.println("\nКотик собирается покушать");
        //если корма в миске достаточно котик ест
        if (plate.getCurrentCapacity() > this.appetite) {
            System.out.println("Котик скушал: " + this.appetite+" и теперь сыт!");
            plate.setCurrentCapacity(plate.getCurrentCapacity() - this.appetite);
        } else {
            System.out.println("В миске не достаточно корма! Подсыпь еще!");

        }
    }

}
