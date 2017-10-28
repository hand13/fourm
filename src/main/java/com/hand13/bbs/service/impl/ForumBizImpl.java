package com.hand13.bbs.service.impl;

import com.hand13.bbs.dao.BoardDao;
import com.hand13.bbs.dao.TopicDao;
import com.hand13.bbs.entity.Board;
import com.hand13.bbs.entity.Topic;
import com.hand13.bbs.service.ForumBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hd110 on 2017/10/28.
 * edited by hand13
 */
@Service
public class ForumBizImpl implements ForumBiz {
    private BoardDao boardDao;
    private TopicDao topicDao;

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
        return topicDao.getTopicByBoardId(boardId);
    }
}
