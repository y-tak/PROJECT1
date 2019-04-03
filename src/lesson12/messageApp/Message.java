package lesson12.messageApp;

import java.io.Serializable;

public class Message implements Serializable {
    private String sender;
    private String messageText;


    public Message(String sender, String messageText) {
        this.sender = sender;
        this.messageText = messageText;
    }

    public String getSender() {
        return sender;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
