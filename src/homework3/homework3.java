package homework3;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class homework3 {


    public static void main(String[] args) {

        System.out.println(" ----------------Задача 1----------------------");
        System.out.println(" массив четных чисел ");

        int[] arr= new int[10]; ///создали
        arr[0]=2;
        for (int i=1;i<arr.length;i++)
            arr[i]=arr[i-1]+2;


        for (int ch:arr) System.out.println(ch);

        System.out.println(" ");
        for (int ch:arr) System.out.print(" " +ch);
        System.out.println(" ");

        ///----------------------------------------------------------------------------------
        System.out.println(" ----------------Задача 2-----------------------------");
        System.out.println(" массив нечетных чисел ");

        int[] arr1= new int[50]; ///создали  100/2=50 чисел
        arr1[0]=1;
        for (int i=1;i<arr1.length;i++)
            arr1[i]=arr1[i-1]+2;
        System.out.println("прямой ");
        for (int ch:arr1) System.out.print(" "+ch);
        System.out.println(" ");
        System.out.println(" обратный ");
        for (int i=arr1.length;i>0;i--) System.out.print(" "+arr1[i-1]);
        System.out.println(" ");
        ///----------------------------------------------------------------------------------
        System.out.println(" ----------------Задача 3-----------------------------");
        System.out.println(" массив 15 случайных чисел , посчитать кол четных");

        Random rand=new Random();

        int[] arr2= new int[15]; ///создали  100/2=50 чисел
        int kol=0;
        for (int i=0;i<arr2.length;i++)
        {arr2[i]=rand.nextInt(10);
            if (arr2[i]%2==0) kol++;
        }
        System.out.println("массив случайных чисел "+Arrays.toString(arr2));
        System.out.println("четных  "+kol);

        ///----------------------------------------------------------------------------------
        System.out.println(" ----------------Задача 4-----------------------------");
        System.out.println(" массив случайных чисел [-5,5], сравнить суммы левой и правой части");

        boolean as=true;
        int chislo;
        Scanner inn=new Scanner(System.in);
        ///----цикл пока не введет нужное число---
        while (true)
        {   System.out.print("Введите четное число,размерность будущего массива: ");//integer
            chislo = inn.nextInt();///ввод числа
            if (chislo % 2 == 0) break;
        }
        inn.close();
        int[] arr3 = new int[chislo];
        int sumL,sumR;
        sumL=0;
        sumR=0;
        ///----метод рандом------------
        Random random=new Random();
        for (int i=0;i<arr3.length;i++)
        {
            int randomNumber=random.nextInt(10)-5;
            arr3[i]=randomNumber;
            if (arr3[i]<0) sumL=sumL+Math.abs(arr3[i]);
            else sumR=sumR+Math.abs(arr3[i]);

        }
        System.out.println("массив случайных чисел "+Arrays.toString(arr3));
        if (sumL>sumR) System.out.println("левая сумма чисел больше "+sumL);
        else if (sumL<sumR) System.out.println("правая сумма чисел больше "+sumR);
        else System.out.println("правая сумма  равна левой сумме "+sumR);






    }
}
