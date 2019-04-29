package lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        ///встроенные функциональные интерфейсы
        ///Интерфейс Predicate
        //метод: boolean test(T t)
        //default методы:
        //and(Pridicate_other);
        //or (Pridicate_other);
        //nagative();
        Predicate<Integer> poz=(num)->num>0;
        Predicate<Integer> neg=(num)->num<0;
        Predicate<Integer> four=(num)->num==4;

        System.out.println("poz = " + poz.test(5)); //true
        System.out.println("neg = " +neg.test(5)); //false
        System.out.println("four = " +four.test(4)); //true

        System.out.println(poz.and(four).test(4));//true  И
        System.out.println(poz.or(four).test(5));//true  ИЛИ
        
        
        ///Интерфейс Function<T,R> принимает значение в качестве аргумента одного типа (T)
        ///и возвращает другого типо (R)
        //методы: R  apply(T t)
        //default методы:
        //andThen(Function after);
        //compose (Function before);
        
        Function<Integer,String> convert=a->a+"$";
        System.out.println("convert.apply(6) = " + convert.apply(6));


        Function<Integer,Double> tenPercent=b->b*0.1;
        System.out.println("tenPercent.apply(4) = " + tenPercent.apply(4));

        Function<Integer,Integer> add10=a->a+10;
        Function<Integer,Integer> add5=a->a+5;
        System.out.println("add5.andThen(add10).apply(4) = " + add5.andThen(add10).apply(4));

        Function<Integer,Integer> add2=b->b*2;
        Function<Integer,Integer> add22=b->b*b;
        System.out.println("add2.andThen(add22).apply(5) = " + add2.andThen(add22).apply(5));//100 --> 5*2*5*2
        System.out.println("add2.compose(add22).apply(5) = " + add2.compose(add22).apply(5));//50 <--5*5*2


        //задача
        //дан предикат(Predicate) condition и две функции(Function) ifTrue  и isFalse
        //написать метод который вернет новую функцию (Function)
        //возвращающую значение функции  ifTrue, если condition ==true  и  если не выполнено тогда isFalse

        ///Todo: переделать на  дженерик вместо <Integer>



        Predicate<Integer> condition=num->num>0;
        Function<Integer,Integer> ifTrue=a->a+10;
        Function<Integer,Integer> ifFalse=a->a-10;

        Function<Integer,Integer> func=getFunction(condition,ifTrue,ifFalse);

        System.out.println("func.apply(34) = " + func.apply(34));
        System.out.println("func.apply(-34) = " + func.apply(-34));

        ////Интерфейс Consumer<T> принимает значение и ничего не возвращает
        ///метод void accept(T t);
        //default метод andThen(Consumer <T> after)


///Todo: посмотреть списки функциональных интерфейсов
        ///BinaryOperator<T> | UnaryOperator<T>
////------------------------------------------------------------------
        ////---------------------домашняя---------------------------------

        SomeClass kate=new SomeClass("Kate");
        SomeClass lena=new SomeClass("Lena");

        Predicate<String> condition1=a->a.equals("Kate");
        Function<SomeClass,String> ifSomeClassT=a-> a.getName()+" "+10;
        Function<SomeClass,String> ifSomeClassF=a-> a.getName()+" "+100;
        Function<SomeClass,String> func1=getFunctionSC(condition1,ifSomeClassT,ifSomeClassF);

        System.out.println("func1 = " + func1.apply(kate));
        System.out.println("func1 = " + func1.apply(lena));

    }

    public static Function<Integer,Integer> getFunction
            (     Predicate<Integer> condition,
                    Function<Integer,Integer> ifTrue,
                    Function<Integer,Integer> ifFalse) {

        return a->condition.test(a)?ifTrue.apply(a):ifFalse.apply(a);
    }



    public static Function<SomeClass,String> getFunctionSC
            (     Predicate<String> condition1,
                  Function<SomeClass,String> ifSomeClassT,
                  Function<SomeClass,String> ifSomeClassF) {

        return
                a->condition1.test(a.getName())?ifSomeClassT.apply(a):ifSomeClassF.apply(a);
    }


    
}

class SomeClass
{
    String name;

    public SomeClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
