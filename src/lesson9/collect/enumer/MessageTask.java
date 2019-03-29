package lesson9.collect.enumer;

import java.util.*;
import java.util.stream.Collectors;

public class MessageTask {

    public static void main(String[] args) {

        List<Message> messages = new ArrayList<>();
        messages = MessageGenerate.generate(10);
        //----для удаления-----
        List<Message> messages1 = new ArrayList<>();
        messages1 = MessageGenerate.generate(10);

        System.out.println(" Генерация  первых сообщений ");
        for (Message o : messages) {
            System.out.println("o = " + o.getCode() + " pr: " + o.getPriory());
        }

        //1
        countEachPriority(messages);
        //2
        countEachCode(messages);
        //3
        uniqueMessageCount(messages);
        //4
        List<Message> messagesUnic = new ArrayList<>();
        messagesUnic = uniqueMessagesInOriginalOrder(messages);
        for (Message m:messagesUnic)
        {
            System.out.println("o " + m.getCode()+" pr "+ m.getPriory());
        }

        //5
        removeEach(messages, MessagePriory.HIGH);

        System.out.println(" Генерация  первых сообщений ");
        for (Message o : messages1) {
            System.out.println("o = " + o.getCode() + " pr: " + o.getPriory());
        }

        //6
        removeOther(messages1, MessagePriory.LOW);


    }


    public static void countEachPriority(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого приоритела
        // Ответ в консоль
        int kol;
        System.out.println("Подсчитать количество сообщений для каждого приоритела");
        for (MessagePriory m : MessagePriory.values()) {
            kol = 0;
            for (Message kl : messageList) {
                if (kl.getPriory() == m) kol++;
            }
            System.out.println("с приоритетом " + m + " всего " + kol);
        }
    }


    public static void countEachCode(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого кода сообщения
        // Ответ в консоль
        int kol;
        kol = 0;
        Set<Integer> setm = new HashSet();
        System.out.println("Подсчитать количество сообщений для каждого кода сообщения");
        for (Message lk : messageList) {
            setm.add(lk.getCode());
        }
        for (Integer kl : setm) {
            kol = 0;
            for (Message lk : messageList) {
                if (kl == lk.getCode()) kol++;
            }
            System.out.println("с кодом " + kl + " всего " + kol);
        }
    }


    private static void uniqueMessageCount(List<Message> messageList) {

        // Подсчитать количество уникальных сообщений
        // Ответ в консоль
        System.out.println("Подсчитать количество уникальных сообщений");
        Set<Message> messages=new HashSet<>(messageList);

        System.out.println("всего "+messages.size());

    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList)
    {
        // вернуть только неповторяющиеся сообщения и в том порядке, в котором они
        // встретились в первоначальном списке
        // Например, было
//        [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        // на выходе:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        List<Message> messageList1=new ArrayList<>();
        messageList1.add(messageList.get(0));

        System.out.println("уникальные и не повторяющиеся");
        int kol=0;
        for (Message lk : messageList)
        {
            Message m=messageList.get(kol);
           if (messageList.contains(m)==true && messageList1.contains(m)==false)
            {
                messageList1.add(lk);
            }
            kol++;
    }
        return messageList1;
    }

    public static void removeEach(List<Message> messageList, MessagePriory priority){
        // удалить из коллекции каждое сообщение с заданным приоритетом
        // вывод до удалеия и после удаления

        System.out.println("удалить из коллекции каждое сообщение с заданным приоритетом HIGH");
         int kol=0;
        for (int i=0;i<messageList.size();i++)
        {
            if (kol<messageList.size()&& messageList.get(i).getPriory()==priority)  messageList.remove(i);
            kol++;
        }
        for (Message lk : messageList)
        {
            System.out.println("o = " + lk.getCode()+" pr "+lk.getPriory());
        }


    }

    public static void removeOther(List<Message> messageList, MessagePriory priority){
        // удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        // вывод до удалеия и после удаления

        System.out.println("удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет LOW");
        int kol=0;
        for (int i=0;i<messageList.size();i++)
        {
            if (messageList.isEmpty()==false && messageList.get(i).getPriory()!=priority)
            {messageList.remove(i);
            i--;
            }
        }
        for (Message lk : messageList)
        {
            System.out.println("o = " + lk.getCode()+" pr "+lk.getPriory());
        }

    }


}
