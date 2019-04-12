package lesson12.patterns.dao;

public class Main {
    public static void main(String[] args) {
        User user=new User("pop",12);
        UserDao userDao=new TXTFileUserDao();
        userDao.addUser(user);

    }
}
