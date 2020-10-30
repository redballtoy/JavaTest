package Collections.SuminJava;

public class MainCollections {
    public static void main(String[] args) {
        String[] employees = {
                "Никита",
                "Василий",
                "Елена Прекрасная",
                "Марфа Васильевна"
        };

        for (String employee : employees) {
            System.out.print(employee+" ");
        }

        //Решение проблемы добавленения нового сотрудника
        String[] newemploees = new String[employees.length * 2];
        for (int i = 0; i < employees.length; i++) {
            newemploees[i] = employees[i];
        }
        newemploees[4] = "Семен Семенович Горбунков";
        System.out.println("\n");
        for (String newemploee : newemploees) {
            System.out.println(newemploee);
        }

        //работа с созданной коллекцией
        System.out.println("работа с созданной коллекцией");
        MyCustomCollection employeesCollections = new MyCustomCollection();
        employeesCollections.add("Никита");
        employeesCollections.add("Василий");
        employeesCollections.printSizes();
        employeesCollections.removeElement(-1);//не будет удалять
        employeesCollections.printSizes();
        employeesCollections.printElements();
        System.out.println("Удаляемый элемент: "+employeesCollections.removeElement(-1));
        System.out.println("Удаляемый элемент: "+employeesCollections.removeElement("Никита"));
        employeesCollections.printElements();



    }
}
