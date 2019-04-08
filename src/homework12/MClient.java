package homework12;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class MClient {

        private String server;
        private int port;
        private Connection connection;
        private Scanner scanner;

    public MClient(String server, int port)
    {
        this.server = server;
        this.port = port;
        this.scanner = new Scanner(System.in);
    }

        public void start()
        {
        System.out.println("Введите имя");
        String name = scanner.nextLine();


        String messageText;
        while (true){
            System.out.println("Введите команду");
            messageText = scanner.nextLine();
            messageText=messageText.substring(1);

            try {
                buildAndSend(name, messageText);
                printMessage();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }



        private void buildAndSend(String name, String messageText) throws IOException {
        connection = new Connection(new Socket(server, port));
        Mes message = new Mes(name, messageText);
        connection.sendMessage(message);
    }

        private void printMessage() throws IOException, ClassNotFoundException {
        Mes message = connection.readMessage();
        System.out.println("ответ от сервера: " + message.getMessageText());
    }

        public static void main(String[] args) {
        try (InputStream inputStream =
                     MClient.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")){

            Properties properties = new Properties();
            properties.load(inputStream);

            String server = properties.getProperty("server");//"127.0.0.1";
            int port = Integer.parseInt(properties.getProperty("port")); //8090;
            MClient messageClient =
                    new MClient(server, port);
            messageClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    }
