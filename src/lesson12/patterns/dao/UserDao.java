package lesson12.patterns.dao;

import java.util.List;

public interface UserDao
{
    void addUser();

    void addUser(User user);

    void getUserById(int id);
    List<User> getAllUser();
    void uodateUser(User user);
    void deleteUser(User user);




}
