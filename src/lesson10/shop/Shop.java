package lesson10.shop;

import java.util.HashMap;

public class Shop
{
    static HashMap<String,User> users=new HashMap<>();
    static HashMap<String,Good> goods=new HashMap<>();

    public boolean sale(User user)
    {
       Double summa=user.getCart().getSumm();
        System.out.println("Сумма покупки " + summa);
        System.out.println("Ваш балланс " + user.getBalance());
       if (summa<user.getBalance())
       {
          user.setBalance(user.getBalance()-summa);
          return true;
       }
        return false;
    }


    public static void main(String[] args) {

        Shop shop=new Shop();

        User user1=new User("qwe","111",4000);
        User user2=new User("asd","222",5000);
        User user3=new User("zxc","333",2000);
        User user4=new User("rty","444",7000);

        Good cacao=new Good("Cacao",2,200);
        Good tea=new Good("Tea",1,60);
        Good cofe=new Good("Cofe",5,250);
        Good vodka=new Good("Vodka",1,170);

        users.put(user1.getLogin(),user1);
        users.put(user2.getLogin(),user2);
        users.put(user3.getLogin(),user3);
        users.put(user4.getLogin(),user4);

        goods.put(cacao.getTitle(),cacao);
        goods.put(tea.getTitle(),tea);
        goods.put(cofe.getTitle(),cofe);
        goods.put(vodka.getTitle(),vodka);

        Cart cart=new Cart();
        cart.addGood(cacao);
        cart.addGood(vodka);
        cart.addGood(cofe);

        user1.regCart(cart);

        if (shop.sale(user1)==true)
        {
            System.out.println("УСПЕХ!");
        }
        else System.out.println("НЕ ОПЛАЧЕНО!");

        System.out.println("осталось "+user1.getBalance());









    }
}
