package JavaCoreAdvanced.lesson_05.part1;

public class MainTest {
    public static void main(String[] args) {
        Thread t;
        t = Thread.currentThread();
        t.setName("Новое имя");
        t.setPriority(10);
        System.out.println("Ждем...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t);
    }
}
