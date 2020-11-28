package JavaCoreAdvanced.FXmessenger.net;

/* Port - отвечает за то что бы обратиться к определенному приложению на компьютере
*   (конкретное приложение или процесс к которому можно обратиться из сети)
*   - первая тысяча портов зарезервированы системой
*   - порт 8080 - является базовым портом для тестирования
*   - порт 8189 - будем использовать в проекте
*
* Сокет - это точка соединения, абстрактное понятие определяющее возможность подключения
*   - при соединении сокеты устанавливаются и на стороне клиента и на стороне сервера
*   - фактически является интерфейсом для обмена данными
*
* Stream - поток для передачи данных устанавливаемый после обмена сокетами между клиентом
*   и сервером
*   - при передаче данных исполользуются два потока, поток ввода in и поток вывода out,
*       например данные отправленные из потока out клиента будут приниматься потоком in
*       на сервере
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //номер порта
    private final static int SERVER_PORT = 8089;

    public static void main(String[] args) {

        //Создание сервер сокета, используем обработчик исключения с ресурсами что бы
        //автоматически закрывать сокет в случае исключения
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            PrintToStatusLine("Ожидание подключения...");
            //Получение клиентского сокета (блокируем поток и переходим в режим ожидания)
            Socket clientSocket = serverSocket.accept();
            //при подключении
            PrintToStatusLine("Соединение установлено!");

            //создаем входной поток для получения данных от клиента
            //Scanner in = new Scanner(clientSocket.getInputStream());
            // в данном случае будем работать напрямую с потоком Data Input Stream
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());

            //выходной поток для отправки сообщений с сервера
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            //будем ждать сокета от клиентов (необходимо будет вынести )
            new Thread(()->{
                while (true) {
                    String msg="";
                    try {
                        msg = in.readUTF();
                        PrintToStatusLine("Сообщение от пользователя получено: \nmsg:" + msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                        PrintToStatusLine("Ошибка получения сообщения");
                    }
                    //выйти из цикла и остановить сервер если придет следующее сообщение
                    if (msg.equals("/exit")) {
                        //после того как сервер будет остановлен
                        PrintToStatusLine("Сервер остановлен");
                        break;
                    }
                    //создадим ответ от сервера
                    try {
                        out.writeUTF("Ответ от сервера"+msg);
                        PrintToStatusLine("Ответ успешно отправлен");
                    } catch (IOException e) {
                        e.printStackTrace();
                        PrintToStatusLine("Ошибка ответа сервера"+msg.toUpperCase());
                    }

                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
            PrintToStatusLine("Порт уже занят");
        }

    }

    private static void PrintToStatusLine(String msg) {

        System.out.println(msg);
    }

}
