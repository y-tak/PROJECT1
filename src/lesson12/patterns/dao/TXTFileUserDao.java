package lesson12.patterns.dao;

import java.util.List;

public class TXTFileUserDao implements UserDao
{
    @Override
    public void addUser() {

    }

    @Override
    public void addUser(User user) {
        System.out.println("добавление пользователя "+user);
    }

    @Override
    public void getUserById(int id) {

    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void uodateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
