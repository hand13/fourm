package com.hand13.bbs.dao.impl;

import com.hand13.bbs.dao.BoardDao;
import com.hand13.bbs.entity.Board;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
@Repository
public class BoardDaoImpl implements BoardDao {
    private static final String Board_Sql = "com.hand13.bbs.dao.BoardDao.";
    private SqlSessionTemplate template;

    public SqlSessionTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(SqlSessionTemplate template) {
        this.template = template;
    }

    @Override
    public Board findBoardByName(String boardName) {
        return template.selectOne(Board_Sql+"findBoardByName",boardName);
    }

    @Override
    public Board findBoardById(Integer boardId) {
        return template.selectOne(Board_Sql+"findBoardById",boardId);
    }

    @Override
    public List<BoardDao> findAllBoard() {
        return template.selectList(Board_Sql+"findAllBoard");
    }

    @Override
    public void deleteBoardById(Integer boardId) {
        template.delete(Board_Sql+"deleteBoard",boardId);
    }

    @Override
    public void updateBoard(Board board) {
        template.update(Board_Sql+"updateBoard",board);
    }

    @Override
    public void addBoard(Board board) {
        template.insert(Board_Sql+"addBoard",board);
    }
}
