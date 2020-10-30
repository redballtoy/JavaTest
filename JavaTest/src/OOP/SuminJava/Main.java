package OOP.SuminJava;

public class Main {
    public static void main(String[] args) {
        Box myBox = new Box(11.3, 10.2, 15);
        Box myBox2 = new Box(5, 5, 5);
        Box myBox3 = new Box(10, 10, 10);

        myBox.printVolume();
        myBox2.printVolume();
        myBox3.printVolume();

        //------------Test
        Test test = new Test(15,15,15);
         test.printVolume();

         //Перегрузка методов / static use
        int result = Test.multiple(6, 5);
        System.out.println("Multipry result: \t" + result);
        double resultd = Test.multiple(6.0d, 5.0d);
        System.out.println("Multipry result: \t" + resultd);
        int resulq = Test.multiple(6);
        System.out.println("Multipry result: \t" + resulq);

        //перегрузка конструктора
        Box box1 = new Box(12);
        box1.printVolume();

        Box box2 = new Box(12);
        box2.printVolume();

        //передача объекта в качестве параметра
        box1.compareTo(myBox);

        //Использование конструктора по созданию новой коробки по размерам существующей
        Box boxClone = new Box(box2);
        boxClone.compareTo(box2);

        //создание коробки в 2 раза больше переданной
        box2.showDimension("box2");
        Box doubleSizeBox = box2.increaseBoxDim(2);
        doubleSizeBox.showDimension("doubleSizeBox");




    }





}
