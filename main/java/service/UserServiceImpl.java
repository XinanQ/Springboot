package service;


import dao.UserDao;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void removeUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.selectUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }
}

