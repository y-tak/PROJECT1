package lesson4;

import lesson4.Files.Document;
import lesson4.animals.Animals;
import lesson4.animals.Cats;
import lesson4.animals.Mouse;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Knight knight=new Knight(21,23);
        Archer archer=new Archer(32,17);

        knight.attack(archer);
        Scanner in=new Scanner(System.in);
        System.out.println("выбор персонажа knight или аrcher");
        String heroType=in.nextLine();

        BattelUnit unit;  //---указаать общий класс
        if (heroType.equals("knight"))
            unit=new Knight(23,54);
            else
            unit=new Archer(1,4);

        unit.attack(archer);

        Animals cat= new Cats();
        Animals mouse=new Mouse();
        ((Cats) cat).run();
        ((Cats) cat).eat(mouse);


        ///-----------------------про файлы------------
      // Document file1 =new Document("XML");
       //Document file2 =new Document("JSON");
      // file1.reader();
      // file2.reader();


    }

}


