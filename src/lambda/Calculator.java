package lambda;

public class Calculator {
    public double calculate (int a,int b, Operation operation)
    {
        return operation.execute(a,b);
    }

    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        Operation add=(a,b)->a+b;
        Operation minus=(a,b)->a-b;
        Operation supp=(int a,int b)->a*b;//добавляет int  у всех
        Operation div=(int a,int b)->
        { if (b==0) System.out.println(" деление на 0 " );return a/b; };


      //  ()-->System.out.println("hello");
     //   a->a+10;
      //  (a,b)->реализация
       // ()-> реализация
       // (a,b)-->{a+b;a-b;return}

        System.out.println("add = " + calculator.calculate(3,5,add));
        System.out.println("minus = " + calculator.calculate(3,5,minus));
        System.out.println("supp = " + calculator.calculate(3,5,supp));
        System.out.println("div = " + calculator.calculate(8,2,div));

    }

}
@FunctionalInterface
interface Operation
{
    double execute(int a,int b);
    ///функциональный интерфейс сожержит только абстрактный метод,
    //любое количество default и static методова
}