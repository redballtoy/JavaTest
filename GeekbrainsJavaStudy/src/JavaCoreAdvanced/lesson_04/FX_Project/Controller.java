package JavaCoreAdvanced.lesson_04.FX_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    //Описание таблицы
    private TableView<RowWords> tav_output;
    //Создание столбцов
    @FXML
    //Колонка является мапой где ключом наш объект а значение слово
    private TableColumn<RowWords, String> wordTableColumn;
    @FXML
    private TableColumn<RowWords, Integer> countTableColumn;


    //Для хранениея данных в таблице - одна строка неопределенное колиство значений (для этого нужен объект)
    //коллекция будет иметь тип объекта совпадающий с типом объекта в таблице
    private final ObservableList<RowWords> frequencyByWord = FXCollections.observableArrayList(
            new RowWords("a", 1),
            new RowWords("b", 2),
            new RowWords("c", 3),
            new RowWords("d", 4)
    );


    //При первом открытии окна будет метод инициализации
    @FXML

    public void initialize() {

        //вносим данные коллекции в ListView
        //bt_send_text.setText("SetMessages");
        et_edit_text.setText("Привет!");
        lv_output_word.setItems(wordList);
        //добавляем коллекцию в TableView
        tav_output.setItems(frequencyByWord);
        //инициализируем поля таблицы
        wordTableColumn.setCellValueFactory(new PropertyValueFactory<>("Word")); //Word из RowWords
        countTableColumn.setCellValueFactory(new PropertyValueFactory<>("count")); //count из RowWords

    }

    @FXML
    //Добавление слова в список
    public void addWordToList(String word) {
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

    @FXML
    //Добавление слова в список
    public void addWord() {
        //Получем слово введенное в input поле
        String word = et_edit_text.getText().toString();
        //Вадидация что в осно ввода не пустое
        if (word.isEmpty()) {
            System.out.println("Вы ничего не ввели!");
        } else {
            //Получаем коллекцию элементов из ListView и добавляем в нее то что вводим внизу
            addWordToList(word);
            addWordToTable(word);
        }
        //Очищаем поле et_edit_text
        et_edit_text.clear();
    }

    private void addWordToTable(String word) {
    }

    //Выход в меню
    @FXML
    public void exit() {
        System.exit(1);
    }

}
