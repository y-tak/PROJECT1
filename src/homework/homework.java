package homework;

public class homework {

    public static void main(String[] args) {
/////задача1
        System.out.println("Задача1");
        int a,b,c,d,s;

        a=8; //длина
        b=2;  //высота
        c=5;  //ширина
        //S=2*(a*b+b*c+a*c)
        s=2*(a*b+b*c+a*c);
        int max; //максимум
        System.out.println("Длина = "+a+"; Высота = "+b+"; Ширина = "+c);
        System.out.println("Площадь прямоугольного параллелепипеда = "+s);
        max=a;
        System.out.println((a>b) ? "Длина больше =  "+a:"Ширина больше ="+b );
        System.out.println("------------------------------------------------------");
////задача2
        System.out.println("Задача2");
        int s1=1000; //10 соток=1000 м^2
        int s2=15*25; //маленькие
        int s3=s1%s2;//осталось
        System.out.println("Осталось не занятым "+s3);
        System.out.println("------------------------------------------------------");
        ////задача3
        System.out.println("Задача3");
        int Sa=1500; //площадт овала 15дм^2 S=pi*a*b = 1500см^2
        int Sb= 600; //площадь овала 600см^2
        int k=Sa/Sb; /// кол малых овалов
        System.out.println("Вырезанная Площадь =  "+k*Sb +"см^2");
        System.out.println("------------------------------------------------------");
////задача4
        System.out.println("Задача4");
        double  m,n,raz1,raz2;
        m=8.5;
        n=11.45;
        raz1=Math.abs(n-10);
        raz2=Math.abs(m-10);
        System.out.println(" m = "+m +" n ="+n);
        System.out.println((raz1>raz2) ? " ближайшее к 10-->"+m: " ближайшее к 10--> "+n);
        System.out.println("------------------------------------------------------");
///задача5
        System.out.println("Задача5");
        double ak,bk,ck,x1,x2,D1;
        ak=1;
        bk=4;
        ck=4;
        D1=bk*bk-ak*ck*4;

        System.out.println("Решить уравнение "+ak+" x*x +"+bk+"x +"+ck+"=0");
        System.out.println("Дискриминант "+D1);


        System.out.println( (D1<0) ? "Решений нет " : " x1 ="+(-bk-Math.sqrt(D1))/2/ak+ " x2 ="+(-bk-Math.sqrt(D1))/2/ak);
        System.out.println("------------------------------------------------------");

        ///задача6
        System.out.println("Задача6");
        int g,g1,g2,g3;
        g=843;
        g1=g/100;
        g2=(g-g1*100)/10;
        g3=g-g1*100-g2*10;

        System.out.println("Число "+g+" =100* "+g1+"+10* "+g2+"+"+g3);
        System.out.println((g1>g2) ? ((g1>g3)? "максимум "+g1:"максимум "+g3):((g2>g3) ? "максимум "+g2 : "максимум "+g3));
        System.out.println("------------------------------------------------------");


    }

}
