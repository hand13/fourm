package com.hand13.bbs.dao;

import com.hand13.bbs.entity.Board;

import java.util.List;

/**
 * Created by hd110 on 2017/10/25.
 * edited by hand13
 */
public interface BoardDao {

    Board findBoardByName(String boardName);

    Board findBoardById(Integer boardId);

    List<Board> findAllBoard();

    void deleteBoardById(Integer boardId);

    void updateBoard(Board board);

    void addBoard(Board board);

    List<Board> findBoardWithPage(int start,int size);
}
