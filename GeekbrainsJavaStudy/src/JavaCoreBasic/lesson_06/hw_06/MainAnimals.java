package JavaCoreBasic.lesson_06.hw_06;

public class MainAnimals {
    public static void main(String[] args) {
        Animal cat1 = new Cat("cat1", 200, 2);
        Animal dog1 = new Dog("dog1", 500, 0.5f,10);
        Animal dog2 = new Dog("dog1", 400, 0.5f,15);
        Animal dog3 = new Dog("dog1", 600, 0.6f,8);

        System.out.println("dog1.run(150)= "+dog1.run(150));
        System.out.println("dog2.run(450)= "+dog2.run(450));
        System.out.println("dog3.run(450)= "+dog3.run(450));

        System.out.println("cat1.jump(3)= "+cat1.jump(3));
    }
}
