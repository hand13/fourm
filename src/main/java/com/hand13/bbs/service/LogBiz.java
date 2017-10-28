package com.hand13.bbs.service;

import com.hand13.bbs.entity.Log;

import java.util.List;

/**
 * Created by hd110 on 2017/10/27.
 * edited by hand13
 */
public interface LogBiz {

    public void addLog(Log log);

    public List<Log> findAllLogByUserId(Integer userId);

    public List<Log> findAllLog();
}
