package JavaCoreBasic.lesson_05.hw_05;

public class Employee {
    private String fio;
    private String position;
    private String email;
    private String tel;
    private float salary;
    private int age;

    public Employee(String fio, String position, String email, String tel, float salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
