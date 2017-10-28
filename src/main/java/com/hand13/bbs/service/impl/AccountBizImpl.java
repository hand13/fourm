package com.hand13.bbs.service.impl;
import com.hand13.bbs.dao.UserDao;
import com.hand13.bbs.entity.User;
import com.hand13.bbs.service.AccountBiz;
import com.hand13.bbs.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
@Repository
public class AccountBizImpl implements AccountBiz {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void updatePassword(Integer userId, String password) {
        User user = userDao.findUserById(userId);
        PasswordHelper passwordHelper = new PasswordHelper();
        user.setPassword(password);
        passwordHelper.encrypt(user);
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void lockAccount(Integer userId) {
        User user = userDao.findUserById(userId);
        user.setLocked(1);
        userDao.updateUser(user);
    }

    @Override
    public void unlockAccount(Integer userId) {
        User user = userDao.findUserById(userId);
        user.setLocked(0);
        userDao.updateUser(user);
    }
}
