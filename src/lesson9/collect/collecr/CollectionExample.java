package lesson9.collect.collecr;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CollectionExample {

    public static void main(String[] args) throws IOException {

        System.out.println("---------ArrayList----------");
        ArrayList<Book> bookArrayList = new ArrayList<>();

        bookArrayList.add(new Book("tutut"));
        bookArrayList.add(new Book("hhh"));
        bookArrayList.add(new Book("tutut"));
        System.out.println(bookArrayList.size());
        //--вывод
        for (Book b : bookArrayList
        ) {
            System.out.println(b.getTitle());

        }
        System.out.println("---------SET----------");
        Set<Book> bookSet = new HashSet(bookArrayList);//для уникальных хранилиц без дублей
        //---вывод
        for (Book b : bookArrayList
        ) {
            System.out.println(b.getTitle());

        }


        System.out.println("---------LinkedList----------");
        LinkedList<Book> bookLinkedList = new LinkedList<>();
        bookArrayList.add(new Book("Book 1"));
        bookArrayList.add(new Book("Book 2"));
        bookArrayList.add(new Book("Book 3"));

        for (Book b : bookArrayList
        ) {
            System.out.println("" + b.getTitle());

        }

        System.out.println("---------TREE set----------");

        TreeSet<String> strings = new TreeSet<>();
        strings.add("kjl");
        strings.add("yt");

        for (String str : strings) {
            System.out.println(str);
        }


        System.out.println("---------TREE set c Comporatorom----------");
////-------------коллеция для сортировки и фильтрования---------
        TreeSet<Book> books = new TreeSet<>();
        books.add(new Book("fxdfkjgh"));
        books.add(new Book("jjj"));

        User user1 = new User("zzz", 2);
        User user2 = new User("hhh", 3);

        TreeSet<User> users = new TreeSet<>(new UserComparator());
        users.add(user1);
        users.add(user2);

        for (User u : users) {
            System.out.println(u.getName());
        }
        System.out.println("---------TREE set c  2-мя Comporatorom----------");


        Comparator<User> userComparator = new UserComparator().thenComparing(new UserAgeComparator());
        TreeSet<User> userTreeSet = new TreeSet<>(new UserComparator());
        userTreeSet.add(new User("jjffff", 65));
        userTreeSet.add(new User("rrr", 2));
        userTreeSet.add(new User("dddd", 3));

        for (User u : userTreeSet) {
            System.out.println(u.getName() + "-" + u.getAge());
        }


        ///-----------домашка----------
//        ArrayList<Person>personArrayList=new ArrayList<>();
//        Person person=new Person();
//        person.generate(12);
//

        ClassLoader loader = CollectionExample.class.getClassLoader();
        File file = new File(loader.getResource("file.txt").getFile());

        // Читаем строки из файла
        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();

        for (String line : lines) {
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                    .trim() // убираем пробелы
                    .split("\\s");
            for (String s : wordSplit) {
                if (s.length() > 0) {
                    words.add(s.trim());
                }
            }
        }

        for (String word : words) {
            System.out.println(word);
        }
    }

}









//-----Comporable
//для храненеия TreeSwet и сортировать объекты+ с какими данными будет работать
class Book implements Comparable<Book>{
    private String title;


    ////--0 когда равны
    ///отрицательное - когда объект стоит раньше до объекта o
    //полодительное - когда обеъкт стоит после объекта o



    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }
    @Override
    public int compareTo(Book o) {
        ///клсс сравненеия объектов
        return title.compareTo(o.getTitle());//--0 - когда равны
    }
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

////-----------------------------------------------------------------
class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}


///-----------Comporator----------
class UserComparator implements Comparator<User>
{
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class UserAgeComparator implements Comparator<User>
{
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}



