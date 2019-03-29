package lesson10;

import java.lang.ref.WeakReference;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {

        ///элементы хранятся на основе hash ключей не по порядку!
       User user1=new User("qwe","111");
        User user2=new User("zxc","222");
        User user3=new User("asd","333");
        User user4=new User();

        HashMap<String,User> userHashMap=new HashMap<>();
        ///добавляем элементы
        userHashMap.put("qwe",user1);
        userHashMap.put("zxc",user2);
        userHashMap.put("asd",user3);
        userHashMap.put(null,user4);
        ///обращение по ключу
        System.out.println("user= " + userHashMap.get("asd"));



        ///перебор
        for (Map.Entry entry: userHashMap.entrySet())
        {
            System.out.println( entry.getKey());
            System.out.println( entry.getValue());
        }

       //// LinkedHashMap - по порядку
        //EnumMap - в качестве ключей зранит enum
        //null не используется
        EnumMap<State,String> enumMap=new EnumMap<State, String>(State.class);
        enumMap.put(State.Error,"Error");
        enumMap.put(State.Start,"Start");

        System.out.println(enumMap.get(State.Error));

        ///хранит данные с отсортированными ключами
        TreeMap<Integer,String> treeMap=new TreeMap<>();
        treeMap.put(3,"345");
        treeMap.put(1,"654");
        treeMap.put(8,"789");
        treeMap.put(7,"666");
        System.out.println("treeMap = " + treeMap);

        Object o=new Object();
        ///назначаем ссылку..
        WeakReference weakReference=new WeakReference(o);///слабая ссылка, удаляется сборщиком мусора..



        WeakHashMap<Object,String> weakHashMap=new WeakHashMap<>();
        HashMap<Object,String> hashMap=new HashMap<>();
        ///ключи и значения
        Object hashKey=new Object();
        String hashValue = "hash";

        Object weakKey=new Object();
        String weakValue = "weak";
        hashMap.put(hashKey,hashValue);

        weakHashMap.put(weakKey,weakValue);

        System.out.println( "H" +hashMap);
        System.out.println( "W"+weakHashMap);
        hashKey=null;
        weakKey=null;
        System.out.println( "сборщик мусора");
        System.gc();///сборщик муусора
        System.out.println( "H" +hashMap);
        System.out.println( "W"+weakHashMap);

        //ключи сравниваются с помощью оператора == (не метода equals)
        IdentityHashMap<Integer,String> integerStringIdentityHashMap=new IdentityHashMap<>();
         HashMap<String,Integer> map =new HashMap<>();
         map.put("qwe",1);
        map.put("asd",81);
        map.put("zxc",20);
        map.put("rty",10);
        map.put("fgh",19);

//        не правильно удалять
//        for (Map.Entry<String,Integer> entry:map.entrySet())
//        {
//            map.remove("qwe");
//        }
        Iterator<Map.Entry<String,Integer>> iterator= map.entrySet().iterator();
        ////----удаление во время итерации---
        while (iterator.hasNext())
        {
         Map.Entry<String,Integer> entry=iterator.next();
         String key =entry.getKey();
         int val =entry.getValue();
         if (val<20)
         {iterator.remove();
         }
        }
        System.out.println( "M" +map);
    }



}

enum State {Start,Stop,Finish,Error}
///------------
class User
{
    private String login;
    private  String pwd;

    public User() {
    }

    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    //переопределяем если используем в качестве ключей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return pwd != null ? pwd.equals(user.pwd) : user.pwd == null;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }

}