package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BinaryOperator;

public class ComporatorExample {
    public static void main(String[] args) {
        Manager alex=new Manager("Alex",25,"BBC");
        Manager max=new Manager("Max",27,"ABC");
        Manager peter=new Manager("Peter",31,"FIK");
        Manager tom=new Manager("Tom",34,"JHG");

        ArrayList <Manager> managers=new ArrayList<>();
        managers.add(peter);
        managers.add(alex);
        managers.add(max);
        managers.add(tom);



     //   Comparator<Manager> comparatorNamy=
     //           (manager1,manager2)->manager1.getName().compareTo(manager2.getName());
        Comparator<Manager> byName=Comparator.comparing(Manager::getName);
        managers.sort(byName);
        System.out.println("managers Name = " + managers);

        Comparator<Manager> byAge=Comparator.comparing(Manager::getAge);
        managers.sort(byAge);
        System.out.println("managers  Age= " + managers);





    }



}


class Manager
{ private String name;
private int age;
private String company;

    public Manager(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }
}