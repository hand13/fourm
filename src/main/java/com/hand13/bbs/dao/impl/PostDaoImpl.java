package com.hand13.bbs.dao.impl;
import com.hand13.bbs.dao.PostDao;
import com.hand13.bbs.entity.Post;
import org.mybatis.spring.SqlSessionTemplate;
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
public class PostDaoImpl implements PostDao {

    private static final String PostDao_SQL= "com.hand13.bbs.dao.PostDao.";

    private SqlSessionTemplate template;

    public SqlSessionTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(SqlSessionTemplate template) {
        this.template = template;
    }

    @Override
    public void addPost(Post post) {
        template.insert(PostDao_SQL+"addPost",post);
    }

    @Override
    public void deletePostByPostId(Integer id) {
        template.delete(PostDao_SQL+"deletePostByPostId",id);
    }

    @Override
    public List<Post> getPostByTopicId(Integer topicId) {
        return template.selectList(PostDao_SQL+"getPostByTopicId",topicId);
    }

    @Override
    public List<Post> getPostByUserId(Integer userId) {
        return template.selectList(PostDao_SQL+"getPostByUserId",userId);
    }

    @Override
    public void updatePost(Post post) {
        template.update(PostDao_SQL+"updatePost",post);
    }

    @Override
    public List<Post> getPostByUserIdWithPage(Integer userId, int start, int size) {
        Map<String,Integer> map = new HashMap<>();
        map.put("userId",userId);
        map.put("start",start);
        map.put("size",size);
        return template.selectList(PostDao_SQL+"getPostByUserIdWithPage",map);
    }

    @Override
    public List<Post> getPostByTopicIdWithPage(Integer topicId, int start, int size) {
        Map<String,Integer> map = new HashMap<>();
        map.put("topicId",topicId);
        map.put("start",start);
        map.put("size",size);
        return template.selectList(PostDao_SQL+"getPostByTopicIdWithPage",map);
    }
}
