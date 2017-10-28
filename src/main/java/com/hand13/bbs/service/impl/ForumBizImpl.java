package com.hand13.bbs.service.impl;

import com.hand13.bbs.dao.BoardDao;
import com.hand13.bbs.dao.PostDao;
import com.hand13.bbs.dao.TopicDao;
import com.hand13.bbs.dao.UserDao;
import com.hand13.bbs.entity.Board;
import com.hand13.bbs.entity.Post;
import com.hand13.bbs.entity.Topic;
import com.hand13.bbs.service.ForumBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
/**
 * Created by hd110 on 2017/10/28.
 * edited by hand13
 */
@Service
public class ForumBizImpl implements ForumBiz {
    private BoardDao boardDao;
    private TopicDao topicDao;
    private PostDao postDao;
    private UserDao userDao;

    public BoardDao getBoardDao() {
        return boardDao;
    }

    @Autowired
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public TopicDao getTopicDao() {
        return topicDao;
    }

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Board> getAllBoard() {
        return boardDao.findAllBoard();
    }

    @Override
    public Board findBoardByName(String boardName) {
        Board board = boardDao.findBoardByName(boardName);
        return board;
    }

    @Override
    public List<Topic> findTopicByBoardId(int boardId,int start,int size) {
        return topicDao.getTopicByBoardIdWithPage(boardId,start,size);
    }

    @Override
    public Topic findTopicByTopicId(int id) {
        return topicDao.getTopicByTopicId(id);
    }

    @Override
    public List<Post> findPostByTopicId(int id,int start,int size) {
        return postDao.getPostByTopicIdWithPage(id,start,size);
    }

    @Override
    @Transactional
    public void addTopic(Topic topic) {
        topic.setLastPost(new Date());
        topic.setCreateTime(new Date());
        topic.setTopicViews(0);
        topicDao.addTopic(topic);
        Board board = boardDao.findBoardById(topic.getBoardId());
        boardDao.updateBoard(board);
        board.setTopicNum(board.getBoardId()+1);
    }

    @Override
    public void addPost(Post post) {
        post.setCreateTime(new Date());
        Topic topic = topicDao.getTopicByTopicId(post.getTopicId());
        topic.setLastPost(new Date());
        topic.setTopicReplics(topic.getTopicReplics()+1);
        topicDao.updateTopic(topic);
        postDao.addPost(post);
    }

    @Override
    public void addBoard(Board board) {
        board.setTopicNum(0);
        boardDao.addBoard(board);
    }
}
