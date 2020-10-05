package aaa_GeekbrainsStudy.IntroductionInJavaPlatform.gpaphicGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class GameWindow extends JFrame {

    private static GameWindow gameWindow;

    //переменные для работы с классом Image
    private static Image background;
    private static Image game_over;
    private static Image drop;

    //координаты капли, левого верхнего угла
    private static float dropLeft = 200;
    private static float dropTop = 200;



    public static void main(String[] args) throws IOException {

        //Загрузка картинок
        InputStream inputStream;
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));

        //Формирование окна
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
        //рисование в панели g фигур
        /*g.setColor(Color.BLUE);
        g.fillOval(100,100,300,200);
        g.drawLine(50,50,300,50);*/

        //рисование загруженных картинок
        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, (int)dropLeft, (int)dropTop, null);
        //g.drawImage(game_over, 280, 120, null);

    }

    //создадим панель на которой будем рисовать, панель размещается внутри окна
    private static class GameField extends JPanel{

        //переопределяем метод с помощью которого будем рисовать
        @Override
        protected void paintComponent(Graphics g) {
            //для отрисовки необходимо получить доступ к методу paintComponent в классе JPanel
            super.paintComponent(g);
            onRepaid(g);
            //перерисовывать панель
            repaint();

        }
    }
}
