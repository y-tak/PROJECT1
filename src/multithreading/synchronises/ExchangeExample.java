package multithreading.synchronises;

import java.util.concurrent.Exchanger;

public class ExchangeExample {
    public static void main(String[] args) {



        Exchanger<String> stringExchanger=new Exchanger<>();

        MakeThread makeThread=new MakeThread(stringExchanger);
        makeThread.start();

        UseThread useThread=new UseThread(stringExchanger);
        useThread.start();
    }

}

class MakeThread extends Thread
{
    String string;
    Exchanger<String> exchanger;

    public MakeThread(Exchanger<String> exchanger)
        {
            this.exchanger=exchanger;
            string=new String();
        }



    @Override
    public void run() {

        for (int i=0;i<5;i++)
        {
            string="MakeThread создал строку "+i;
            try {
                string=exchanger.exchange(string);
                System.out.println("MakeThread получил строку " + string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
///----------------------------------------------
class UseThread extends Thread{

    String string;
    Exchanger<String> exchanger;

    public UseThread(Exchanger<String> exchanger) {

        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        for (int i=0;i<5;i++)
        {

            try {
                string=exchanger.exchange("Hello");
                System.out.println("UseThread получил строку " + string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}