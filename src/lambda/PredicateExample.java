package lambda;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        ArrayList<User> users=new ArrayList<>();

        User user1 = new User ("yui",45,"Russia");
        User user2 = new User ("wer",23,"Canada");
        User user3 = new User ("ewq",66,"German");
        User user4 = new User ("wer",50,"China");
        User user5 = new User ("dfg",22,"China");

        users.add(user1);users.add(user2);users.add(user3);users.add(user4);users.add(user5);
        Listeners listeners=new Listeners(users);
        System.out.println("listeners = " + listeners.getMoreThen45());

        List<User> list1 = listeners.getFilterUser(user->"Russia".equals(user.getCountry()));
        System.out.println("list1 = " + list1);


        Predicate<User> russianFilter=user->"Russia".equals(user.getCountry());
        Predicate<User> ageFilter=user->user.getAge()>45;
        Predicate<User> chineFilter=user->"China".equals(user.getCountry());


        System.out.println("list2 = " + listeners.getFilterUser(ageFilter));
        System.out.println("list3 = " + listeners.getFilterUser(chineFilter.and(ageFilter)));
    }
}

class Listeners
{
    private List<User> userList;

    public Listeners(List<User> userList) {
        this.userList = userList;
    }

    ////---------------nтолько россия-
    public List<User> getRussiaList()
    {
        List<User> list=new ArrayList<>();
        for (User u:userList)
        {
            if ("Russia".equals(u.getCountry()))
                list.add(u);
        }
        return list;
    }

    ////-------------------старше 45-

    public List<User> getMoreThen45()
    {
        List<User> list=new ArrayList<>();
        for (User u:userList)
        {
            if (u.getAge()>45)
                list.add(u);
        }
        return list;
    }

    ////--------------------из китая и старше 45----
    public List<User> getFromChinaMoreThen45()
    {
        List<User> list=new ArrayList<>();
        for (User u:userList)
        {
            if ("China".equals(u.getCountry())&&u.getAge()>45)
                list.add(u);
        }
        return list;
    }

    ////-- с использованием Predicate

    public List<User> getFilterUser(Predicate<User> predicate)
    {
        List<User> list=new ArrayList<>();
        for (User u:userList)
        { if (predicate.test(u)==true)
             list.add(u);
        }
        return list;
    }





}





class  User
{
    private  String login;
    private int age;
    private String country;


    public User(String login, int age, String country) {
        this.login = login;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
