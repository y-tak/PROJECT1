package lesson12.messageApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection
{
    private Socket socket;

    private ObjectInputStream inobj;
    private ObjectOutputStream objectOutputStream;


    public Connection(Socket socket) throws IOException
    {

        this.inobj= new ObjectInputStream(socket.getInputStream());
        this.objectOutputStream= new ObjectOutputStream (socket.getOutputStream());
        this.socket = socket;
    }

    public  Message readMessage() throws IOException, ClassNotFoundException {
Message message=(Message) inobj.readObject();
return message;
}

    public  void writeMessage(Message message) throws IOException {
        objectOutputStream.writeObject(message);
        objectOutputStream.flush();

    }

}
