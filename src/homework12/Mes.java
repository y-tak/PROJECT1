package homework12;

import java.io.*;
import java.util.Date;
import java.util.List;

public class Mes implements Serializable {

    private String sender;
    private String messageText;
    private Date lastLaunch;
    private static final long serialVersionUID = 0L;
    private static final int VERSION = 0;
    private  String[] users;

    public Mes(String sender, String messageText) {
        this.sender = sender;
        this.messageText = messageText;
        this.lastLaunch = new Date();
    }


    public Mes()  { }

    public Mes(String sender) {
        this.sender = sender;
    }

    public boolean isFirstLaunch() {
        return  lastLaunch == null;
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

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException
//    {
//        out.writeInt(VERSION);
//        out.writeObject(lastLaunch);
//        out.writeObject(sender);
//        out.writeObject(messageText);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        int version = in.readInt();
//        {
//            if (version > VERSION) {
//                throw new IOException("версии не совпадают");
//            }
//            lastLaunch = (Date) in.readObject();//
//        sender = (String) in.readObject();
//        messageText = (String) in.readObject();
//    }
//
//
//        }
//    }


    @Override
    public String toString() {
        return "Mes{" +
                "sender='" + sender + '\'' +
                ", messageText='" + messageText + '\'' +
                ", lastLaunch=" + lastLaunch +
                                '}';
    }


}
