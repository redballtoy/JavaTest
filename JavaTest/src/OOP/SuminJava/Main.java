package OOP.SuminJava;

public class Main {
    public static void main(String[] args) {
        Box myBox = new Box();
        myBox.height = 10.2;
        myBox.lenght = 15;
        myBox.width = 11.3;

        Box myBox2 = new Box();
        myBox2.height = 5;
        myBox2.lenght = 5;
        myBox2.width = 5;

        Box myBox3 = new Box();
        myBox3.height = 10;
        myBox3.lenght = 10;
        myBox3.width = 10;

        Box myBox4 = myBox3;
        myBox4.width = 100;



        myBox.printVolume();
        myBox2.printVolume();
        myBox3.printVolume();

        //------------Test
        Test test = new Test();
        System.out.println(test.square(11));

    }



}
