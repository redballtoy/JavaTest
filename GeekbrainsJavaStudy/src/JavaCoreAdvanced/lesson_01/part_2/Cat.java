package JavaCoreAdvanced.lesson_01.part_2;

public class Cat {
    public static final String BLACK = "черная";
    public static final String WHITE = "белая";
    public static final String ORANGE = "рыжая";

    //Позволяет использовать только заданные варианты
    private static Color color = Color.BLACK;

    public static void main(String[] args) {
        if (color == Color.BLACK) {
            System.out.println(BLACK.toString());
        }

        switch (color) {
            case BLACK:
                System.out.println(Color.BLACK.getRussianTranscriptionColor());
                break;
            case WHITE:
                System.out.println(Color.WHITE.getRussianTranscriptionColor());
                break;
        }


    }


}
