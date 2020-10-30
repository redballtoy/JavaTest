package AccessModifiers.Sumin.test;

public class Man {
    private String name;
    private int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo(){
        System.out.println("Имя: "+name+"\nAge: "+age);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }else {
            System.out.println("Возраст должен быть больше 0!");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
