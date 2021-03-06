package com.hand13.bbs.service;
import com.hand13.bbs.entity.Board;
import com.hand13.bbs.entity.Post;
import com.hand13.bbs.entity.Topic;
import java.util.List;

/**
 * Created by hd110 on 2017/10/28.
 * edited by hand13
 */
public interface ForumBiz {
    List<Board> getAllBoard();
    Board findBoardByName(String name);
    List<Topic> findTopicByBoardId(int boardId,int start,int size);
    Topic findTopicByTopicId(int id);
    List<Post> findPostByTopicId(int id,int start,int size);
    void addTopic(Topic topic);
    void addPost(Post post,int topId);
    void addBoard(Board board);
}
