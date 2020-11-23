package JavaCoreAdvanced.lesson_04.FX_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;

//перехватывает действия и реагирует на них
public class Controller {


    //связывание контроллера с элементами вьюхи
    @FXML
    private TextField et_edit_text;

    @FXML
    private Button bt_send_text;

    @FXML
    private MenuBar m_top_menu;


    @FXML
    private ListView<String> lv_output_word;


    //Для хранения textView нужна коллекция приспособленная дла fx
    private final ObservableList<String> wordList = FXCollections.observableArrayList(
            "Привет", "Часы", "Новый Год!");


    //При первом открытии окна будет метод инициализации
    @FXML
    public void initialize() {

        //вносим данные коллекции в ListView
        //bt_send_text.setText("SetMessages");
        et_edit_text.setText("Привет!");
        lv_output_word.setItems(wordList);
    }

    @FXML
    //Добавление слова в список
    public void addWordToList() {
        //Получем слово введенное в input поле
        String word = et_edit_text.getText().toString();
        //Вадидация что в осно ввода не пустое
        if (word.isEmpty()) {
            System.out.println("Вы ничего не ввели!");
        } else {
            //Получаем коллекцию элементов из ListView и добавляем в нее то что вводим внизу
            lv_output_word.getItems().add(word);
        }
        //Очищаем поле et_edit_text
        et_edit_text.clear();
    }

}
