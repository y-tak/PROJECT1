package lesson10.shop;

public class User {

   private String login;
    private String pwd;
    private double balance;
    private Cart cart;


    public void regCart(Cart cart)
    {
        this.cart=cart;
    }


    public User(String login, String pwd, double balance) {
        this.login = login;
        this.pwd = pwd;
        this.balance = balance;
    }

    public String getLogin() {


        return login;
    }

    public Cart getCart() {
        return cart;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getPwd() {
        return pwd;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (Double.compare(user.balance, balance) != 0) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return pwd != null ? pwd.equals(user.pwd) : user.pwd == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}
