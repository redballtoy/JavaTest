package JavaCoreAdvanced.lesson_04.FX_Project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RowWords {
    //FXML требует что бы данные оборачивались в специальную оболочку
    private SimpleStringProperty Word;
    private SimpleIntegerProperty count;

    public RowWords(String word, int count) {
        Word = new SimpleStringProperty(word);
        this.count = new SimpleIntegerProperty(count);
    }

    public String getWord() {
        return Word.get();
    }

    public SimpleStringProperty wordProperty() {
        return Word;
    }

    public void setWord(String word) {
        this.Word.set(word);
    }

    public int getCount() {
        return count.get();
    }

    public SimpleIntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
    }
}
