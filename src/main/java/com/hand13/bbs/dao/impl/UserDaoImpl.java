package com.hand13.bbs.dao.impl;

import com.hand13.bbs.dao.UserDao;
import com.hand13.bbs.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
@Repository
public class UserDaoImpl implements UserDao {
    private final String sqlNamespace = "com.hand13.bbs.dao.UserDao.";

    private SqlSessionTemplate template;

    public SqlSessionTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(SqlSessionTemplate template) {
        this.template = template;
    }

    @Override
    public User findUserByName(String username) {
        return template.selectOne(sqlNamespace+"findUserByName",username);
    }

    @Override
    public User findUserById(Integer id) {
        return template.selectOne(sqlNamespace+"findUserById",id);
    }

    @Override
    public void updateUser(User user) {
        template.update(sqlNamespace+"updateUser",user);
    }

    @Override
    public void addUser(User user) {
        template.insert(sqlNamespace+"addUser",user);
    }

    @Override
    public void deleteUser(String username) {
        template.delete(sqlNamespace+"deleteUser",username);
    }
}
