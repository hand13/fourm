package com.hand13.bbs.dao.impl;

import com.hand13.bbs.dao.ManageDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hd110 on 2017/10/29.
 * edited by hand13
 */
@Repository
public class ManageDaoImpl implements ManageDao {
    private static final String MANAGE_DAO = "com.hand13.bbs.dao.ManageDao.";
    private SqlSessionTemplate template;

    public SqlSessionTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(SqlSessionTemplate template) {
        this.template = template;
    }

    @Override
    public void addManage(int boardId, String username) {
        template.insert(MANAGE_DAO+"addManage",getMap(boardId,username));
    }

    @Override
    public void deleteManager(int boardId, String username) {
        template.delete(MANAGE_DAO+"deleteManager",getMap(boardId,username));
    }

    @Override
    public List<String> getManagerByBoardId(int boardId) {
        return template.selectList(MANAGE_DAO+"getManagerByBoardId",boardId);
    }

    @Override
    public List<Integer> getBoardIdByManagerName(String username) {
        return template.selectList(MANAGE_DAO+"getBoardIdByManagerName",username);
    }
    private Map<String,Object> getMap(Integer boardId,String username) {
        Map<String,Object> map = new HashMap<>();
        map.put("boardId",boardId);
        map.put("username",username);
        return map;
    }
}
