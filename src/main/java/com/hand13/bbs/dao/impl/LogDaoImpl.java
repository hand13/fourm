package com.hand13.bbs.dao.impl;

import com.hand13.bbs.dao.LogDao;
import com.hand13.bbs.entity.Log;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
@Repository
public class LogDaoImpl implements LogDao {
    private static final String LogDao_SQL = "com.hand13.bbs.dao.LogDao.";

    private SqlSessionTemplate template;

    public SqlSessionTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(SqlSessionTemplate template) {
        this.template = template;
    }

    @Override
    public List<Log> findAllLog() {
        return template.selectList(LogDao_SQL+"findAllLog");
    }

    @Override
    public List<Log> findLogByUserId(Integer id) {
        return template.selectList(LogDao_SQL+"findLogByUserId",id);
    }

    @Override
    public void addLog(Log log) {
        template.insert(LogDao_SQL+"addLog",log);
    }

    @Override
    public void deleteLogById(Integer logId) {
        template.delete(LogDao_SQL+"deleteLog",logId);
    }

    @Override
    public List<Log> findLogByUserIdWithPage(Integer id, int start, int size) {
        Map<String,Integer> map = new HashMap<>();
        map.put("userId",id);
        map.put("start",start);
        map.put("size",size);
        return template.selectList(LogDao_SQL+"findLogByUserIdWithPage",map);
    }

    @Override
    public List<Log> findLogWithPage(int start, int size) {
        Map<String,Integer> map = new HashMap<>();
        map.put("start",start);
        map.put("size",size);
        return template.selectList(LogDao_SQL+"findLogWithPage",map);
    }
}
