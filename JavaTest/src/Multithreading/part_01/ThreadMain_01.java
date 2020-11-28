package Multithreading.part_01;

/*Процесс - это программа - оболочка отделенная от других процессов имеющая выделенные
    для нее ресурсы, стек и объем памяти
* Thread - поток внутри процесса который выполняет отдельную задачу в процессе-приложении
    и пользуется общими ресурсами процесса приложения
    - потоки в процессе работы могут обращаться к своему родительскому процессу и самое главное
        могут выполняться асинхронно
*
* */

public class ThreadMain_01 {

    //создание основного потока
    public static void main(String[] args) {
        //определяем поток в который можем что нибудь положить
        Thread thread;

        //получение потока который дойдет до данной строки с помощью статического метода
        //currentThread, это позволит знать какой поток выполняется и обращаться к его свойствам
        thread = Thread.currentThread();
        //отобразим имя потока и его приоритет
        System.out.println(thread);

        //можно изменить имя и указать другой приоритет а так же приостановить выполнение потока
        thread.setName("Новое имя потока main");
        thread.setPriority(6);
        System.out.println("Ждемс...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread);
    }

}