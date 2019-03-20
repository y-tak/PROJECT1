package homework5.LIstStrackQueue;

public class Homework5 {
    public static void main(String[] args) {

     ///-----------------------задача 1-------------------------
     //не сделалал------------------

//ListObject listObject=new ListObject();
//listObject.list();

        System.out.println("-------ОЧЕРЕДЬ---------------первый вошел - первый вышел-------");


QueueObject queueObject=new QueueObject(1,new Object());
QueueObject queueObject1=new QueueObject(2, queueObject);
QueueObject queueObject2=new QueueObject(3, queueObject1);
queueObject2.queue();
        System.out.println("-------СТЭК---------------первый вошел - последений вышел-------");

StrackObject strackObject=new StrackObject(1,new Object());
StrackObject strackObject1=new StrackObject(2,strackObject);
StrackObject strackObject2=new StrackObject(3,strackObject1);
strackObject2.strack();

        System.out.println("-------ЛИСТ---------------по порядку-------");

        ListObject listObject=new ListObject(1,new Object());
        ListObject listObject1=new ListObject(2,listObject);
        ListObject listObject2=new ListObject(3,listObject1);
        listObject2.list();

    }
}