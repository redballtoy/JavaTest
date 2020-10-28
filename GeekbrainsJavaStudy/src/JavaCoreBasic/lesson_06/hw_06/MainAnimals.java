package JavaCoreBasic.lesson_06.hw_06;

import java.util.ArrayList;
import java.util.List;

public class MainAnimals {
    public static void main(String[] args) {

        Animal smallCat_01 = new SmallCat();
        Animal bigCat_01 = new BigCat();
        Animal bigCat_02 = new BigCat();
        Animal dog_01 = new Dog();
        Animal dog_02 = new Dog();



        System.out.println(smallCat_01.getName()+" run(250)= "+smallCat_01.run(250));

        System.out.println();
        System.out.println(bigCat_01.getName()+" run(250)= "+bigCat_01.run(250));
        System.out.println(bigCat_02.getName()+" run(450)= "+bigCat_02.run(450));

        System.out.println();
        System.out.println(dog_01.getName()+" run(450)= "+dog_01.run(450));
        System.out.println(dog_02.getName()+" run(650)= "+dog_02.run(650));



        /*
        Animal cat1 = new SmallCat("cat1", 200, 2);
        Animal dog1 = new Dog("dog1", 500, 0.5f,10);
        Animal dog2 = new Dog("dog1", 400, 0.5f,15);
        Animal dog3 = new Dog("dog1", 600, 0.6f,8);

        System.out.println("dog1.run(150)= "+dog1.run(150));
        System.out.println("dog2.run(450)= "+dog2.run(450));
        System.out.println("dog3.run(450)= "+dog3.run(450));

        System.out.println("cat1.jump(3)= "+cat1.jump(3));

        List<String> test = new ArrayList<>();
        */


    }
}
