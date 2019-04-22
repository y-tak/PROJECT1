package multithreading.synchronises;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        ////new Semaphore(1) - ////количество разрешений
        IncreamentThread increamentThread=new IncreamentThread("increamentThrea",new Semaphore(1));

        DecrementThread decreamentThread=new DecrementThread("decreamentThread",new Semaphore(1));
    }


}


//общий ресурс
class  Counter
{
    static int count=0;
}


class IncreamentThread implements Runnable
{
    String name;
    Semaphore semaphore;

      public IncreamentThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();///запустили поток
    }

    @Override
    public void run() {
        System.out.println("Начало работы потока " + name);

        System.out.println("ожидание разрешения потоком " + name);
        try {
            semaphore.acquire(); ///запрашивает разрешение
            System.out.println("Поток " + name+ " получил разрешение ");
            for (int i=0;i<5;i++)
            {
                Counter.count++;
                System.out.println(" Counter.count= " +  Counter.count);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("потоку " + name+" больше не нужно разрешение");
        semaphore.release();

    }
}
///-------------------------------------------------------------
class DecrementThread implements Runnable
{   String name;
    Semaphore semaphore;

    public DecrementThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();///запустили поток
    }

    @Override
    public void run() {
        System.out.println("Начало работы потока " + name);

        System.out.println("ожидание разрешения потоком " + name);
        try {
            semaphore.acquire(); ///запрашивает разрешение
            System.out.println("Поток " + name+ " получил разрешение");
            for (int i=0;i<5;i++)
            {
                Counter.count++;
                System.out.println(" Counter.count= " +  Counter.count);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("потоку " + name+" больше не нужно разрешение");
        semaphore.release();
    }
}