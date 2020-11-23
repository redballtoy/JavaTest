package JavaCoreAdvanced.lesson_04.FX_Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainModel extends Application {
    Parent root; //это корневой шаблон который мы видим в окне сцены,
    // Parent - это обобщенный класс отображаемый для всех компонентов JavaFX

    final String PATH_TO_XML_LAYOUT = "sample.fxml";
    final int width = 1000;
    final int height = 600;


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
        primaryStage.setTitle("Lesson 4");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
    }
}
