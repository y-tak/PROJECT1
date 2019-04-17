package multithreading.messegeApp;

import java.io.Serializable;

public class Message implements Serializable {
    String messageText;
    String sender;

    public Message(String messageText, String sender) {
        this.messageText = messageText;
        this.sender = sender;
    }

    public Message() {
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageText='" + messageText + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
