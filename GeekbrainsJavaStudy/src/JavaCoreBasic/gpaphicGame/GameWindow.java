package JavaCoreBasic.gpaphicGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class GameWindow extends JFrame {

    private static GameWindow gameWindow;

    //переменные для работы с классом Image
    private static Image background;
    private static Image game_over;
    private static Image drop;

    //координаты капли, левого верхнего угла
    private static float dropLeft = 200;
    private static float dropTop = -100; //-100 что бы вылетала из-за верхней границы экрана

    //подсчет времени прошедшем между перерисовками (кадрами)
    private static long last_frame_time;

    //скорость капли
    private static float velocityDrop = 200;

    //подсчет отчков
    private static int score = 0;


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
        //присваиваем начальное значение переменной с временем фрейма
        last_frame_time = System.nanoTime();
        //создаем обработчик нажатия мыши
        gameField.addMouseListener(new MouseAdapter() {
            //вызывается при нажатии на мышку
            @Override
            public void mousePressed(MouseEvent e) {
                //получение координаты места где кликнули мышкой
                int x = e.getX();
                int y = e.getY();

                //расчет границ капли
                float borderRightDrop = dropLeft + drop.getWidth(null);
                float borderBotomDrop = dropTop + drop.getHeight(null);

                //определение попадает клик мышью на каплю или нет
                boolean isMouseOnDrop = (x >= dropLeft && x <= borderRightDrop)
                        && (y >= dropTop && y <= borderBotomDrop);
                if (isMouseOnDrop) {
                    //если попали то пока за границу экрана
                    dropTop = -100;
                    //по горизонтали откинем в случайное место
                    dropLeft = new Random().nextInt(gameField.getWidth() - drop.getWidth(null));
                    //увеличим скорость капли
                    velocityDrop += 20;
                    //учеличиваем очки
                    score++;
                    //выводим очки
                    gameWindow.setTitle("Score: " + score);
                }

            }
        });
        gameWindow.add(gameField);
        //сделать видимым
        gameWindow.setVisible(true);

    }

    //добавление возможности рисовать в окне
    private static void onRepaid(Graphics g) {

        //получим текущее время
        long current_time = System.nanoTime();
        //рассчитаем разницу во времени и переведем из наносекунд в секунды
        float timeDelta = (current_time - last_frame_time) * 0.000000001f;
        //присвоим начальному значению время текущего кадра
        last_frame_time = current_time;

        //рисование в панели g фигур
        /*g.setColor(Color.BLUE);
        g.fillOval(100,100,300,200);
        g.drawLine(50,50,300,50);*/

        //рисование загруженных картинок
        g.drawImage(background, 0, 0, null);


        //анимирование капли
        dropTop = dropTop + velocityDrop * timeDelta;
        //добавление для падения капли по диагонали
        //dropLeft = dropLeft + velocityDrop * timeDelta;
        g.drawImage(drop, (int) dropLeft, (int) dropTop, null);

        //при вылете капли за пределы окна выводить game over
        //получаем высоту окна
        if (dropTop > gameWindow.getHeight()) {
            //выводм надпись game over
            g.drawImage(game_over, 280, 120, null);
        }


    }

    //создадим панель на которой будем рисовать, панель размещается внутри окна
    private static class GameField extends JPanel {

        //переопределяем метод с помощью которого будем рисовать
        @Override
        protected void paintComponent(Graphics g) {
            //для отрисовки необходимо получить доступ к методу paintComponent в классе JPanel
            super.paintComponent(g);
            //метод игрового уровня
            onRepaid(g);
            //перерисовывать панель
            repaint();

        }
    }
}
