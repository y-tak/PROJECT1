package multithreading.synchronize;

import java.util.ArrayList;

public class Counter {
    int counter=0;
 //---синхронизированный метод
    public  synchronized  void increment()
    {
        counter++;
    }



}



class IncrementThread extends Thread{
    Counter counter;

    public IncrementThread(Counter counter)
    {
        this.counter=counter;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            ///--------------- вариант1
//            synchronized (counter) {
//                counter.counter++;
//            }
        ///----------------------вариант2---
            counter.increment();

        }

    }
}
class Main
{
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
        ArrayList<IncrementThread> treads=new ArrayList<>();
        //создаем потоки
        for (int i=0;i<1000;i++)
        {
            treads.add(new IncrementThread(counter));
        }

        for (IncrementThread tr:treads
             ) {tr.start(); }
        for (IncrementThread tr:treads
        )
        {tr.join();}

        System.out.println("counter = " + counter.counter);
    }
}