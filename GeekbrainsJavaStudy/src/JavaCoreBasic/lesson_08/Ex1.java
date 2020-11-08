package JavaCoreBasic.lesson_08;

import javax.swing.*;

//Это будет окно которое мы будем описывать
public class Ex1 extends JFrame {
    public Ex1(){
        setTitle("Тестовое окно");
        setBounds(400, 300, 300, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
