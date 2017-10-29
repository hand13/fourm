package com.hand13.bbs.dao;

import java.util.List;

/**
 * Created by hd110 on 2017/10/25.
 * edited by hand13
 */
public interface ManageDao {
    void addManage(int boardId,String username);
    void deleteManager(int boardId,String username);
    List<String> getManagerByBoardId(int boardId);
    List<Integer> getBoardIdByManagerName(String username);
}
