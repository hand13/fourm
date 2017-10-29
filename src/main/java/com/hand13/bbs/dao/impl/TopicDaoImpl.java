package com.hand13.bbs.dao.impl;

import com.hand13.bbs.dao.TopicDao;
import com.hand13.bbs.entity.Topic;
import org.mybatis.spring.SqlSessionTemplate;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
@Repository
public class TopicDaoImpl implements TopicDao {

    private static final String TOPICDAO_SQL = "com.hand13.bbs.dao.TopicDao";

    private SqlSessionTemplate template;

    public SqlSessionTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(SqlSessionTemplate template) {
        this.template = template;
    }

    @Override
    public void addTopic(Topic topic) {
        template.insert(TOPICDAO_SQL+"addTopic",topic);
    }

    @Override
    public List<Topic> getTopicByUserId(Integer userId) {
        return template.selectList(TOPICDAO_SQL+"getTopicByUserId",userId);
    }

    @Override
    public List<Topic> getTopicByBoardId(Integer boardId) {
        return template.selectList(TOPICDAO_SQL+"getTopicByBoardId",boardId);
    }

    @Override
    public void updateTopic(Topic topic) {
        template.update(TOPICDAO_SQL+"updateTopic",topic);
    }

    @Override
    public void deleteTopicById(Integer topicId) {
        template.delete(TOPICDAO_SQL+"deleteTopic",topicId);
    }

    @Override
    public Topic getTopicByTopicId(int topicId) {
        return template.selectOne(TOPICDAO_SQL+"getTopicByTopicId",topicId);
    }

    @Override
    public List<Topic> getTopicByBoardIdWithPage(Integer boardId, int start, int size) {
        Map<String,Integer> map = new HashMap<>();
        map.put("boardId",boardId);
        map.put("start",start);
        map.put("size",size);
        return template.selectList(TOPICDAO_SQL+"getTopicByBoardIdWithPage",map);
    }

    @Override
    public List<Topic> getTopicByUserIdWithPage(Integer userId, int start, int size) {
        Map<String,Integer> map = new HashMap<>();
        map.put("userId",userId);
        map.put("start",start);
        map.put("size",size);
        return template.selectList(TOPICDAO_SQL+"getTopicByUserIdWithPage",map);
    }
}
