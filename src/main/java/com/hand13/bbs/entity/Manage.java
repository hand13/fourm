package com.hand13.bbs.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by hd110 on 2017/10/29.
 * edited by hand13
 */
public class Manage implements Serializable {
    private Integer manageId;
    private String username;

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
