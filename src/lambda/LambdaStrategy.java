package lambda;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.concurrent.ConcurrentSkipListMap;

public class LambdaStrategy {
    public static void main(String[] args) {
        Order order =new Order(70);
        order.payOrder("card");
        order.payOrder("some");
    }


}

///------класс для хранения стратегий
class StrategyRefister<T>
{
    public ConcurrentSkipListMap<String,T> map=new ConcurrentSkipListMap<>();

    public  void  add(String actionName,T action)
    {
        map.put(actionName,action);

    }

    public  T get(String actionName)
    {
        return this.map.get(actionName);
    }

    public void remove(String actionName)
    {
        this.map.remove(actionName);
    }


}

//---------
class Order {
    private StrategyRefister<Runnable> payAction = new StrategyRefister<>();

    private int sum;

    public Order(int sum) {
        this.sum = sum;
        payAction.add("card", () -> System.out.println(Thread.currentThread().getName()+"Оплата по карте " + sum));
        payAction.add("payPal", () -> System.out.println("Оплата payPal " + sum));
    }


    public void payOrder(String payName) {
        payAction.get(payName).run();
    }
}

//TOdo реализовать enum lkz rf;ljuj cnhfntubb

enum PayAction
{//все стратегии конструктор
    //у разных заказов дразные стратегии card,payPal
    }