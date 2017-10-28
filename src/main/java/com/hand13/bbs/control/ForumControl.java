package com.hand13.bbs.control;
import com.hand13.bbs.entity.Board;
import com.hand13.bbs.entity.Post;
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
    private final int TOPIC_SIZE = 20;
    private final int POST_SIZE = 10;
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
        List<Topic> topics = forumBiz.findTopicByBoardId(board.getBoardId(),n,TOPIC_SIZE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("board",board);
        modelAndView.addObject("topics",topics);
        modelAndView.setViewName("");
        return modelAndView;
    }
    @RequestMapping(path = "/topic/{topicId}/{num}")
    public ModelAndView topicShow(@PathVariable(name = "topicId") String topicId,
                                     @PathVariable(name = "num") String num) {
        int id = Integer.parseInt(topicId);
        int n = Integer.parseInt(num);
        Topic topic = forumBiz.findTopicByTopicId(id);
        List<Post> posts = forumBiz.findPostByTopicId(id,n,POST_SIZE);
        Post mainPost = null;
        for(Post post: posts){
            if(post.getPostType() == 0){
                mainPost = post;
                break;
            }
        }
        posts.remove(mainPost);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("topic",topic);
        modelAndView.addObject("mainPost",mainPost);
        modelAndView.addObject("posts",posts);
        return modelAndView;
    }

    @RequestMapping(path = "/addTopic")
    public ModelAndView addTopic(Topic topic) {
        forumBiz.addTopic(topic);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }

    @RequestMapping(path = "/addPost")
    public ModelAndView addPost(Post post) {
        forumBiz.addPost(post);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }
    @RequestMapping(path = "/addBoard")
    public ModelAndView addBoard(Board board) {
        forumBiz.addBoard(board);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }
}
