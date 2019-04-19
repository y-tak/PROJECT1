package multithreading.synchronize;

public class Client {


    // Пиццерия
    // Клиент (main), официант, повар
//        Каждый из потоков послевыполнения операции засыпает.
//        официант и повар спят, пока не появится клиент
//        Клиент оставляет заказ, будит официанта, официант передает заказ
//        повару и будит его
//        Повар готовит заказ и возвращает блюдо.
//        Повар будит официанта, передает ему блюдо,
//        официант передает блюдо клиенту


    public static void main(String[] args) {

        Client client = new Client();

        client.start("meet");


    }

    void start(String order) {
        Officiant officiant = new Officiant(order);
        Cook cook = new Cook(order);

       /// new Thread(officiant).start();
        System.out.println("пришел клиент");
        synchronized (officiant) {
            new Thread(cook).start();
            Thread.currentThread().interrupt();
        }
        synchronized (cook) {
            new Thread(officiant).start();
            Thread.currentThread().interrupt();
        }


    }
}

 class Officiant implements Runnable {

        String order;//блюдо
        public Officiant(String order) {
            this.order = order;
 }

        @Override
        public void run() {
            while (true) {
                putCook();

            }
        }


        void putCook() {
            System.out.println("официант забрал  от повара и отнес клиенту " + order);
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//---------------------------------------------------
 class Cook implements Runnable {
        String order;//блюдо


        public Cook(String order) {
            this.order = order;
        }


        @Override
        public void run() {
            while (true) {
                 cook();
            }
        }

        void cook() {
            System.out.println("повар приготовил " + order);
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }




