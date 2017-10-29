package com.hand13.bbs.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class Topic implements Serializable {

  private Integer topicId;
  private Integer boardId;
  private String topicTitle;
  private Integer userId;
  private String username;
  private Date createTime;
  private Date lastPost;
  private Integer topicViews;
  private Integer topicReplics;
  private String digest;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastPost() {
        return lastPost;
    }

    public void setLastPost(Date lastPost) {
        this.lastPost = lastPost;
    }

    public Integer getTopicViews() {
        return topicViews;
    }

    public void setTopicViews(Integer topicViews) {
        this.topicViews = topicViews;
    }

    public Integer getTopicReplics() {
        return topicReplics;
    }

    public void setTopicReplics(Integer topicReplics) {
        this.topicReplics = topicReplics;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
