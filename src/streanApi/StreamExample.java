package streanApi;

import javax.swing.table.AbstractTableModel;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args)  {
        //методы получения stream объекта
//        Stream<String> stringStream = collection.stream();
//        // из массива
//        Arrays.stream(someArr);
//        ///из файла
//        Files.lines(путь_к_файлу);
//        /// из строки
//        "String".chars();
//        Stream.builder().add(obj).add(obj2).build();
//
//        Stream.of(1,3,6);



        Stream<Integer> integerStream=Stream.of(3,2,34,54,-34,-2,0,78);
        integerStream.filter(num->num<0)//отбор по фильтру отрицательные значения
        .map(num->num*100) ///оставшиеся умножаем на 100
                .limit(3)//вернется 3 элемента
        .forEach(System.out::println);

        Stream<Integer> integerStream1=Stream.of(3,2,34,54,-34,-2,0,78);
        integerStream1.distinct() //выбирает уникальные объекты, значения
        .sorted() ///сортировка
        .forEach(System.out::println);
        ///anyMatch|noneMatch|allMatch
////вернте true .. хотя бы один| ни один|все элементы соотвествуют условию
        Stream<Integer> integerStream2=Stream.of(3,2,34,54,54,-34,-2,0,78);
        System.out.format("anyMatch: %b \n", integerStream2.anyMatch(num->num==2));


        integerStream2=Stream.of(3,2,34,54,54,-34,-2,0,78);
        System.out.format("noneMatch: %b \n", integerStream2.noneMatch(num->num>100));

        integerStream2=Stream.of(3,2,34,54,54,-34,-2,0,78);
        System.out.format("allMatch: %b \n", integerStream2.allMatch(num->num>0));

        integerStream2=Stream.of(3,2,34,54,-54,34,-9,0,78);
        integerStream2.filter(num->num>0).map(num->num+"$").forEach(System.out::println);

        String[] strings={"5fds","dd","sda","sd56","dfs"};
        System.out.format("первый элемент = %s \n" , Arrays.stream(strings).findFirst().orElse("Коллекция пуста"));
        //или первый или иначе если не нашел - то пустая коллекция
        System.out.format("последний элемент = %s \n" , Arrays.stream(strings).skip(strings.length-1).findAny().orElse("Коллекция пуста"));
///skip(5) пропускаетп первые 5 элементов
        System.out.format("Конкретный sda элемент = %s \n" , Arrays.stream(strings).filter("sda"::equals).findFirst().get());

        System.out.format("Элементы,содержащие 56 %s \n", Arrays.stream(strings)
                .filter(s->s.contains("56"))
                .collect(Collectors.toList()));


        ArrayList<User> users=new ArrayList<>();
        users.add(new User("iuy",24));
        users.add(new User("iuy",35));
        users.add(new User("ret",34));
        users.add(new User("wer",32));
        users.add(new User("hgf",21));
        users.add(new User("wer",76));
        users.add(new User("ret",34));
        ///  массив пользователей старше 30
        System.out.println("массив пользователей старше 30 " );
        User[] users1;
        users1=users.stream().filter(s->s.getAge()>30).toArray(User[]::new);
        System.out.println("Arrays.toString(users1) = " + Arrays.toString(users1));
        List<User> userList=users.stream().peek(user -> user.setActive(true))
                .collect(Collectors.toList());
        System.out.println("userList = " + userList);

        userList.stream().distinct().forEach(System.out::println);

        System.out.println("Сортировка " );
         users.stream().sorted(Comparator.comparing(User::getAge)).forEach(System.out::println);

        System.out.println("Минимальный " );
        System.out.println(users.stream().min(Comparator.comparing(User::getAge)).get());

        System.out.println("Максимальный " );
        System.out.println(users.stream().max(Comparator.comparing(User::getAge)).get());



///Collection
   strings=new String[]{"5fds","dd","sda","sd56","dfs56","sda"}; //анонимный массив

    List<String> stringList= Arrays.stream(strings).collect(Collectors.toList());
    Set<String> stringSet= Arrays.stream(strings).collect(Collectors.toSet());
    ArrayList<String> stringArrayList=Arrays.stream(strings)
        .collect(Collectors.toCollection(ArrayList::new)); ///добавляется нужная нам коллекция
        ///to Map (ключи, значения)
     Map<String,Integer> stringIntegerMap=Arrays.stream(strings)
             .collect(Collectors.toMap(Function.identity(),String::length,((item, item2) -> item)));
        System.out.println("stringIntegerMap = " + stringIntegerMap);
        
        ///объединяться в строчку 
        String str=Arrays.stream(strings).collect(Collectors.joining(" : ","Before -- "," -- End "));
        System.out.println("str = " + str);
        




    }
}


class User
{
    private String login;
    private int age;
    
    private boolean active;

    public User(String login, int age) {
        this.login = login;
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (active != user.active) return false;
        return login != null ? login.equals(user.login) : user.login == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}