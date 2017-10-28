package com.hand13.bbs.service.impl;

import com.hand13.bbs.dao.LogDao;
import com.hand13.bbs.entity.Log;
import com.hand13.bbs.service.LogBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hd110 on 2017/10/27.
 * edited by hand13
 */
@Service
public class LogBizImpl implements LogBiz {
    private LogDao logDao;

    public LogDao getLogDao() {
        return logDao;
    }

    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    @Override
    public void addLog(Log log) {
        logDao.addLog(log);
    }

    @Override
    public List<Log> findAllLogByUserId(Integer userId) {
        return logDao.findLogByUserId(userId);
    }

    @Override
    public List<Log> findAllLog() {
        return logDao.findAllLog();
    }
}
