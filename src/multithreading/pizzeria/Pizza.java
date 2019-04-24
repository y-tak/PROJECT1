package multithreading.pizzeria;

//три потока  Официант, клиент и повар
//три очереди : новые заказы, заказы для кухни и готовые заказы
///официант беет заказ из очереди 1 и добавлят в очередь 2
///повар берет хаказ из очредие 2 и добавляет в очередь 3
//клиент забирает готовые заказы из очереди 3

import java.util.concurrent.ArrayBlockingQueue;

public class Pizza {

    public static void main(String[] args) {

        ArrayBlockingQueue<Order> newOrder=new ArrayBlockingQueue<>(3,true);// размер 3- в очереди может быть только 3 объекта, 4 пока не заберет какой то
        ArrayBlockingQueue<Order> forCook=new ArrayBlockingQueue<>(3,true);
        ArrayBlockingQueue<Order> done=new ArrayBlockingQueue<>(3,true);

        Waiter waiter1=new Waiter(newOrder,forCook);
        Waiter waiter2=new Waiter(newOrder,forCook);
        Waiter waiter3=new Waiter(newOrder,forCook);
        waiter1.start();
        waiter2.start();
        waiter3.start();

        Cook cook=new Cook(forCook,done);
        cook.start();

        Order meat=new Order("meat");
        Order jus=new Order("jus");
        Order bread=new Order("bread");
        Order apple=new Order("apple");



        Client client1=new Client(newOrder,done);
        Client client2=new Client(newOrder,done);
        Client client3=new Client(newOrder,done);

        client1.makeOrder(meat);
        client2.makeOrder(bread);
        client3.makeOrder(jus);





    }


}

class Waiter extends Thread {
    private ArrayBlockingQueue<Order> newOrder;
    private ArrayBlockingQueue<Order> forCook;

    public Waiter(ArrayBlockingQueue<Order> newOrder, ArrayBlockingQueue<Order> forCook) {
        this.newOrder = newOrder;
        this.forCook = forCook;
    }

    @Override
    public void run() {

        while (true)
        {

            try {
                Order order= null;
                order = newOrder.take();
                System.out.println("Официант принял заказ " + order.getName());
                forCook.put(order);
                System.out.println("0фициант передал на кухню " + order.getName());


            } catch (InterruptedException e)
             {
                e.printStackTrace();
            }

        }
    }
}


class Order{
    String name;

    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class Client extends Thread
{
    private ArrayBlockingQueue<Order> newOrder;
    private ArrayBlockingQueue<Order> done;

    public Client(ArrayBlockingQueue<Order> newOrder,ArrayBlockingQueue<Order> done)
    {
        this.newOrder=newOrder;
        this.done=done;
    }


    @Override
    public void run() {
        while (true)
        {
            try {
                System.out.println("клиент получил готовый заказ :" + done.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




public void makeOrder(Order order)
{
    try {
        newOrder.put(order);///добавдяет
        System.out.println("добавление заказа " + order.getName());

    } catch (InterruptedException e) {
        System.out.println("переполнено " + e);
    }

}


}

class Cook extends Thread
{
    ArrayBlockingQueue<Order> forCook;
    ArrayBlockingQueue<Order> done;

    public Cook(ArrayBlockingQueue<Order> forCook, ArrayBlockingQueue<Order> done) {
        this.forCook = forCook;
        this.done = done;
    }

    @Override
    public void run() {

        while (true)
        {

            try {

                Order order= null;
                order = forCook.take();
                System.out.println("Повар принял заказ " + order.getName());
               Thread.sleep(500);

                done.put(order);
                System.out.println("Повар передал на кухню " + order.getName());


            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }

    }
}

////создать побольше заказов..
////и ТОр100 на очередях