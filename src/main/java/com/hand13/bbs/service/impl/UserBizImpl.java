package com.hand13.bbs.service.impl;
import com.hand13.bbs.dao.UserDao;
import com.hand13.bbs.entity.User;
import com.hand13.bbs.exception.UserExistException;
import com.hand13.bbs.service.UserBiz;
import com.hand13.bbs.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
@Service
public class UserBizImpl implements UserBiz {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id) ;
    }

    @Override
    @Transactional
    public void register(User user)throws UserExistException {
        User tmp = userDao.findUserByName(user.getUserName());
        if(tmp != null)
            throw new UserExistException();
        PasswordHelper passwordHelper = new PasswordHelper();
        passwordHelper.encrypt(user);
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void addCredits(int userId, int credits) {
        User user = userDao.findUserById(userId);
        user.setCredits(user.getCredits()+credits);
        userDao.updateUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
