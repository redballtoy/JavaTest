package JavaCoreBasic.lesson_08.events;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardExample {

    static public class MyWindow extends JFrame {

        String string;

        public MyWindow(){
            setBounds(500,500,400,300);
            setTitle("Demo");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JTextField field = new JTextField();

            add(field);

            //1 способ
            //field.addActionListener(new KeyboardListener());

            //2 способ объект на основе интерфейса и анонимного класса
            //ActionListener() - интерфейс на основе которого создается слушатель
            //addActionListener метод прикрепляющий слушатель к полю
            field.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println(field.getText());
                    field.setText("");



                }
            });


            //3 способ создания слушателя через лямбды
            //--------------------------------------------


            //Использование  определения клавиши
            /*
            field.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent keyEvent) {

                }

                @Override
                public void keyPressed(KeyEvent keyEvent) {

                }

                @Override
                public void keyReleased(KeyEvent keyEvent) {

                }
            });
            */

            //что  бы не переопределять все методы
            field.addKeyListener(new KeyAdapter() {
                                     @Override
                                     public void keyTyped(KeyEvent keyEvent) {
                                         if (keyEvent.isShiftDown()) {
                                             System.out.println(keyEvent.getKeyChar());
                                         }
                                     }
                                 });


                    setVisible(true);
        }

        public static void main(String[] args) {
            new MyWindow();
        }



    }



}
