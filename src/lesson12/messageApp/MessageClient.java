package lesson12.messageApp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Properties;
import java.util.Scanner;

public class MessageClient {
    private Connection connection;

    SocketAddress address;  ///ip:port
    private Scanner scanner;


    public MessageClient(SocketAddress address,Connection connection)
    {
       // this.address = address;
        this.scanner=new Scanner(System.in);
        this.connection= connection;

    }

    public void start() throws IOException {
        Socket socket=new Socket();
        socket.connect(address);

       this.connection=new Connection(socket);


        System.out.println(" Введите имя Sendler");
        String name=scanner.nextLine();
        while (true)
        {
            System.out.println("Введите сообщение");
            String messegeText=scanner.nextLine();
            connection.writeMessage(new Message(name, messegeText));
            //buildAndSend(name, messegeText);

        }
    }

    public void buildAndSend(String name, String messageText) throws IOException {
        Message message=new Message(name,messageText);
        Socket socket=null;
        try
        {   socket=new Socket();
            socket.connect(address);
            try (OutputStream out=socket.getOutputStream();
                 ObjectOutputStream objectOutputStream=new ObjectOutputStream(out);)
            {objectOutputStream.writeObject(message);
            objectOutputStream.flush(); ///принудительно отправить

            }
        }
        finally {
            socket.close();
        }

    }

    public static void main(String[] args) {

//        String server="127.0.0.1";
//        int port=8090;


        try (InputStream inputStream=MessageClient.class
                .getClassLoader()
                .getResourceAsStream("config.properties"))
        {
            Properties properties=new Properties();
            properties.load(inputStream);
            String server=properties.getProperty("server");
            int port= Integer.parseInt(properties.getProperty("port"));

           /// MessageClient messageClient=new MessageClient(new InetSocketAddress(server,port));
           Socket socket=new Socket();
           Connection connection=new Connection(socket);
           MessageClient messageClient=new MessageClient(new InetSocketAddress(server,port),connection);

            try {
                messageClient.start();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }




    }



}
