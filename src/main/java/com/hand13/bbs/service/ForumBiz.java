package com.hand13.bbs.service;

import com.hand13.bbs.entity.Board;
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
}
