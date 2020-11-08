package JavaCoreBasic.lesson_08;

import javax.swing.*;
import java.awt.*;

public class Ex2 {

    static class MyWindow extends JFrame {
        public MyWindow() {
            setTitle("Тестовое окно");
            setBounds(400, 300, 300, 400);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JButton[] jbs = new JButton[5];
            JTree jTree = new JTree();

            for (int i = 0; i <5 ; i++) {
                jbs[i]=new JButton("#"+i);
                //jbs[i].setPreferredSize(new Dimension(20, 10));
                jbs[i].setMinimumSize(new Dimension(20, 10));

            }

            /*
            setLayout(new BorderLayout());//выбор компоновщика элементов
            add(jbs[0], BorderLayout.EAST);//добавление кнопок
            add(jbs[1], BorderLayout.NORTH);//добавление кнопок
            add(jbs[2], BorderLayout.CENTER);//добавление кнопок
            add(jbs[3], BorderLayout.WEST);//добавление кнопок
            add(jbs[4], BorderLayout.SOUTH);//добавление кнопок
            */
            setLayout(new GridBagLayout());
            add(jTree);
            add(jbs[0]);
            add(jbs[1]);
            add(jbs[2]);
            add(jbs[3]);
            add(jbs[4]);

            setVisible(true);
        }


    }


}
