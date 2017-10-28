package com.hand13.bbs.entity.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by hd110 on 2017/10/28.
 * edited by hand13
 */
public class TopicVo {
    private String boardName;
    private String username;
    private String topicTitle;
    private Date createTime;
    private Date lastPost;
    private int topicViews;
    private int topicReplics;
    private String digest;

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
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

    public int getTopicViews() {
        return topicViews;
    }

    public void setTopicViews(int topicViews) {
        this.topicViews = topicViews;
    }

    public int getTopicReplics() {
        return topicReplics;
    }

    public void setTopicReplics(int topicReplics) {
        this.topicReplics = topicReplics;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
}
