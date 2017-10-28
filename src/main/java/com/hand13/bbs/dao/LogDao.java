package com.hand13.bbs.dao;

import com.hand13.bbs.entity.Log;

import java.util.List;

/**
 * Created by hd110 on 2017/10/25.
 * edited by hand13
 */
public interface LogDao {

    List<Log> findAllLog();

    List<Log> findLogByUserId(Integer id);

    void addLog(Log log);

    void deleteLogById(Integer logId);

    List<Log> findLogByUserIdWithPage(Integer id,int start,int size);

    List<Log> findLogWithPage(int start,int size);
}
