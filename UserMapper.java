package mapper;


import model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO users (username, gender, age, create_user, create_user_name, create_time, update_user, update_user_name, update_time, is_delete) " +
            "VALUES (#{username}, #{gender}, #{age}, #{createUser}, #{createUserName}, NOW(), #{updateUser}, #{updateUserName}, NOW(), 0)")
    void insertUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(Long id);

    @Update("UPDATE users SET username=#{username}, gender=#{gender}, age=#{age}, update_user=#{updateUser}, update_user_name=#{updateUserName}, update_time=NOW() WHERE id = #{id}")
    void updateUser(User user);

    @Select("SELECT * FROM users WHERE id = #{id}")
    User selectUserById(Long id);

    @Select("SELECT * FROM users")
    List<User> selectAllUsers();
}
