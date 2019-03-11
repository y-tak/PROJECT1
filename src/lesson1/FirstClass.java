package lesson1;

public class FirstClass {

    /*многострочный
            комментарий*/

    public static void main(String[] args) {
        ///комментарий
        System.out.println("Zarembo, hi!");

        //byte,long,short,int,float,double,char,boolean

       /* определение переменной
        типДанных ИмяПеременной=значение;*/
       boolean quest=true;
       boolean quest2;
       quest2=false;

/// ИмяПеременной=ИмяПеременной1=ИмяПеременно2;

        short a1,a2;
        int a3;
        a1=5; a2=38;
        a3=a1+a2;
        System.out.println("сложение "+a3);

       char a,b,c,d;
       a='K';
       b='A';
       c='T';
       d='E';
       System.out.println( "hello "+a+""+b+""+c+""+d);


       int aa=1_000;
       int ab=8,ac=3;
       int res = aa/ab/ac;
       System.out.println("при делении остаток отбрасывается "+res);
       /// чтобы число воспринималось как лонг ставиться L
       long LOngVar=20000000L;

       double ds=ab/ac;
       double s=7.1;
       float  ss=6.9876F;

       ///пример автоматического преобразования s/ac -->  int в double
        System.out.println("при делении  "+ss/s+"-->"+s/ac);

        ///можно
        int vj=200;
        long vi=vj;

        ///---приведение к типу
        double n=90.9887;
        int m=(int) n;
        System.out.println(" m =   "+m+"  n ="+n);

        ///опреаторы
        //+-/ * %
        //инкремент
        int i=9;
       ///увеличивает на 1,постфиксную
        i++;//10  i=i+1;
        System.out.println("i "+i);
        ++i;  //11   i=i+1;
        System.out.println("i "+ i);
        /////декремент
        ///уменьшает на 1
        i--;//10   i=i-1;
        --i;  ///9  i=i-1;
        System.out.println("i "+ i);
          /////операторы сравнение
        //< > == >= <= !=

        ///логические условия
        //&&   и
        //(a && b)
         //(a & b)
        //  ||   или
        //(a || b)
        //if (!)  не

        ///операторы присваивания
        //= += -= *= /= %=

        aa+=5; //aa=aa+5;
        System.out.println("aa+5 "+ aa);

        //тернарный оператор
        //переменная a=(условие) ? выражение1: выражение2
       /// если условие истина то a=выражение1, если ложь тогда a= выражение2

        int d3=33;
        int t=9;
        int s2=(d3<t) ? t/d3:d3+t;
        System.out.println("s2 "+ s2);
        

    }
}
