package multithreading;

import java.util.concurrent.ThreadFactory;

public class MultiThreadExample {

    //start() - запускать поток
    //Thread.currentThread();/// получаем текущий поток
    //setName() хзадать имя потоку
    ///getName получить имя потока
   ///getState()  - возвращает текущее состояние потока
    //isAlive() - возвращает true если поток выполняется , в противном случае false
    //// setDaemon(true);///этот поток завершиться тогда, когда завершиться основной поток


    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();

        Thread myTread = new MyTread();
        myTread.start();

        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread myTread1 = new Thread(new OtherTread("vasya"));
        System.out.println("myTread1.getState() = " + myTread1.getState());
        Thread myTread2 = new Thread(new OtherTread("masha"));
        Thread myTread3 = new Thread(new OtherTread("petya"));

        myTread1.start();
        myTread2.start();
        myTread3.start();
///----------намерено хотим завкршить потоки.. а пото основной завершиться
        try {
            System.out.println(" ожидание завершения потока" );
            myTread1.join();
            myTread2.join();
            myTread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
////инициализация анонимным классом

Thread myTread4=new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Runnoing: "+Thread.currentThread().isAlive());
        System.out.println("Runnoing: "+Thread.currentThread().getState());
    }
});
        myTread4.start();
        System.out.println("myTread4.getState() = " + myTread4.getState());

        //myTread4.setDaemon(true);///завершиться основной поток


       // Thread whilethread=new WhileThread();
     //   whilethread.setDaemon(true);
       // whilethread.start();


        ////прерывание потока
        ///поток останавливается в следующих случаях
        //1.если поток выполнил все инструкции и вышел из метода run()
        //2.если в потоке было выброшено необрабатываемое исключение
        //3.Остановилась JVM
        //4.Если это Daemon  поток и основной поток завершил свою работу
////почитать про Stack и Heap память
        ///у каждого потока существует флаг, который можно вызвать методом isInterrupted()

        ///и етсь метод interrupt() - устанавливает значение флага true
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted())
                {
                    System.out.println(" thread2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                       Thread.currentThread().interrupt();///он остановаиться и не войдет в цикл
                        e.printStackTrace();
                    }

                }

            }
        });
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.interrupt();



        System.out.println(" Завершение основного потока" );
        System.out.println("myTread1.getState() = " + myTread1.getState());
    }
}



class WhileThread extends Thread
{
    @Override
    public void run() {
        while (true)
        {
            System.out.println(" WhileThread ");
        }
    }
}

///cоздание класса потока
///наследование от класса Thread
class MyTread extends Thread {
    @Override
    public void run() {
        Thread.currentThread().setName("My");/// текущий поток
        System.out.println(Thread.currentThread().getName());

    }
}

class OtherTread implements Runnable {
    String name;

    public OtherTread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

    }
}