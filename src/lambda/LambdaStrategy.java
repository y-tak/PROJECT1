package lambda;



import java.util.concurrent.ConcurrentSkipListMap;

public class LambdaStrategy {
          public static void main(String[] args) {

              Order order = new Order(700);

               // order.payOrder(PayActions.CARD);
              // order.payOrder(PayActions.PAYPAL);
              // order.payOrder("payPal");

        }
    }





    class StrategyRegister<T> {
        private ConcurrentSkipListMap<PayActions, T> map = new ConcurrentSkipListMap<>();

        public void add(PayActions actionName, T action) {
            map.put(actionName, action);
        }

        public T get(PayActions actionName) {
            return this.map.get(actionName);
        }

        public void remove(PayActions actionName){
            this.map.remove(actionName);
        }
    }
    ///----------------------

    class Order {
        private StrategyRegister<Runnable> strPayActions = new StrategyRegister<>();

        private int sum;


        public Order( int sum) {
            this.sum = sum;
            for (PayActions p:PayActions.values())
            {
                p.addStrateg(strPayActions,p,sum);
                strPayActions.get(p).run();
            }

//
         // PayActions card = PayActions.CARD;
//            card.addStrateg(strPayActions,PayActions.CARD,sum);
//
          // PayActions payPal = PayActions.PAYPAL;
//            payPal.addStrateg(strPayActions,PayActions.PAYPAL,sum);

            //payActions.add("card", ()-> System.out.println(Thread.currentThread().getName() + " card: " + sum));
          //  payActions.add("payPal", ()-> System.out.println(Thread.currentThread().getName() + " payPal: " + sum));
        }

//        public void payOrder(PayActions payName) {
//            strPayActions.get(payName).run();
//        }
    }


    ///------------домашка-------------------


    enum PayActions{
       //CARD,PAYPAL;
      CARD("card"),
      PAYPAL("paypal");

      private  String payAction;

       PayActions(String payAction)
       {
            this.payAction=payAction;
       }

        public String getPayAction() {
            return payAction;
        }

        public void addStrateg(StrategyRegister<Runnable> payActions, PayActions payAction, int sum){

            if (payAction.equals(PayActions.CARD))
            {  payActions.add(PayActions.CARD,()-> System.out.println(Thread.currentThread().getName() +":"+ PayActions.CARD+" - "+ sum));}
            else if (payAction.equals(PayActions.PAYPAL))
            {  payActions.add(PayActions.PAYPAL,()-> System.out.println(Thread.currentThread().getName() + ":"+ PayActions.PAYPAL+" -  " + sum)); }

        }

// все стратегии
    }