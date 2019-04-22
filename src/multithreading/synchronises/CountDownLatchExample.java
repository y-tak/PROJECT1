package multithreading.synchronises;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static  final CountDownLatch START =new CountDownLatch(6);///6-5-4-3-2-1


    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 3; i++) {
            new Thread(new Runner(500)).start();
        }

        while (START.getCount() > 3) {
            Thread.sleep(100);
        }

        Thread.sleep(1000);
        System.out.println("на старте ");
        START.countDown();

        Thread.sleep(1000);
        System.out.println("Внимание ");
        START.countDown();

        Thread.sleep(1000);
        System.out.println("Марш ");
        START.countDown();


    }






///--гонки машин, людей.. какжая машина - поток
    public static class Runner implements Runnable{
        long sleep;

    public Runner(long sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {

        try {

            System.out.println(" Бегун " + Thread.currentThread().getName()+ " на старте ");
            START.countDown(); ///уменьшает данные на 1
            START.await();///блокирует поток, пока значение счетчика не будет равна 0
            Thread.sleep(sleep);
            System.out.println(" Бегун " + Thread.currentThread().getName()+ " финишировал ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



}