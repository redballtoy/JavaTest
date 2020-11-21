package JavaCoreAdvanced.lesson_04.part_01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FX_Test extends Application {
    Parent root;

    //Единственная цель этого метода запуск приложения
    public static void main(String[] args) {
        launch(args);//будет запускать метод start
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader fXMLLoader;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
