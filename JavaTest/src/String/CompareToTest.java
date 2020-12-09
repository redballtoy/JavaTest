package String;

import java.util.TreeSet;

public class CompareToTest {
    //метод CompareTo позволяет сравнить два слова сравнивая их юникод значения
    //например  apple
    //          apr
    //          00-1-1

    public static void main(String[] args) {
        String apple = "apple";
        String apr = "apr";
        System.out.println("apple.compareTo(apr): " + apple.compareTo(apr)); //apple.compareTo(apr): -2
        //apple выше apr на 2?
        TreeSet<String> ourWords = new TreeSet<>();
        ourWords.add(apr);
        ourWords.add(apple);
        System.out.println(ourWords); //с учем сортировки [apple, apr]
    }
}
