package Generics;

import java.util.ArrayList;

public class FruitBoxSample {
    public static void main(String[] args) {

        Box appleBox = new Box();
        appleBox.addFruits(new Apple(1.6f));
        appleBox.addFruits(new Apple(1.8f));
        appleBox.addFruits(new Apple(1.9f));
        System.out.println(appleBox.sumWeight());


    }
}

class Fruits {
    private double weightFruit;

    public Fruits(double weightFruit) {
        this.weightFruit = weightFruit;
    }

    public double getWeightFruit() {
        return weightFruit;
    }
}

class Apple extends Fruits {
    public Apple(double weightFruit) {
        super(weightFruit);
    }
}

class Box {
    private ArrayList<Fruits> fruits;

    public Box() {
        fruits = new ArrayList<Fruits>();
    }

    public void addFruits(Fruits fruit) {
        fruits.add(fruit);

    }

    public double sumWeight() {
        double weight = 0;
        for (Fruits fruit : fruits) {
            weight += fruit.getWeightFruit();
        }
        return weight;
    }


}
