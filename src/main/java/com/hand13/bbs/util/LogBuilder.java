package com.hand13.bbs.util;

import com.hand13.bbs.entity.Log;

import java.util.Date;

/**
 * Created by hd110 on 2017/10/27.
 * edited by hand13
 */
public class LogBuilder {
    private Integer logId;
    private Integer userId;
    private String ip;
    private String message;
    private Date time;
    public LogBuilder setLogId(Integer logId){
        this.logId = logId;
        return this;
    }
    public LogBuilder setUserId(Integer userId){
        this.userId = userId;
        return this;
    }
    public LogBuilder setIp(String ip){
        this.ip = ip;
        return this;
    }
    public LogBuilder setMessage(String message){
        this.message = message;
        return this;
    }
    public LogBuilder setTime(Date date){
        this.time = date;
        return this;
    }
    public Log create() {
        Log log = new Log();
        log.setIp(ip);
        log.setLogId(logId);
        log.setMessage(message);
        log.setTime(time);
        log.setUserId(userId);
        return log;
    }
}
