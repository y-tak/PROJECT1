package multithreading;

public class ThreadLock
{

    public static void main(String[] args) {
        Object obj=new Object();
        Object obj2=new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 START");
                synchronized (obj) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("thread1 obj block ");
                    synchronized (obj2) {
                        System.out.println("thread1 obj2 block ");
                    }
                }

            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 START");
                synchronized (obj2) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("thread1 obj2 block ");
                    synchronized (obj) {
                        System.out.println("thread1 obj block ");
                    }
                }


            }
        });
thread.start();
thread2.start();

    }
}
