package homework12;

import javax.xml.crypto.Data;
import java.io.IOException;

import java.net.*;
import java.util.Date;


public class Mserver {

    private int port;
    Connection connection;


    public Mserver() {
    }

    ///------------------------------------------------------------------
    public String server_time(Mes message)
    {
       return "сервер время = " + new Date();

    }
    ///--------------------------------------------------------------------
    public String ping_time(Date date1,Date date2)   {
        Date newDate=date1;///date1messageIn.getLastLaunch();
        Date oldDate=date2;//messageOut.getLastLaunch();

        int diffInDays = (int)( (newDate.getTime() - oldDate.getTime())
                / (1000 * 60 * 60 * 24) );

        return "время отклика "+diffInDays;
    }
    //----------------------------
    public String list_user(Mes m)    {

        return "список пользователей "+m.getSender();
    }


    ///------------------------------------------------------------

    public Mserver(int port)
    {
        this.port = port;
    }
//--------------------------------------------
    public void start() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");

            while (true)
            {
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                Mes mm=connection.readMessage();
                printMessage(mm);
                String mesTextOut=someVoidForMessage(mm);
                Mes mes=new Mes("server", mesTextOut);
                connection.sendMessage(mes);

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
    ///---------------------------------------------------------------------------------
    private String someVoidForMessage(Mes message){

               String mesText=message.getMessageText();
               String mesTextOut="";

                if ( mesText.equals("list_user"))  {mesTextOut=list_user(message);}
                else if ( mesText.equals("server_time")) { mesTextOut=server_time(message);}
               else if ( mesText.equals("ping")) {mesTextOut=ping_time(new Date(),message.getLastLaunch());}
               else  { mesTextOut="сообщение получено";}
               return  mesTextOut;


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