package com.hand13.bbs.dao;

import com.hand13.bbs.entity.Post;

import java.util.List;

/**
 * Created by hd110 on 2017/10/25.
 * edited by hand13
 */
public interface PostDao {
    void addPost(Post post);

    void deletePostByPostId(Integer id);

    List<Post> getPostByTopicId(Integer topicId);

    List<Post> getPostByUserId(Integer userId);

    void updatePost(Post post);
}
