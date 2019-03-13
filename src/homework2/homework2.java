package homework2;

import java.util.Scanner;

public class homework2 {
    public static void main(String[] args) {
        System.out.println("---------------------Задача1-------------------------");
        int a, b, c;
      //  a = 2;
     //   b = -1;
     //   c = 4;
        a = -99;
        b = 76;
        c = 134;
       System.out.println("Есть три натуральных попарно не одинаковых числа: a= "+a + "; b=" + b + "; c=" + c);
        if ((a < b) && (b < c)) System.out.println("по возрастанию "+ a + " " + b + " " + c); //a<b<c
        else if ((a < b) && (b > c) && (a < c)) System.out.println("по возрастанию "+a + " " + c + " " + b); //a<c<b
        else if ((a < b) && (b > c) && (a > c)) System.out.println("по возрастанию "+c + " " + a + " " + b); //c<a<b
        else if ((a > b) && (b > c)) System.out.println("по возрастанию "+c + " " + b + " " + a); //c<b<a
        else if ((a > b) && (b < c) && (a > c)) System.out.println("по возрастанию "+b + " " + c + " " + a); //b<c<a
        else if ((a > b) && (b < c) && (a < c)) System.out.println("по возрастанию "+b + " " + a + " " + c); //b<a<c
        else System.out.println("не предусмотрен, возможно когда они попано равны"); //

///////////-----------------------------------------------------------------------------------------------------------------------
        System.out.println("---------------------Задача2-------------------------");
        System.out.println(" все неотрицательные элементы последовательности");
        int nach;
        nach= 90;

        while (nach>0)
        {System.out.print(nach+" ");
            nach=nach-5;
        };
        System.out.println(" ");
 ///------------------------------------------------------------------------------
        System.out.println("---------------------Задача3-------------------------");
        System.out.println(" вывод на экран первых 20-членов геометрической послдеоватлеьно a[0]=1, q=2,a[n]=(a[n-1])*q ");
        int aa=1;
      //  System.out.print(aa+" ");
        int q=2;
        for (int i=0; i<20 ; i++)
        {
            aa=aa*q;
            System.out.print(aa+" ");
        };
        System.out.println(" ");
        ///------------------------------------------------------------------------------
        System.out.println("---------------------Задача4-------------------------");
        System.out.println(" проверить является ли натуральное число простым, т.е. остаток от деления никогда не равен 0 при делении на любое другое натуральное число");
        Scanner chislo=new Scanner(System.in);

        System.out.print("Введите число: ");//integer
        int prostoe=chislo.nextInt();///ввод числа
        int uu=1;
        for (int i=2; i<prostoe;i++ )
        if (prostoe%i == 0)
        {System.out.println(" Число составное, есть делитель "+i);

        break;
         }
         else uu=uu+1;
         if (uu==prostoe-1) System.out.println(" Число простое, нет делителей");

///----------------------------------------------------------------------------------------------------------
        System.out.println("---------------------Задача5-------------------------");
        System.out.println(" Вывести первые 11 членов последовательности Фиббоначи ");
        int a1,a2,a3;
        a1=1;a2=1;
        System.out.print(a1+" ;"+a2+" ;");
        for (int i=2 ;i<11; i++)
        {
              a3=a1+a2;
              System.out.print(a3+" ;");
              a1=a2;
              a2=a3;

        }
        System.out.println("");
///---------------------------------------------------------------------------------------------------------
        System.out.println("---------------------Задача6-------------------------");
        System.out.println(" Число счатсливых билетов в трамвае 000001..999999 ");

        int s,s1,s2,s3,s4,s5,s6;
        int scet=0;

        for (int i=999999;i>0;i--)
        {
            s=i;
            s1=s/100000;
            s2=(s-s1*100000)/10000;
            s3=(s-s1*100000-s2*10000)/1000;
            s4=(s-s1*100000-s2*10000-s3*1000)/100;
            s5=(s-s1*100000-s2*10000-s3*1000-s4*100)/10;
            s6=(s-s1*100000-s2*10000-s3*1000-s4*100-s5*10);

            //  System.out.println(" "+s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" ");
  if ((s1+s2+s3)==(s4+s5+s6))
  {      scet = scet + 1;
      ////System.out.println("билет  "+s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" ");
  }
        }
        System.out.println("всего подарков "+scet);

    ///---------------------------------------------------------------------------------------------------------
        System.out.println("---------------------Задача7-------------------------");
        System.out.println(" симметричная комбинация на часах 00:00 23:59");

        int t1,t2,t3,t4;
        for (int i=0;i<24;i++)
            for (int j=0;j<60;j++)
        {t1=i/10;
        t2=i-t1*10;
        t3=j/10;
        t4=j-t3*10;
          //  System.out.println(i+":"+j+" t1 "+t1+" t2 "+t2+" t3 "+t3+" t4 "+t4);
if ((t1==t4)&&(t2==t3)&&(t1!=t3)&&(t2!=t4))
    System.out.println(i+":"+j);
else if ((t1==t2)&&(t2==t3)&&(t3==t4))
    System.out.println(i+":"+j);
else
    continue;
        }



    }
}