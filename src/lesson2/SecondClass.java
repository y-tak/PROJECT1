package lesson2;

import java.util.Locale;
import java.util.Scanner;

public class SecondClass {
    public static void main(String[] args) {

System.out.println("Вывод инф-ии");
        Scanner in=new Scanner(System.in);
        in.useLocale(Locale.US);///для точки и запятой

        System.out.println("Введите число");//integer
        int code=in.nextInt();///ввод числа

        System.out.println("Введите дробное число");//integer
        double code2=in.nextDouble();
        System.out.println("code2 ="+code2);
       // System.out.println("code"+code);//integer
  if (code==6 || code<6) {System.out.println("код равен 6");}
  else  if (code>6) {System.out.println("больше 6");}
  else {System.out.println("код меньше 6");}

  System.out.println("---------------------- ");
//----
        int a,b;
  a=4;b=7;
   if (a==4){System.out.println("a=4");
   if (b==7){System.out.println("b=7");}
   }
        else if (b==7){System.out.println("b=7");}
        System.out.println("---------------------- ");

    ///----------------------------
      Scanner inlot= new Scanner(System.in);
        System.out.println("Ввести число");
        int num=inlot.nextInt();
        String allo;
        ////конструкция свитч
        switch (num)
        {
            case 3333:
               allo="Приз";
                 break;
                 ///--3334 и 3335 одинаково--> "не большой приз"
            case 3334:
            case 3335:
                allo="не большой Приз";
                break;
                default:
                    allo="нет приза";
        }

        System.out.println("РеЗультат - " +allo);
        System.out.println("---------------------- ");
        //////////-------------------------------------------------------------
        ///циклы
        int count =5;
        //---5 раз пока условие истина [5..1]
        while (count>0)
        {
            System.out.println(" WHILE_count " +count);
            count--;
        }
        System.out.println("---------------------- ");
        ///------------после выполнения проверка условия
        do
        {
            System.out.println(" DO_WHILE первый шаг  " +count);
            count--;
        }  while (count>0);

        System.out.println("---------------------- ");
        ///-------------------------------------------
        for (int mcount = 1; mcount<6; mcount++)
        {System.out.println(" FOR шаг " +mcount);        }
        System.out.println("---------------------- ");

        ///-------------------------------------------
        for (int mcount = 1; mcount<6; mcount++)
        { if (mcount%2==0 ) continue;
        System.out.println(" FOR  с continue шаг нечетные " +mcount);  }


        System.out.println("---------------------- ");

        for (int mcount = 1; mcount<6; mcount++)
        {  for (int j = 1; j<5; j++)

        { System.out.println(" FOR  строка= " +mcount+ " колонка="+j);
            if (j==4 )
            break;}

        }

        System.out.println("---------------------- ");
        /////outer:for (int mcount = 0; mcount<6; mcount++)  //---цикла с метками один раз//
       for (int mcount = 0; mcount<6; mcount++)
           outer:{ System.out.println(" FOR  внешний"+mcount);
         for (int j = 0; j<5; j++)
        { System.out.println("j"+j);
            if (j==4 )
                break outer;}
        }



    }

}
