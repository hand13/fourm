package com.hand13.bbs.exception;

/**
 * Created by hd110 on 2017/10/28.
 * edited by hand13
 */
public class UserExistException extends Exception {
    @Override
    public String getMessage() {
        return "user exist";
    }
}
