package control2;

import java.util.concurrent.*;

public class Restoran {

    public static void main(String[] args) {
        ArrayBlockingQueue<User> queueUser1=new ArrayBlockingQueue<>(3,true);
        ArrayBlockingQueue<User> queueUser2=new ArrayBlockingQueue<>(3,true);

        User user1=new User("h1");
        User user2=new User("h2");
        User user3=new User("h3");
        User user4=new User("h4");
        User user5=new User("h5");
        User user6=new User("h6");
        User user7=new User("h7");

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        synchronized (queueUser1) {

            fixedPool.execute(new Till(user1, queueUser1,queueUser2));
            fixedPool.execute(new Till(user2, queueUser1,queueUser2));
            fixedPool.execute(new Till(user3, queueUser1,queueUser2));
            fixedPool.execute(new Till(user4, queueUser1,queueUser2));
            fixedPool.execute(new Till(user5, queueUser1,queueUser2));
            fixedPool.execute(new Till(user6, queueUser1,queueUser2));
            fixedPool.execute(new Till(user7, queueUser1,queueUser2));
        }


        synchronized (queueUser2) {

            fixedPool.execute(new Till2(user1, queueUser1,queueUser2));
            fixedPool.execute(new Till2(user2, queueUser1,queueUser2));
            fixedPool.execute(new Till2(user3, queueUser1,queueUser2));
            fixedPool.execute(new Till2(user4, queueUser1,queueUser2));
            fixedPool.execute(new Till2(user5, queueUser1,queueUser2));
            fixedPool.execute(new Till2(user6, queueUser1,queueUser2));
            fixedPool.execute(new Till2(user7, queueUser1,queueUser2));
        }


       /// fixedPool.shutdown();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fixedPool.shutdown();
        System.out.println("KACCA1 очередь из " +queueUser1.size()+"человек: "+queueUser1.toString());
        System.out.println("KACCA2 очередь из " +queueUser2.size()+"человек: "+queueUser2.toString());



    }
}

////-----------------------------------------------------------
class Till implements Runnable {

    private  ArrayBlockingQueue queue1;
    private  ArrayBlockingQueue queue2;
    private User user;

    public Till(User user,ArrayBlockingQueue queue1,ArrayBlockingQueue queue2) {
        this.user = user;
        this.queue1=queue1;
        this.queue2=queue2;
    }

    public synchronized void putUser() {

       // System.out.println("КАССА1: пришел еще пользователь " +user);
            if (queue1.size() < 3)
            {
                try {
                queue1.put(user);
                System.out.println("добавлено в КАССА1: пользователь " + user);
            } catch(InterruptedException e)
            {
                e.printStackTrace();
            }
               }
        else {
                if (!queue2.contains(user)) {
                    System.out.println("КАССА1 = занята ");

                    //  System.out.println("КАССА1:пользователь ушел из очереди " + user);
                    try {
                        queue2.put(user);
                        System.out.println("КАССА2: добавлено пользователь " + user);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
       // System.out.println("КАССА1:Очередь из "+queue1.size() +" человек :"+ queue1.toString());

    }

        @Override
    public void run() {
        try {
           Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     //   System.out.println("работает КАССА1");
        putUser();

    }
}


class Till2 implements Runnable {
    private ArrayBlockingQueue queue1;
    private ArrayBlockingQueue queue2;
    private User user;

    public Till2(User user, ArrayBlockingQueue queue1,ArrayBlockingQueue queue2) {
        this.user = user;
        this.queue1=queue1;
        this.queue2=queue2;
    }



    public synchronized void putUser() {

    //    System.out.println("КАССА2: пришел еще пользователь " + user);
        if (queue2.size() < 3) {
            try {
                queue2.put(user);
                System.out.println("КАССА2: добавлено пользователь " + user);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("КАССА2 = занята ");
           if (!queue1.contains(user))
            {
               //  System.out.println("КАССА2: пользователь ушел из очереди " + user);
                try {
                    queue1.put(user);
                    System.out.println("КАССА1: добавлено пользователь " + user);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
      //  System.out.println("КАССА2: Очередь из " + queue2.size() + " человек :" + queue2.toString());

    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     //   System.out.println("работает КАССА2:");
        putUser();

    }
}
///--------------------------------------------------------
class User
{
    String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}