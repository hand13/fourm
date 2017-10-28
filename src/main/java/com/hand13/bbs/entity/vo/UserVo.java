package com.hand13.bbs.entity.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
public class UserVo {
    private Integer userId;
    private String userName;
    private Integer credits;
    private Integer topics;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getTopics() {
        return topics;
    }

    public void setTopics(Integer topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
