package IO.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MaintIO {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("JavaTest/src/IO/files/input.txt");
        File output = new File("JavaTest/src/IO/files/output.txt");

        Scanner scanner = new Scanner(input);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a);
        System.out.println(b);

        PrintWriter printWriter = new PrintWriter(output);
        //выводим информацию по сложению
        printWriter.print(a + b);
        printWriter.close();//не забыть закрыть поток

    }
}
