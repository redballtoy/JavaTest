package JavaCoreBasic.lesson_05;

public class Cat {

    protected static int countCats;

    protected String name;
    protected String color;
    private int age;

    public Cat(String name, String color, int age) {
        this.name = name.toUpperCase();
        this.color = color;
        this.age = age;
        countCats++;
    }

    public Cat(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    void voice() {
        System.out.println(this.name + " сказал Мяу!"); //через this только при  конфликте имен?
    }

    void voice(String str) {
        System.out.println(this.name + " сказал " + str); //через this только при  конфликте имен?
    }

    public void printCat() {
        System.out.println(this);

    }

    public static void  printCatsCount() {
        System.out.println("Cat.countCats = "+Cat.countCats);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        countCats--;

    }
}
