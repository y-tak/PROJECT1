package homework12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class Connection {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(this.socket.getOutputStream());
        in = new ObjectInputStream(this.socket.getInputStream());
    }

    public void sendMessage(Mes message) throws IOException {
        out.writeObject(message);
        out.flush();
    }

    public Mes readMessage() throws IOException, ClassNotFoundException {
        return (Mes) in.readObject();
    }
}

