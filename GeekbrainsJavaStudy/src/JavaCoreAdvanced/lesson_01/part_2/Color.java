package JavaCoreAdvanced.lesson_01.part_2;

public enum Color {
    //это все объекты типа enum, можно прописывать поля и метожы
    //BLACK ->enum -> Object
    BLACK("черный")
    , ORANGE("оранжевый")
    , WHITE("белый");

    //Добавляем поля
    private String russianTranscriptionColor;

    //конструктор
    Color(String russianTranscriptionColor) {
        this.russianTranscriptionColor = russianTranscriptionColor;

    }

    public String getRussianTranscriptionColor() {
        return russianTranscriptionColor;
    }

    @Override
    public String toString() {
        return "Color{" +
                "russianTranscriptionColor='" + russianTranscriptionColor + '\'' +
                name();
    }
}
