package multithreading.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {


        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                ///настройки
                1,//основное количество потоков
                10,//максимальное количесто потоков
                2, TimeUnit.MINUTES,//сколько потоки будут простаиваться пока нет заданий
                new ArrayBlockingQueue<>(3)//очередь для задач
        );

        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();// hразные потоки

        queue.add(new Task());
        queue.add(new Task2());
        queue.add(new Task3());
        queue.add(new Task2());
        queue.add(new Task3());
        queue.add(new Task2());
        queue.add(new Task());
        queue.add(new Task2());

        for (Runnable runnable:queue)
        {pool.execute(runnable);}

        pool.shutdown();
    }

}

////--------------------------------------------
class Task implements Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + Thread.currentThread().getName());
    }
}
///------------------------------------
class Task2 implements Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task2 " + Thread.currentThread().getName());
    }
}
///--------------------------------
class Task3 implements Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task3 " + Thread.currentThread().getName());
    }
}