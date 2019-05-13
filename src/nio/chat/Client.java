package nio.chat;

import nio.chat.Worker;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket();
        socket.connect(new InetSocketAddress("localhost",12345));


        new Thread(new Receiver(socket)).start();
        new Thread(new Sender(socket)).start();
    }

    ///----------------------------receiv--------------
    private static class Receiver extends Worker
    {
        private InputStream in;
        private Socket socket;
        private byte[] buf;

        public Receiver(Socket socket) {
            this.socket = socket;
            buf=new byte[1024];
        }

        @Override
        protected void init() throws IOException {
           in=socket.getInputStream();
        }

        @Override
        protected void stop() throws IOException {
           socket.close();
        }

        @Override
        protected void loop() throws IOException {
            int read=in.read(buf);
            System.out.println(new String(buf,0,read));
        }
    }


    ///-------------------------------------send-------------------

    private static class Sender extends Worker{
       private OutputStream out;
       private Socket socket;
       private Scanner scanner;

        public Sender(Socket socket) {
            this.socket = socket;
        }

        @Override
        protected void init() throws IOException {
            out=socket.getOutputStream();
            scanner=new Scanner(System.in);
        }

        @Override
        protected void stop() throws IOException {
            socket.close();     }

        @Override
        protected void loop() throws IOException {
            String str=scanner.nextLine();
            out.write(str.getBytes("UTF-8")); }
    }
}
