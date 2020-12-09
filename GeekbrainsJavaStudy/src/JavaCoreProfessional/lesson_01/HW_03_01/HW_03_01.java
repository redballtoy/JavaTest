package JavaCoreProfessional.lesson_01.HW_03_01;

import java.util.ArrayList;
import java.util.Arrays;

public class HW_03_01 {
    public static void main(String[] args) {
        String[] arr = {"One", "Three", "Two"};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Массив с заменой элементов: " +
                Arrays.toString(exchange(arr, 1, 2)));

        //2 вопрос
        ArrayList<String> arrList = convertArrayToArrayList(arr);
        System.out.println("ArrayList<String> arrList = " + arrList);

        //3 вопрос
        //создаем фрукты
        Fruit apple1 = new Apple();
        System.out.printf("Вес явблока %s \n", apple1.getFruitWeight());
        Fruit orange1 = new Orange();
        System.out.printf("Вес апельсина %s \n", orange1.getFruitWeight());

        //создадим под них пустые коробки, по умолчанию в них помещается 5 фруктов в каждую
        Box appleBox = new Box(5, apple1);
        appleBox.printAboutBox();
        Box orangeBox = new Box(5, orange1);
        orangeBox.printAboutBox();

        //добавии фруктов в коробки
        appleBox.addFruit(3);
        appleBox.printAboutBox();

        //попробуем удалить из коробки больше фруктов чем есть
        appleBox.remFruit(4);
        appleBox.printAboutBox();

        //добавим фруктов в коробки
        appleBox.addFruit(4);
        appleBox.printAboutBox();
        orangeBox.remFruit(1);
        orangeBox.printAboutBox();
        orangeBox.addFruit(2);
        orangeBox.printAboutBox();

        //выясним какая коробка больше
        appleBox.compareBoxWeight(orangeBox);

        //пересыпем из яблок в новую коробку
        Box appleBox2 = new Box(5, apple1);
        appleBox.pouringFromBox1ToBox2(appleBox, appleBox2, 2);
        appleBox.printAboutBox();
        appleBox2.printAboutBox();

        //выясним какая коробка больше
        appleBox.compareBoxWeight(appleBox2);
        //appleBox.compareBoxWeight(orangeBox);


    }

    private static ArrayList<String> convertArrayToArrayList(String[] arr) {
        ArrayList<String> arrList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }
        return arrList;
    }


    //1. Написать метод, который меняет два элемента массива местами
    // (массив может быть любого ссылочного типа);
    private static String[] exchange(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}

//3 Большая задача
class Fruit {
    protected float fruitWeight;

    public float getFruitWeight() {
        return fruitWeight;
    }
}


class Apple extends Fruit {
    public Apple(float weight) {
        super();
        super.fruitWeight = weight;
    }

    public Apple() {
        super();
        super.fruitWeight = 1.0f;
    }
}

class Orange extends Fruit {
    public Orange() {
        super();
        super.fruitWeight = 1.5f;
    }

    public Orange(float weight) {
        super();
        super.fruitWeight = weight;
    }

}

class Box {
    private int fruitsValue;//количество фруктов помещающихся в коробку
    private int currentFruitValueInBox = 0;//текущее количество фруктов в коробке
    private ArrayList<Fruit> fruitsInBox;
    private int currentFruitValueInBox1;
    private Fruit fruit;

    public Box(int fruitsValue, Fruit fruit) {
        //создание пространства в которое помещаем фрукты
        fruitsInBox = new ArrayList<>();
        this.fruitsValue = fruitsValue;
        this.fruit = fruit;

    }

    public Box() {
        //создание пространства в которое помещаем фрукты
        fruitsInBox = new ArrayList<>();
        this.fruitsValue = 5;

    }

    public int getCurrentFruitValueInBox() {
        return currentFruitValueInBox;
    }

    public int getFruitsValue() {
        return fruitsValue;
    }

    //добавление фруктов в коробку
    public void addFruit(int addFruit) {
        int leftValue = currentFruitValueInBox;
        for (int i = 0; i < fruitsValue && i < addFruit; i++) {
            fruitsInBox.add(new Fruit());
            currentFruitValueInBox++;
        }
        System.out.printf("В коробку добавлено %d ", currentFruitValueInBox - leftValue);
    }

    //извлечение фруктоы из коробки
    public void remFruit(int removeFruit) {
        int leftValue = currentFruitValueInBox;
        for (int i = 1; currentFruitValueInBox >= 0 && i < removeFruit; i++) {
            //System.out.println(currentFruitValueInBox +" "+ i);
            fruitsInBox.remove(currentFruitValueInBox - 1);
            currentFruitValueInBox--;
        }
        System.out.printf("\n\nИз коробки %s выложено %s ", fruit.getClass().getSimpleName(), leftValue - currentFruitValueInBox);
    }

    //пересыпание из одной в другую коробку Box1->Box2
    public void pouringFromBox1ToBox2(Box box1, Box box2, int fruitsValue) {
        int currentFruitValueInBox1 = box1.getCurrentFruitValueInBox();
        int currentFruitValueInBox2 = box2.getCurrentFruitValueInBox();
        System.out.printf("\nВ коробке 1 сейчас %s фруктов", currentFruitValueInBox1);
        System.out.printf("\nВ коробке 2 сейчас %s фруктов", currentFruitValueInBox2);
        int spaceLeft = box2.getFruitsValue() - currentFruitValueInBox2;
        if (spaceLeft < this.currentFruitValueInBox1) {
            System.out.printf("\nВ корзине осталось %s свободных мест, а вы хотите прместить %s",
                    spaceLeft, this.currentFruitValueInBox1);
            return;
        } else {
            box1.remFruit(fruitsValue);
            box2.addFruit(fruitsValue);
        }
    }

    //определение веса коробки вместе с фруктвми
    public float getWeightBoxWithFruits() {
        float weight = currentFruitValueInBox * fruit.getFruitWeight();
        return weight;
    }

    //сравнение двух коробок по весу
    public boolean compareBoxWeight(Box box) {
        float weight1 = this.getWeightBoxWithFruits();
        float weight2 = box.getWeightBoxWithFruits();
        System.out.println("\n\nСравнение коробок по весу");
        if (weight1 > weight2) {
            System.out.printf("Вес коробки %s = %s, вес коробки %s = %s, результат: %s "
                    , this.fruit.getClass().getSimpleName(), weight1
                    , box.fruit.getClass().getSimpleName(), weight2
                    , true);
            return true;
        } else {
            System.out.printf("\nВес коробки %s = %s, вес коробки %s = %s, результат: %s "
                    , this.fruit.getClass().getSimpleName(), weight1
                    , box.fruit.getClass().getSimpleName(), weight2
                    , false);
            return false;
        }

    }

    //Печать информации о коробке
    public void printAboutBox() {
        System.out.printf("\n\nВ коробку %s вмещается %s фруктов", fruit.getClass().getSimpleName(), getFruitsValue());
        System.out.printf("\nСейчас в коробке %s фруктов", getCurrentFruitValueInBox());
        System.out.printf("\nВес коробки составляет %s", getWeightBoxWithFruits());
    }


}
