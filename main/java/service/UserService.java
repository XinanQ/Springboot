package service;


import model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(Long id);
    void modifyUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
}

