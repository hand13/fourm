package com.hand13.bbs.dao;

import com.hand13.bbs.entity.Topic;

import java.util.List;

/**
 * Created by hd110 on 2017/10/25.
 * edited by hand13
 */
public interface TopicDao {

    void addTopic(Topic topic);

    List<Topic> getTopicByUserId(Integer userId);

    List<Topic> getTopicByBoardId(Integer boardId);

    void updateTopic(Topic topic);

    void deleteTopicById(Integer topicId);

    Topic getTopicByTopicId(int topicId);

    List<Topic> getTopicByBoardIdWithPage(Integer boardId,int start,int size);

    List<Topic> getTopicByUserIdWithPage(Integer userId,int start,int size);
}
