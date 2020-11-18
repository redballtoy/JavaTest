package Enums.part_1;

/*Enumeric - это класс который наследуется от Object
 *   - это класс с заранее заготовленным списком и опредением того что с этим списком может
 *      происходить
 *   - указанные в Enum перечисления являются объектами (анонимными классами)
 *   - перечислениям можно указывать поля
 *   - у каждого перечисления есть конструктор по умолчанию  BLACK()
 *   - enum нельзя ни от чего наследовать
 *   - у enum конструктора по умолчанию установлен private что бы нельзя было изменить объеты в нем
 *      public Color(String russianColor, String englishColor) { - будет ошибка
 *   - enum может реализовывать интерфейс поскольку для enum это будет просто еще один метод
 *      (желательно не нагружать enum логикой, только то что нужно для заполнения и вывода
 *          либо один только action в SQL_Command )
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
    //по умолчанию он private
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
