package com.hand13.bbs.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class User implements Serializable {

  private Integer userId;
  private String userName;
  private String password;
  private String salt;
  private String roleIds;
  private Integer locked;
  private Integer credits;
  private Integer topics;
  private List<Integer> roles;

  public  String getCredentialsSalt() {
      return userName+salt;
  }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRoleIds() {
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i : roles) {
            stringBuilder.append(i).append(";");
        }
        return stringBuilder.toString();
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
        String[] ids = roleIds.split(";");
        roles = new LinkedList<>();
        for(String id:ids) {
            roles.add(Integer.parseInt(id));
        }
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
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

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
