package homework16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Port
{

    public static void main(String[] args) {

        System.out.println("Все причалы открыты!");
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        fixedPool.execute(new Dock("Maria",1)); //корабль Мария на погрузку
        fixedPool.execute(new Dock("Anastasia",2));//корабль Aнастасия на разгрузку
        fixedPool.execute(new Dock("Vasya",3)); //корабль Мария на погрузку/разгрузку
        fixedPool.shutdown();

        //System.out.println("Все причалы закрыты ");
    }

}


///------погрзука-----------------
class Loading extends Thread
{
    String ship;
    public Loading(String ship)
    {
        this.ship=ship;
    }
    @Override
    public void run() {
        System.out.println("корабль на погрузке " + ship);
    }
}
///--------разгрузка-------------------------------------------
class UnLoading extends Thread
{
    String ship;

    public UnLoading(String ship)
    {
        this.ship=ship;
    }

    @Override
    public void run() {
          System.out.println("корабль на разгрузке " + ship);
  }
}
///--------------------------------------------------------------------
class Dock implements Runnable {
    String ship;
    int task;

    public Dock(String ship, int task) {
        this.ship = ship;
        this.task = task;
    }

    @Override
    public void run() {

        String itask="";
        if(task == 1) itask=" погрузки";
        else if(task == 2) itask=" разгрузки";
        else if(task == 3) itask="погрузки/ разгрузки";


        System.out.println("Причал {{" + Thread.currentThread().getName()+" }}, корабль " +ship+ " в ожидании "+itask);
        if (task == 1) {
            Loading loading = new Loading(ship);
            loading.start();
            try {
                loading.join();
                System.out.println("корабль "+ship+" отбыл ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if (task == 2) {

            UnLoading unLoading = new UnLoading(ship);
            unLoading.start();
            try {
                unLoading.join();
                System.out.println("корабль "+ship+" отбыл ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if (task == 3) {
            Loading loading = new Loading(ship);
            loading.start();
            UnLoading unLoading = new UnLoading(ship);
            unLoading.start();
            try {
                loading.join();
                unLoading.join();
                System.out.println("корабль "+ship+" отбыл ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}