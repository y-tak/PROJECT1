package multithreading.pool;

import java.util.concurrent.*;

public class ExecutorServices {
    public static void main(String[] args) {

        ExecutorService fixetPool= Executors.newFixedThreadPool(2);//создается 2 потока
        fixetPool.execute(new RunnableTask("fixetPool"));
        fixetPool.execute(new RunnableTask("fixetPool"));
        fixetPool.execute(new RunnableTask("fixetPool"));
        fixetPool.execute(new RunnableTask("fixetPool"));
        fixetPool.execute(new RunnableTask("fixetPool"));

        fixetPool.shutdown();//завершим
        /// fixetPool.execute(new RunnableTask("fixetPool"));

        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.execute(new RunnableTask("singleThread"));// просто выполняет
        singleThread.shutdown();

        ExecutorService cacheThread = Executors.newCachedThreadPool();//// сам думает сколько создать потоков..
        cacheThread.submit(new RunnableTask(" cacheThread ")); ///возвращает объект Future
        cacheThread.submit(new RunnableTask(" cacheThread "));
        cacheThread.submit(new RunnableTask(" cacheThread "));
        cacheThread.submit(new RunnableTask(" cacheThread "));
        cacheThread.submit(new RunnableTask(" cacheThread "));
        cacheThread.submit(new RunnableTask(" cacheThread "));
        cacheThread.shutdown();
        ////execute() просто выполняет метод потока
        ////submit() возвращает объект Future


        ////выполнение задач через промежутки времени.. свои пулы потоков
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Future future1 = scheduledExecutorService.schedule(new CallableTask("scheduledExecutorService"), 5, TimeUnit.SECONDS);
        try {
            future1.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();


        ///выполнение кажды 5 сек
        ScheduledExecutorService runEveryFiveSecond = Executors.newSingleThreadScheduledExecutor();
        runEveryFiveSecond.scheduleAtFixedRate(new RunnableTask("runEveryFiveSecond"), 0, 5, TimeUnit.SECONDS);
        runEveryFiveSecond.shutdown();

        ScheduledExecutorService everySecond = Executors.newSingleThreadScheduledExecutor();
        everySecond.scheduleWithFixedDelay(new RunnableTask("everySecond"), 0, 1, TimeUnit.SECONDS);
        everySecond.shutdown();




    }
}

class CallableTask implements Callable<Integer>
{  String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("поток Callable= " + name+" "+(2+3));
        return 2+3;
    }
}
///-----------------------------------------------
class RunnableTask implements Runnable {
String name;

    public RunnableTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("поток "+Thread.currentThread().getName()+"  Runnable= " + name+" - "+(2+3));
    }
}