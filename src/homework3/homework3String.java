package homework3;

import java.util.Arrays;
import java.util.Scanner;

public class homework3String {

    public static void main(String[] args) {

        System.out.println(" ----------------Задача 1-----------------------------");
        System.out.println("  Найти в строке указанную подстроку и заменить ее на новую");

        System.out.println("Введите строку");//integer
        Scanner inn = new Scanner(System.in);
        String str = inn.nextLine();///ввод строки                  //мамочка
        // System.out.println(str);//
        System.out.println("Введите подстроку поиска");//integer ///мамо
        String str1 = inn.nextLine();///ввод строки
        System.out.println("Введите новую подстроку замены ");//integer //папо
        String str2 = inn.nextLine();///ввод строки

        String output = str.replace(str1, str2);
        System.out.println("у вас получилось строка: " + output);         //  папочка


        System.out.println(" ----------------Задача 2-----------------------------");
        System.out.println("  убрать из строки повторяющиеся  и пробелы");
        System.out.println("Введите строку  ");//// "abc cde def"
        String str3 = inn.nextLine();///ввод строки
        String output1 = str3.replace(" ", "");
     //   System.out.println("у вас получилось строка: " + output1);         //

        String a, b, output3;

        StringBuilder stringBuilder1=new StringBuilder();//объект StringBilder
        char[] str4 = output1.toCharArray();

       // System.out.println("массив букв "+Arrays.toString(str4));
        int pos=1;
        for (int i=1; i<str4.length;i++)        {
            int j;
            for (j = 0; j < pos; j++)
            {
                if (str4[i] == str4[j])
                break;
            }

            if (j == pos)
                {
                    str4[pos] = str4[i];
                    pos++;
                }
                else
                    {
                    str4[pos] = 0;
                    pos++; }
            }


      for (char str5:str4)
            {
                if (str5!=0) stringBuilder1.append(str5);
           };
        // stringBuilder1.append(output3);
       System.out.println("получили - "+stringBuilder1.toString());


        System.out.println(" ----------------Задача 3-----------------------------");
        System.out.println("  Вводится строка, содержащая буквы, целые неотрицательные числа и иные символы. ");
        System.out.println("Введите строку  ");//// "дом 48, корпус 9, парадная 7, этаж 4"
        String adres = inn.nextLine();///ввод строки
        char[] str5 = adres.toCharArray();
        int[] numera= new int[adres.length()];;
        StringBuilder doc=new StringBuilder();


           char a2,b2;

           int kol=0;
           boolean pr=false;

        for (int i=0; i<str5.length;i++)
        {
            a2 = str5[i];
            if (a2 == '0' || a2 == '1' || a2 == '2' || a2 == '3' || a2 == '4' ||
                    a2 == '5' || a2 == '6' || a2 == '7' || a2 == '8' || a2 == '9')
           {
                doc.append(a2);
                pr=true;
                  }
            else if (pr==false)  continue;
            else
            {
                int a1 = Integer.parseInt(doc.toString());
                numera[kol] = a1;
                kol=kol+1;
                doc=new StringBuilder();
                pr=false;
            }

        }
////для послденего элемента
        if (pr==true) {
            int a1 = Integer.parseInt(doc.toString());
            numera[kol] = a1;
        }

         System.out.println("массив цифр- "+Arrays.toString(numera));

    }



}
