package dao;


import mapper.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public User selectUserById(Long id) {
        return userMapper.selectUserById(id);
    }

    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }
}
