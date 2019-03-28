package lesson9.collect.enumer;

import java.util.*;

////----------------перечисления-------
enum  MessagePriory
{
    LOW,MEDIUM,HIGH,URGENT;

public static MessagePriory getPriory(int ord)
{
    for (MessagePriory m:values()) {
        if (m.ordinal()==ord) return m;
    }
    throw new AssertionError("ошибка "+ord);
}
}


public class Message {

    private int code;
    private MessagePriory priory;


    public Message(int code, MessagePriory priory) {
        this.code = code;
        this.priory = priory;
    }

    public int getCode()
    {
        return code;
    }


    public void setCode(int code)
    {
        this.code = code;   }

    public MessagePriory getPriory() {
        return priory;
    }

    public static void main(String[] args)
        {


        System.out.println(MessagePriory.HIGH);

        MessageGenerate.generate(10);

        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (code != message.code) return false;
        return priory == message.priory;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (priory != null ? priory.hashCode() : 0);
        return result;
    }
}

class MessageGenerate {

    public static List<Message> generate(int num)
    {
        if (num <= 0) {
            return Collections.emptyList();
        }

        Random random = new Random();

        List<Message> messages = new ArrayList<>(num);

        ///values()- количество перечилений enumy

        int typeC = MessagePriory.values().length - 1;

        for (int i = 0; i < num; i++)
        {
            messages.add(new Message(random.nextInt(), MessagePriory.getPriory(random.nextInt(typeC))));
        }

        for (Message o:messages ) 
        {
            System.out.println("o = " + o.getCode()+"pr "+o.getPriory());
        }
        return messages;

       
        
    }

    public MessageGenerate()
    {
    }
}

