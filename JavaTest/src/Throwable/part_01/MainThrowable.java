package Throwable.part_01;

/*
    Исключения должны применяться только в исключительных ситуациях, они очень медленные
        и поэтому везде где это возможно необходимо пользоваться if/else а исключенния
        обрабаьывть только в самых крайних случаях когда через if/else нельзя


    Структура классов исключений:

    Throwable - основной класс выбрасывания исключения

        - Error - ошибки JVM которые мы не можем контролировать и соотвественно обрабатывать
                    (StackOverflow, завершение работы JVM)
            - подклассы Error

        - Exception - все exceptions кроме RuntimeException и Error требуют обработки
            - IOException
                    - EOFException
                    - FileNotFoundException
                    - MalformedURLException
                    - UnknownHostException
            - ClassNotFoundException
            - CloneNotSupportedException
            - другие подклассы Exception

            - RuntimeException - возникают в процессе выполнения программы и мы их не обрабатываем
                - NullPointerException
                - IndexOutOfBoundsException
                    - ArrayIndexOutBoundException
                - IllegalArgumentException
                    - NumberFormatException
                - ClassCastException
                - ArithmeticException
                - другие подклассы RuntimeException
*------------------------------------------------------------------------------------------
*   - наследоваться можно от любого класса Exception кроме Error
    - всегда надо стараться указывать наиболее возможную ошибку потому что
        каждый тип ошибки должен обрабатываться по разному, т.е. если возможно
        NullPointerException не надо писать Exception

    - throws - вписывается в сигнатуру метода и информирует что при выполненнии метода может
                появиться исключение

    - throw - вызвать ошибку в данном месте

    - finally - блока finally может не быть
                - в блок finally return не ставить потому что при нормальной работе
                    блок finally всегда будет выполняться


    - catch - блок в который переходит программа при обработке исключения
            - блока catch может не быть но тогда конструкция должна быть такого типа:
                    -  try{} finally{}
            - может быть несколько catch
            - catch может обработась сразу два исключения если написать
                    сatch (NullPointerException | ArithmeticException e)

*/


import AnimalsTest.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class MainThrowable {

    public static void main(String[] args) {

        //Пример RuntimeException - возникают в процессе выполнения программы и мы их не обрабатываем
        //компилятор не опознает ошибку, ошибка ArithmeticException появляется в процессе выполнения
        //в данном случае public class ArithmeticException extends RuntimeException {
        try {
            System.out.println(12 / 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        //Пример NullPointerException - тоже runtime
        //в данном случае public class NullPointerException extends RuntimeException {
        try {
            String str = null;
            str.toUpperCase(Locale.ROOT);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        //Пример Exception - это исключения которые видны IDE уже в процессе компиляции и до запуска
        //в данном случа public class InterruptedException extends Exception
        try {
            long startTime = System.currentTimeMillis();
            Thread.sleep(1000);
            long stopTime = System.currentTimeMillis();
            System.out.println("Sleep time: " + (stopTime - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Теперь при вызове метода в котором наверх было прокинуто обработка исключение
        //указывается что метод может вызвать исключение, поэтому  нужно либо обработать его либо
        //прокинуть еще выше прокидывать надо до уровня метода в котором происходит исключение чтобы
        //обработать его сразу а не когда выполнится половина кода метода
        //реакция на момент ошибки должны происходить в момент вызова метода и это становится проблемой тех
        //кто будет этот метод запускать :)))
        try {
            readFile("/123.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден ");
            e.printStackTrace();
        }

        //Пример возвращающий информацию об ошибке
        System.out.println("a/b = " + returnInt(10, 0));

        try {
            runAnimal();
        } catch (CustomRuntimeExceptionByAnimalType customRuntimeExceptionByAnimalType) {
            customRuntimeExceptionByAnimalType.printStackTrace();
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////

    //Прокидывание обработки информации о возможном исключении в сигнатуру
    private static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);//прокинули обработку исключения наверх
    }

    //Пример обработки ошибки внутри файла
    private static void readFile2(String path) {
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            //все переменные созданные в try не видны в catch, поэтому например
            //закрыть поток в catch не получится, переменная scanner не будет доступна
            e.printStackTrace();
        } finally {
            //блок который всегда будет выполняться и в котором можно закрыть поток
            scanner.close();
            //можно закрыть здесь или использовать автозакрываемый обработчик
        }
    }

    //Пример использования автозакрываемого обработчика (при наличии Closeable и Autocloseable)
    //public final class Scanner implements Iterator<String>, Closeable {
    //public interface Closeable extends AutoCloseable {
    private static void readFile3(String path) {
        File file = new File(path);
        //после выполнения любого из блоков try или catch поток будет закрыт
        try (Scanner scanner = new Scanner(file)) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int returnInt(int a, int b) {
        int res;

        try {
            res = a / b;
        } catch (ArithmeticException e) {
            res = -1;
            e.printStackTrace();
        } finally {
            //return -1; //типичный возврат ошибки только не указывать в finaly потому что он всегда
            //будет выполняться и метод всегжа будет возвращать одно и тоже
        }
        return res;
    }

    private static void runAnimal() throws CustomRuntimeExceptionByAnimalType {
        Animal[] animals = {
                new Dog("Шарик"),
                new Duck("Иннокентий"),
                new Cat("Мурка")};
        for (Animal animal : animals) {
            animal.run();
        }

        //Можно и через массив животных которые умеют бегать
        Run[] animalsInterf = {
                new Dog("Шарик"),
                new Duck("Иннокентий"),
                new Cat("Борис Николаевич")};

        //Хотим прерваться если к нам придет утка!
        //Пример создания собственного исключения
        for (Run animal : animalsInterf) {
            if (animal instanceof Duck) {
                throw new CustomRuntimeExceptionByAnimalType(((Duck) animal).getName());
            }
            animal.run();
        }

    }


}
