package homework3;

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
        System.out.println("у вас получилось строка: " + output1);         //
        String a, b, output3;

        StringBuilder stringBuilder1=new StringBuilder();//объект StringBilder
       for (int i=0; i<output1.length();i++)
       {
        a = output1.substring(i, i + 1);
        output3=output1.substring(i);
        stringBuilder1.append(a);
        output1= output3;
        }
       // stringBuilder1.append(output3);
        System.out.println(" получили - "+stringBuilder1.toString());

    }



}
