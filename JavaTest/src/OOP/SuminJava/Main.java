package OOP.SuminJava;

public class Main {
    public static void main(String[] args) {
        Box myBox = new Box();
        myBox.setDimens(11.3, 10.2, 15);
        Box myBox2 = new Box();
        myBox2.setDimens(5, 5, 5);
        Box myBox3 = new Box();
        myBox3.setDimens(10, 10, 10);

        Box box4 = new Box();
        box4.printVolume();





        myBox.printVolume();
        myBox2.printVolume();
        myBox3.printVolume();

        //------------Test
        Test test = new Test();
        test.setDimens(15,15,15);
        test.printVolume();

    }



}
