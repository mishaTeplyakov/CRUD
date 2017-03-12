package net.app.usermanager.dao;

import net.app.usermanager.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> allUsers();

    public List<User> findUsersByPage(int pageid,int total);
}
