package homework4;

import java.util.Scanner;

public class homework4 {

    public static void main(String[] args) {


        System.out.println(" --------------Задача 1------------------------------ ");
        System.out.println(" однонаправленный связный список для хранения данных int ");

            Node node = new Node(10);
            System.out.println("создали запись на 10 записей| " + node);
       ///добавляет запись
        node.addNode(11,node);
        System.out.println("добавили в конец 11 запись| " + node);
        ///удаляет запись
        node.removeNode(11,node);
        System.out.println("удалили с конца 11 запись| " + node);


        System.out.println(" --------------Задача 2------------------------------ ");
        System.out.println(" фигуры ");

         Figure circle=new Figure(4,3,2,3);
         Figure rectangle=new Figure(5,1,5,5,2,5,2,1);
         Figure triangle=new Figure(5,3,2,1,2,5);

        System.out.println(" фигуры1: "+circle+" площадь "+circle.ploshad()+" периметр "+circle.perimetr());
        System.out.println(" фигуры2: "+rectangle+" площадь "+rectangle.ploshad()+" периметр "+rectangle.perimetr());
        System.out.println(" фигуры3: "+triangle+" площадь "+triangle.ploshad()+" периметр "+triangle.perimetr());

        System.out.println(" --------------Задача 3------------------------------ ");
        System.out.println(" собаки ");
        String clichka, color,adress;
        double ves=0;
        int age=0;


        Scanner inn=new Scanner(System.in);
        System.out.println(" Введите кличку ");
        clichka=inn.nextLine();
        System.out.println(" Введите вес ");
        ves=inn.nextDouble();
        System.out.println(" Введите возраст ");
        age=inn.nextInt();
        System.out.println(" Введите цвет ");
        color=inn.nextLine();
        System.out.println(" ");
        adress="плоавло";
        Dogs dogs1=new Dogs();

        if (ves!=0 &&color!=null) {
          dogs1=new Dogs(ves,color);
        } else if (ves!=0&&color!=null&adress!=null)
        {dogs1=new Dogs(ves,color,adress);}
        else if (clichka!=null&&age!=0)
        {  dogs1=new Dogs(clichka,age);}
        else if (clichka!=null&&age!=0&&ves!=0)
        {   dogs1=new Dogs(clichka,ves,age);}
        else
        { dogs1=new Dogs(clichka);}


        //Dogs dogs=new Dogs(clichka);
        //Dogs dogs1=new Dogs(clichka,ves,age);
        //Dogs dogs2=new Dogs(clichka,age);
        //Dogs dogs3=new Dogs(ves,color);
        //Dogs dogs4=new Dogs(ves,color,adress);

        System.out.println("dogs1 = " + dogs1);
       // System.out.println("dogs2 = " + dogs2);
        //System.out.println("dogs3 = " + dogs3);
        //System.out.println("dogs4 = " + dogs4);

        System.out.println(" --------------Задача 4------------------------------ ");
        System.out.println(" битва котиков");
        int age1,age2,age11,age21;
        int power1,power2;
        int ves1,ves2;

        System.out.println(" Введите вес 1 котика");
        ves1=inn.nextInt();
        System.out.println(" Введите силу 1 котика");
        power1=inn.nextInt();
        System.out.println(" Введите возраст 1 котика");
        age1=inn.nextInt();


        System.out.println(" Введите вес 2 котика");
        ves2=inn.nextInt();
        System.out.println(" Введите силу 2 котика");
        power2=inn.nextInt();
        System.out.println(" Введите возраст 2 котика");
        age2=inn.nextInt();

        Cats cat1=new Cats(age1,power1,ves1);
        Cats cat2=new Cats(age2,power2,ves2);
        System.out.println("cat1 = " + cat1);
        System.out.println("cat2 = " + cat2);

        if(cat1.fight(cat2)==true) System.out.println("победил 1 котик ");
        else System.out.println("победил 2 котик ");


    }


}
