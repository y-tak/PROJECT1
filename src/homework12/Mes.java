package homework12;

import java.io.*;
import java.util.Date;
import java.util.List;

public class Mes implements Externalizable {

    private String sender;
    private String messageText;
  //  private int launchCount;
    private Date lastLaunch;
    private static final long serialVersionUID = 0L;
    private static final int VERSION = 0;


    public Mes(String sender, String messageText) {
        this.sender = sender;
        this.messageText = messageText;


    }
    public Mes(String sender, String messageText,String lastUser) {
        this.sender = sender;
        this.messageText = messageText;


    }

    public Mes() {
    }


    public Mes(String sender, String messageText, Date lastLaunch, String lastUser) {
        this.sender = sender;
        this.messageText = messageText;
        this.lastLaunch = lastLaunch;

    }

    public boolean isFirstLaunch() {
        return  lastLaunch == null;
    }




///--------------------------------------------
    public void update() {
        lastLaunch = new Date();


    }
    public String getSender() {
        return sender;
    }

    public Date getLastLaunch() {
        return lastLaunch;
    }

    public String getMessageText() {
        return messageText;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeInt(VERSION);
        out.writeObject(lastLaunch);
        out.writeObject(sender);
        out.writeObject(messageText);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        {
            if (version > VERSION) {
                throw new IOException("версии не совпадают");
            }
            lastLaunch = (Date) in.readObject();



        }
    }

    @Override
    public String toString() {
        return "Mes{" +
                "sender='" + sender + '\'' +
                ", messageText='" + messageText + '\'' +
                ", lastLaunch=" + lastLaunch +
                                '}';
    }
}
