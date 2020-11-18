package Enums.part_1;

/*Enumeric - это класс который наследуется от Object
 *   - указанные в Enum перечисления являются объектами (анонимными классами)
 *   - перечислениям можно указывать поля
 *   - у каждого перечисления есть конструктор по умолчанию  BLACK()
 *
 * */

public enum Color {
    //После создания конструктора по умолчанию требуется инициализировать поля
    //их может быть несколько
    BLACK("черный", "black"),
    BROWN("коричневый", "brown"),
    WHITE("белый", "white");

    //добавление полей к перечислениям
    private String russianColor, englishColor;

    //при создании конструктора переопределяется конструктор по умолчению
    Color(String russianColor, String englishColor) {
        this.russianColor = russianColor;
        this.englishColor = englishColor;
    }

    //для доступа к приватному russianColor нужно использовать геттер
    public String getRussianColor() {
        return russianColor;
    }

    public String getEnglishColor() {
        return englishColor;
    }
}
