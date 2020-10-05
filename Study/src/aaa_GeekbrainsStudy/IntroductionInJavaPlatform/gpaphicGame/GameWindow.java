package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.gpaphicGame;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static GameWindow gameWindow;

    public static void main(String[] args) {
        gameWindow = new GameWindow();
        //при закрытии окна программа будет завершаться
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //расположение окна в пискелях от верхнего левого угла монитора
        gameWindow.setLocation(200, 100);
        //настройка размера окна
        gameWindow.setSize(906, 478);
        //запретить изменять размеры окна с помощью мышки или развернуть
        gameWindow.setResizable(false);
        //добавляем панель в окно
        GameField gameField = new GameField();
        gameWindow.add(gameField);
        //сделать видимым
        gameWindow.setVisible(true);

    }

    //добавление возможности рисовать в окне
    private static void onRepaid(Graphics g) {
        //рисование в панели g
        g.setColor(Color.BLUE);
        g.fillOval(100,100,300,200);
        g.drawLine(50,50,300,50);

    }

    //создадим панель на которой будем рисовать, панель размещается внутри окна
    private static class GameField extends JPanel{

        //переопределяем метод с помощью которого будем рисовать
        @Override
        protected void paintComponent(Graphics g) {
            //для отрисовки необходимо получить доступ к методу paintComponent в классе JPanel
            super.paintComponent(g);
            onRepaid(g);

        }
    }
}
