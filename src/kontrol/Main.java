package kontrol;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Hospital hospital=new Hospital();
        Scanner in=new Scanner(System.in);

        System.out.println("Добро пожаловать в поликлинику " );
        System.out.println("введите пароль" );
        String ff= in.next();
        hospital.open(ff);
    }


}
