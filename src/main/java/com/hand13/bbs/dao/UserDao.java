package com.hand13.bbs.dao;
import com.hand13.bbs.entity.User;
/**
 * Created by hd110 on 2017/10/25.
 * edited by hand13
 */
public interface UserDao {
    User findUserByName(String username);

    User findUserById(Integer id);

    void updateUser(User user);

    void addUser(User user);

    void deleteUser(String username);

}
