package lesson12.messageApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;

public class MessageServer {

    private int port;


    public MessageServer(int port)
    {
        this.port=port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket=new ServerSocket(port))
        {
            System.out.println(" Server start ");
            while (true)
            {
                Socket socket=serverSocket.accept();//подключение клиент-серверная связь
                getMessage(socket);
                ///отпарвление сообщение
                sendNessage(new Message("server ", "coooщение сервера"));

            }
        }

    }

    public void sendNessage(Message message) throws IOException {

        Message message1=message;
        Socket socket=null;

        try
        {
            String server="127.0.0.1";
            int port=8090;
            socket=new Socket();

            socket.connect(new InetSocketAddress(server,port));


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
//----------
public void sendNessage1(Socket socket) throws IOException {

    Message message1=new Message("server ", "coooщение сервера");

    try
    {
        try (OutputStream out=socket.getOutputStream();
             ObjectOutputStream objectOutputStream=new ObjectOutputStream(out);)

        {objectOutputStream.writeObject(message1);
            objectOutputStream.flush(); ///принудительно отправить
        }
    }

    finally {
        socket.close();
    }

}
        ////---------------------------------------------------------------

    public void getMessage(Socket socket) throws IOException {
        try (ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream()))
        {
            Object obj=objectInputStream.readObject();
            printMessage((Message)obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



    private void printMessage(Message obj)
    {
        System.out.println("полученные сообщения "+ obj.getMessageText()+"от  " + obj.getSender());
    }

    public static void main(String[] args) {
        int port=8090;
        MessageServer messageServer=new MessageServer(port);

        try {
            messageServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}


