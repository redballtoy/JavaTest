package JavaCoreAdvanced.lesson_01.OOP;

import java.util.LinkedList;
import java.util.List;


//Виды блоков инициализации
public class BlocksInitialization {
    public static void main(String[] args) {

        //Пример инициализации в анонимном классе
        /*
        JFrame frame = new JFrame();{{
            add(new JPanel()){{
                add(new JLabel("Text")){{
                    setBackground(Color.BLACK);
                    setBackground(Color.WHITE);
                }};
            }};
        }};
       */



    }


}

class Foo{
    static List<Character> abc;
    static {
        abc = new LinkedList<Character>();
        for (char c = 'A'; c < 'Z'; ++c) {
            abc.add(c);
        }
    }
}
//Пример нестатического блока инициализации
class Bar{
    {
        System.out.println("Bar: новый экземпляр");
    }

}



