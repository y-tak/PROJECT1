package multithreading.bank;

public class Transaction implements Runnable {
    private Account scr;
    private Account dst;
    private int money;

    public Transaction(Account scr, Account dst, int money) {
        this.scr = scr;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {

        if (scr.getId() < (dst.getId())) {
            synchronized (scr) {
                System.out.println("блокинрую" + scr);
                synchronized (dst) {
                    System.out.println("блокинрую" + dst);
                }
            }
        }
        else
            {
                synchronized (dst) {
                    System.out.println("блокинрую" + dst);
                    synchronized (scr) {
                        System.out.println("блокинрую" + scr);
                    }
                }

            }


    }
}

