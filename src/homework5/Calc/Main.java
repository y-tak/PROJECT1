package homework5.Calc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        System.out.println("Введит 1 число ");
        int str1 = Integer.parseInt(in.nextLine());
        System.out.println("Введит 2 число ");
        int str2 = Integer.parseInt(in.nextLine());
        System.out.println("Введит цифру операндф +,-,*,/");
        String str3=in.nextLine();

        if (str3.equals("+")) {
    Addition val = new Addition(str1, str2);
    val.excute();
}
else if (str3.equals("-"))
{
   Subtraction val= new Subtraction(str1, str2);
    val.excute();
}
else if (str3.equals("*"))
{
    Multiplication val= new Multiplication(str1, str2);
    val.excute();
}
else if (str3.equals("/"))
{
    Delete val= new Delete(str1, str2);
    val.excute();
}
else System.out.println("неправильно введен оператор"+str3 );

    }

}
