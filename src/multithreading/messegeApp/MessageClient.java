package multithreading.messegeApp;

import lesson12.messageApp.Message;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MessageClient {

    private Scanner in = new Scanner(System.in);
    private Connection connection;

    public MessageClient(Connection connection) {
        this.connection = connection;
    }

    public void start() throws IOException {

        System.out.println(" введите имя");
        String name = in.nextLine();

        //---поток получает сообщения
        Thread reader = new Thread(new Reader(connection));
        reader.start();

        ///----основной поток- отправляет сообщения
        while (true) {
            System.out.println("введите сообщения ");
            String mess = in.nextLine();
            if (mess != null) {
                Message message = new Message(name, mess);
                connection.sendMessage(message);
            }
        }


    }


    public static void main(String[] args) {
        try {
            MessageClient client = new MessageClient(new Connection(new Socket("127.0.0.1", 8080)));
            client.start();
        } catch (IOException e) {
          ///  e.printStackTrace();
        }

    }
//------------------------------------------------------------------------------------
    private class Reader implements Runnable   /// класс для чтения
{
    private Connection connection;


    public Reader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {

        try {
            while (!Thread.currentThread().isInterrupted()) {
                Message message = null;
                message = connection.readMessage();
                System.out.println("message client read= " + message);

            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Сервер отключен: ");
            Thread.interrupted();
            restart();

        }
    }
///--------------------------------------------попытка подключиться------------------
    public void restart() {
        while (true) {
            Connection connection = null;
            try {
                connection = new Connection(new Socket("127.0.0.1", 8080));
                if (connection != null) {
                    System.out.println(" есть connection = " + connection);
                   break;
                } else restart();
            } catch (IOException e) {
                restart();
            }

        };

      try {
            MessageClient client = new MessageClient(new Connection(new Socket("127.0.0.1", 8080)));
            client.start();
        } catch (IOException e) {
          System.out.println(" не могу подключиться снова ");
            ///  e.printStackTrace();
        }


    }
}
///---------------класс Reader----------------------------
}


