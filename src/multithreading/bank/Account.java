package multithreading.bank;


//Account
//id
//user/money

//Bank
//transferMoney (Account src,Account dst,int money)

///Transaction.start();--осуществялет перевод

//class Transaction - класс поток


public class Account {

    private int id;
    private String user;
    private int money;

    public Account(int id, String user, int money) {
        this.id = id;
        this.user = user;
        this.money = money;
    }

    public int getId() {
        return id;
    }
}
