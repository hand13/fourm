package com.hand13.bbs.control;
import com.hand13.bbs.entity.Board;
import com.hand13.bbs.entity.Topic;
import com.hand13.bbs.service.ForumBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Created by hd110 on 2017/10/28.
 * edited by hand13
 */
@Controller
@RequestMapping(path = "/forum")
public class ForumControl {
    private int pageSize = 20;
    private ForumBiz forumBiz;

    public ForumBiz getForumBiz() {
        return forumBiz;
    }

    @Autowired
    public void setForumBiz(ForumBiz forumBiz) {
        this.forumBiz = forumBiz;
    }

    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView();
        List<Board> boardList = forumBiz.getAllBoard();
        modelAndView.addObject("boards",boardList);
        modelAndView.setViewName("main");
        return modelAndView;
    }
    @RequestMapping(path = "board/{boardName}/{num}")
    public ModelAndView modelShow(@PathVariable(name = "boardName") String boardName,
                                     @PathVariable(name = "num") String num) {
        Board board = forumBiz.findBoardByName(boardName);
        int n  = Integer.parseInt(num);
        List<Topic> topics = forumBiz.findTopicByBoardId(board.getBoardId(),n,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("board",board);
        modelAndView.addObject("topics",topics);
        modelAndView.setViewName("");
        return modelAndView;
    }
    @RequestMapping(path = "/topic/{topicName}/{num}")
    public ModelAndView topicShow(@PathVariable(name = "topicName") String topicName,
                                     @PathVariable(name = "num") String num) {
        return null;
    }
}
