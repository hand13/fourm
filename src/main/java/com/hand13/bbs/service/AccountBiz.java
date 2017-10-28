package com.hand13.bbs.service;

/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
public interface AccountBiz {

    public void updatePassword(Integer userId,String password);

    public void lockAccount(Integer userId);

    public void unlockAccount(Integer userId);

}
