package multithreading.messegeApp;

import homework12.Mes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import lesson12.messageApp.Message;

public class MessageServer {
    private int port;
    private Set<Connection> connectionSet=new CopyOnWriteArraySet<>();
    private BlockingDeque<Message> messages=new LinkedBlockingDeque<>();///блокирующая очередь

    public MessageServer(int port) {
        this.port = port;
    }

    private class Writer implements Runnable
    {
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted())
                {
                    Message message= messages.take();

                    for (Connection c : connectionSet)
                    {
                        c.sendMessage(message);
                    }
                    messages.remove(message);

                }
            }
            catch (InterruptedException e)
            {

                e.printStackTrace();}
            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    ///------
    private class Reader implements Runnable
    {
        private Connection connection;

        public Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
            while (!Thread.currentThread().isInterrupted())
            {
               Message message = null;
                message = connection.readMessage();

                messages.add(message);
                System.out.println("message server read = " + message);
            }
            }catch (IOException|ClassNotFoundException  e) {
                ////если нет соединений
                System.out.println("клиент соединения отключен: " + connectionSet.toString());
                connectionSet.remove(connection);
               // e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        MessageServer server=new MessageServer(8080);
        server.start();
    }


    public void start()
    {
        new Thread(new Writer()).start();
        try (ServerSocket serverSocket=new ServerSocket(port))
        {
            System.out.println("server start "+new Date());
            while (true)
            {
                Socket socket=serverSocket.accept();

                Connection connection=new Connection(socket);

                connectionSet.add(connection);

                new Thread(new Reader(connection)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
