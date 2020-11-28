package JavaCoreAdvanced.lesson_06.ClientServer.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    @FXML
    private ListView<String> lv_users_list;
    //Для хранения textView нужна коллекция приспособленная дла fx
    private final ObservableList<String> usersList = FXCollections.observableArrayList(
            "Андрей", "Сергей", "Василий");



    //При первом открытии окна будет метод инициализации
    @FXML

   public void initialize(){
        //вносим данные коллекции в ListView
        //bt_send_text.setText("SetMessages");
        et_edit_text.setText("Привет!");
        lv_output_word.setItems(wordList);
        lv_users_list.setItems(usersList);
    }

    @FXML
    //Добавление слова в список
    public void addWordToList(String word) {
        //Валидация что в окно ввода не пустое
        if (word.isEmpty()) {
            alertGo();
        } else {
            //Получаем коллекцию элементов из ListView и добавляем в нее то что вводим внизу
            lv_output_word.getItems().add(word);
        }
        //Очищаем поле et_edit_text
        et_edit_text.clear();
    }

    @FXML
    //Добавление слова в список
    public void addWord() {
        //Получем слово введенное в input поле
        String word = et_edit_text.getText().toString();
        //Вадидация что в осно ввода не пустое
        if (word.isEmpty()) {
            alertGo();
        } else {
            //Получаем коллекцию элементов из ListView и добавляем в нее то что вводим внизу
            String str = "Вы: -> "+getCurrentUser() +" : " + word;
            addWordToList(str);
        }
        //Очищаем поле et_edit_text
        et_edit_text.clear();
    }

    //Получение выделенного пользователя
    @FXML
    public String getCurrentUser() {
        return lv_users_list.getSelectionModel().getSelectedItem();
    }


    //Выход в меню
    @FXML
    public void exit() {
        System.exit(1);
    }
    private void alertGo() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error!");
        alert.setHeaderText("Ошибка ввода сообщения");
        alert.setContentText("Вы не ввели сообщение!\nНельзя вводить пустое сообщение!");
        alert.showAndWait();//отображает окно и не дает с него переключаться в отличие от простого show
    }

    @FXML //если есть связь с шаблоном обязательно указывать
    private void showAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("HW for Lesson 6");
        alert.setContentText("FX приложение созданное в рамках 6 урока!");
        alert.showAndWait();//отображает окно и не дает с него переключаться в отличие от простого show
    }

}
