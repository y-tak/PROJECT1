package homework12;

import javax.xml.crypto.Data;
import java.io.IOException;

import java.net.*;
import java.util.Date;


public class Mserver {

    private int port;
    Connection connection;
    private  StringBuilder users;

    public Mserver() {
    }

    public Mserver(int port)
    {
        this.port = port;
    }
///------------------------------------------------------------------
public void server_time(Mes message)
{
    System.out.println("время сообщения= " + message.getLastLaunch());
}
///--------------------------------------------------------------------
public void ping_time(Mes messageOut,Mes messageIn)   {
        Date newDate=messageIn.getLastLaunch();
    Date oldDate=messageOut.getLastLaunch();
    int diffInDays = (int)( (newDate.getTime() - oldDate.getTime())
               / (1000 * 60 * 60 * 24) );
       System.out.println(""+diffInDays);
    }
    //----------------------------
    public void list_user(Mes message)    {
        users.append(message.getSender());
        System.out.println("users = " + users);

    }
//--------------------------------------------
    public void start() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");

            while (true)
            {
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                printMessage(connection.readMessage());
                Mes mes=new Mes("server", "сообщение получено");
                connection.sendMessage(mes);
              //  mes.update();
              //  users.append(connection.readMessage().getSender());

                ///-------------
            //  server_time(mes);
             //  ping_time(connection.readMessage(),mes);
              // list_user(connection.readMessage());
///------------------
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    private void printMessage(Mes message){
        System.out.println("получено сообщение: " +
                message.getMessageText() + " от " + message.getSender());
    }


    ///-----------------------------------------
    public static void main(String[] args) {
        int port = 8090;
        Mserver messageServer = new Mserver(port);
        try {
            messageServer.start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}