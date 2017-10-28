package com.hand13.bbs.service;
import com.hand13.bbs.entity.User;
import com.hand13.bbs.exception.UserExistException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
public interface UserBiz {

    public User findUserByName(String username);

    public User findUserById(Integer id);

    public void register(User user)throws UserExistException;

    public void addCredits(int userId,int credits);

    public void updateUser(User user) ;

    public void login(User user, HttpServletRequest request);
}
