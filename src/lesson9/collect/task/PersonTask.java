package lesson9.collect.task;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;



// написать генератор списка объектов класса Person
// Сортировать объекты Person по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании


    public class PersonTask {


        //-------------------------
        public static void main(String[] args) {



            TreeSet<Person> personTask = new TreeSet<>(new PersonSort());//имя

            ////------------сравнение
            Comparator<Person> personComparator1 = new PersonSortName()  ///имя и зарплата
                    .thenComparing(new PersonSortSalary());
            ///дерево
            TreeSet<Person>  personTask1 = new TreeSet<>(personComparator1);//имя
            //сравнение
            Comparator<Person> personComparator2 = new PersonSortName()  //имя зарплата возрватс и компания
                    .thenComparing(new PersonSortSalary().thenComparing(new PersonSortAge().thenComparing(new PersonSortCompany())));
            ///дерево
            TreeSet<Person>  personTask2 = new TreeSet<>(personComparator2);//имя


            Random random = new Random();
            char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            int val=3;
            ///////////-------------------------------------------------------
                     System.out.println("Первое заполнение");

                    GeneratePerson persong=new GeneratePerson(personTask);
                     persong.gererate(2);

                      GeneratePerson persong1=new GeneratePerson(personTask1);
                      persong1.gererate(3);

                      GeneratePerson persong2=new GeneratePerson(personTask2);
                      persong2.gererate(4);

            System.out.println("Сортировка по имя");
            for (Person person :  personTask) {
                System.out.println(person);
            }
            System.out.println("Сортировка по имя и ЗП ");
            for (Person person :  personTask1) {
                System.out.println(person);
            }
            System.out.println("Сортировка по имя и ЗП и возраст и компания ");
            for (Person person :  personTask2) {
                System.out.println(person);
            }

        }
    }
////-------------------------------------------------------------------------------------

    class Person
    {
        String name;
        int age;
        int salary;
        String company;


        public Person(String name, int age, int salary, String company)
        {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.company = company;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            if (salary != person.salary) return false;
            if (name != null ? !name.equals(person.name) : person.name != null) return false;
            return company != null ? company.equals(person.company) : person.company == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            result = 31 * result + salary;
            result = 31 * result + (company != null ? company.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", company='" + company + '\'' +
                    '}';
        }
    }


    ///---------------------------------------------------
    class  PersonSort implements Comparator<Person>
    {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }


    class PersonSortName implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    class PersonSortSalary implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.getSalary(), o2.getSalary());
        }
    }

    class PersonSortAge implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
    class PersonSortCompany implements Comparator<Person>
    {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getCompany().compareTo(o2.getCompany());
        }
    }


///------------------класс для генерации--------------------

class GeneratePerson {
    private TreeSet<Person> personTask;


    public void gererate(int val) {


        for (int i = 0; i < val; i++)
        {
            //  StringBuilder sb = new StringBuilder(10);
            //  StringBuilder sd = new StringBuilder(20);
//        for (int j = 0; j < 10; j++) {
//            char c = chars[random.nextInt(chars.length)];
//            sb.append(c);
//        }
//
//        for (int j = 0; j < 20; j++) {
//            char d = chars[random.nextInt(chars.length)];
//            sd.append(d);
//        }

            int age = (int) (Math.random() * 100);
            int salary = (int) (Math.random() * 100000);
            //String name = sb.toString();
            ///  String company = sb.toString();
            String name = "Alex";
            String company = "QWE";

            Person peopl = new Person(name, age, salary, company);
            personTask.add(peopl);
            //System.out.println(peopl);
        }





    }

    public TreeSet<Person> getPersonTask() {
        return personTask;
    }

    public GeneratePerson(TreeSet<Person> personTask) {
        this.personTask = personTask;
    }
}
////-----------------------------------------------------------
