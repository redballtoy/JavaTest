package JavaCoreBasic.lesson_05.hw_05;

public class EmployeeMain {

    public static int SHOW_PERSON_OVER_AGE = 40;


    public static void main(String[] args) {
        Employee[] staff = createStaff();
        printOverAge(staff, SHOW_PERSON_OVER_AGE);

    }


    protected static Employee[] createStaff() {
        Employee[] staff = new Employee[5];
        staff[0] = new Employee("Горбунков С.С.", "Слесарь 3-го разряда", "gobunkov@firma.net", "92612345821", 25000, 39);
        staff[1] = new Employee("Годунов И.В.", "Генеральный директор", "godunov@firma.net", "+74991235647", 25000000, 345);
        staff[2] = new Employee("Красная-Шапочка К.Ш.", "Курьер", "kshapka@firma.net", "9262456312", 5000, 19);
        staff[3] = new Employee("Шамаханская Ш.С.", "Финасновый директор", "finik@firma.net", "9035465121", 250000, 45);
        staff[4] = new Employee("Муромец И.С.", "Охранник", "ohrana@firma.net", "+79164523156", 44000, 45);
        return staff;
    }

    protected static void printOverAge(Employee[] staff, int age) {
        System.out.printf("Сотрудники компании старше %d лет:\n", age);
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() > age) {
                System.out.println(staff[i]);
            }
        }

    }
}
