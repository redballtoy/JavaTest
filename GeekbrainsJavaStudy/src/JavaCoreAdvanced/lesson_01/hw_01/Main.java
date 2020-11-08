package JavaCoreAdvanced.lesson_01.hw_01;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Man man1 = new Man();
        man1.run();
        man1.jump();

        Robot robot1 = new Robot();
        robot1.run();
        robot1.jump();

        Cat cat1 = new Cat();
        cat1.run();
        cat1.jump();

        Threadmill threadmill = new Threadmill();
        threadmill.run();

        Wall wall = new Wall();
        wall.jump();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("И так соревнование по бегу и прыжкам между человеком, роботом и кошкой");
        System.out.println("-------------------------------------------------------------------------------");
        ArrayList<Competitors> competitors = new ArrayList<>();
        competitors.add(new Man());
        competitors.add(new Robot());
        competitors.add(new Cat());

        ArrayList<Threadmill> threadmills = new ArrayList<>();
        threadmills.add(new Threadmill());
        threadmills.add(new Threadmill());
        threadmills.add(new Threadmill());

        ArrayList<Wall> walls = new ArrayList<>();
        walls.add(new Wall());
        walls.add(new Wall());
        walls.add(new Wall());

        //Старт
        for (int i = 0; i < competitors.size(); i++) {
            System.out.println();
            competitors.get(i).run();
            for (int j = 0; j < threadmills.size(); j++) {
                threadmills.get(j).run();
                if (competitors.get(i).getMaxRunDistance() < threadmills.get(j).getMaxRunDistance()) {
                    System.out.println("Участник под номером " + i + " не смог преодолеть дистанцию");
                    break;
                } else {
                    System.out.println("Участник под номером " + i + " преодолел дистанцию следующее испытание стена!");
                    System.out.println();
                    competitors.get(i).jump();
                    walls.get(j).jump();
                    if (competitors.get(i).getMaxJumpHeight() < walls.get(j).getMaxJumpHeight()) {
                        System.out.println("Участник под номером " + i + " не смог преодолеть стену");
                        break;
                    } else {
                        System.out.println("Участник под номером " + i + " смог преодолеть стену!");
                        System.out.println("Следующий этап N: " + (i + 1));
                    }
                }
                System.out.println();
            }
        }

    }

}
