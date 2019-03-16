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
        System.out.println(" Введите адрес ");
        adress=inn.nextLine();
        Dogs dogs=new Dogs(clichka);
        Dogs dogs1=new Dogs(clichka,ves,age);
        Dogs dogs2=new Dogs(clichka,age);
        Dogs dogs3=new Dogs(ves,color);
        Dogs dogs4=new Dogs(ves,color,adress);

        System.out.println("dogs1 = " + dogs1);
        System.out.println("dogs2 = " + dogs2);
        System.out.println("dogs3 = " + dogs3);
        System.out.println("dogs4 = " + dogs4);

    }


}
