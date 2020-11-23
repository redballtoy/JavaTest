package JavaCoreAdvanced.lesson_04.FX_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

//перехватывает действия и реагирует на них
public class Controller {


    //связывание контроллера с элементами вьюхи
    @FXML
    private TextField et_edit_text;

    @FXML
    private Button bt_send_text = new Button();


    @FXML
    private ListView<String> listView;

    @FXML
    //Для хранения textView нужна коллекция приспособленная дла fx
    private final ObservableList<String> wordList = FXCollections.observableArrayList(
            "Привет", "Часы", "Новый Год!"
    );


    //При первом открытии окна будет метод инициализации
    @FXML
    public void initialize() {
        
        //вносим данные коллекции в ListView
        bt_send_text.setText("ChangeText");
        et_edit_text.setText("Привет!");

    }

}
