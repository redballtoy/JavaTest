package JavaCoreAdvanced.FXmessenger.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainModel extends Application {
    Parent root; //это корневой шаблон который мы видим в окне сцены,
    // Parent - это обобщенный класс отображаемый для всех компонентов JavaFX

    final String PATH_TO_XML_LAYOUT = "sample.fxml";
    final int width = 1000;
    final int height = 600;
    final int VERSION_APP = 6;
    final static String HOST = "localhost"; //если по сети то тут должен был быть ip адрес
    final static int PORT = 8089;


    //Единственная цель этого метода запуск приложения
    public static void main(String[] args) {
        launch(args);//будет запускать метод start
    }

    @Override
    //Stage - это сцена, фактически это окно JavaFX
    public void start(Stage primaryStage) {
        Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource(PATH_TO_XML_LAYOUT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //создание сокета клиента, необходимо будет указать хост и порт
        try {
            Socket socket = new Socket(HOST, PORT);
            //создание потоков
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }




        //создание окна для отображения
        primaryStage.setTitle("FXmessenger v." + VERSION_APP);
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
    }

}
