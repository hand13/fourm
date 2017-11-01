package com.hand13.bbs.control;
import com.hand13.bbs.entity.Board;
import com.hand13.bbs.entity.Post;
import com.hand13.bbs.entity.Topic;
import com.hand13.bbs.entity.User;
import com.hand13.bbs.service.ForumBiz;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

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

    @RequestMapping("/show")
    public String show(HttpServletRequest request) {
        List<Board> boardList = forumBiz.getAllBoard();
        request.setAttribute("boards",boardList);
        return "main";
    }
    @RequestMapping(path = "/board/{boardName}/{num}")
    public ModelAndView modelShow(@PathVariable(name = "boardName") String boardName,
                                     @PathVariable(name = "num") String num,HttpServletResponse response)throws IOException {
        Board board = forumBiz.findBoardByName(boardName);
        int  n = parseInt(num,response) -1;
        List<Topic> topics = forumBiz.findTopicByBoardId(board.getBoardId(),n*TOPIC_SIZE,TOPIC_SIZE);
        if(topics.size() == 0 && n != 0 )
            response.sendError(404);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("board",board);
        modelAndView.addObject("topics",topics);
        modelAndView.addObject("num",num);
        modelAndView.setViewName("topics");
        return modelAndView;
    }
    @RequestMapping(path = "/topic/{topicId}/{num}")
    public ModelAndView topicShow(@PathVariable(name = "topicId") String topicId,
                                     @PathVariable(name = "num") String num,HttpServletResponse response)throws IOException {
        int id = parseInt(topicId,response);
        int n = parseInt(num,response)-1;
        Topic topic = forumBiz.findTopicByTopicId(id);
        List<Post> posts = forumBiz.findPostByTopicId(id,n*POST_SIZE,POST_SIZE);
        if(posts.size() ==0 && n != 0){
            response.sendError(404);
        }
        Post mainPost = null;
        for(Post post: posts){
            if(post.getPostType() == 0){
                mainPost = post;
                break;
            }
        }
        if(mainPost != null)
            posts.remove(mainPost);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("posts");
        modelAndView.addObject("topic",topic);
        modelAndView.addObject("mainPost",mainPost);
        modelAndView.addObject("posts",posts);
        modelAndView.addObject("num",num);
        return modelAndView;
    }

    @RequestMapping(path = "/addTopic/{boardId}",method = RequestMethod.POST)
    @RequiresRoles("user")
    public ModelAndView addTopic(HttpServletRequest request,Topic topic,@PathVariable(name = "boardId") String boardId,HttpServletResponse response)throws IOException {
        int bId = parseInt(boardId,response);
        topic.setBoardId(bId);
        User user = (User)request.getSession().getAttribute("user");
        topic.setUserId(user.getUserId());
        forumBiz.addTopic(topic);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/forum/show");
        return modelAndView;
    }
    @RequestMapping(path = "/addTopic/{boardId}",method = RequestMethod.GET)
    @RequiresRoles("user")
    public ModelAndView getTopicWritePage(@PathVariable(name = "boardId") String boardId,HttpServletResponse response)throws IOException {
        int i = parseInt(boardId,response);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("boardId",i);
        modelAndView.setViewName("writeTopic");
        return modelAndView;
    }

    @RequestMapping(path = "/addPost/{topicId}")
    @RequiresRoles("user")
    public ModelAndView addPost(HttpServletRequest request, HttpServletResponse response, Post post, @PathVariable(name = "topicId") String topicId)throws IOException {
        org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.warn(post.getPostContext()+"-------------------------------------------------------------------------------");
        logger.warn(request.getParameter("postContext")+"-------------------------------------------------------");
        int tId = parseInt(topicId,response);
        post.setPostType(0);
        User user =(User)request.getSession().getAttribute("user");
        post.setUserId((user.getUserId()));
        forumBiz.addPost(post,tId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/forum/topic/"+post.getTopicId()+"/1");
        return modelAndView;
    }
    @RequestMapping(path = "/addBoard")
    @RequiresRoles("admin")
    public ModelAndView addBoard(Board board) {
        forumBiz.addBoard(board);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }
    @ExceptionHandler({UnauthenticatedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView ex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unauthorized");
        return modelAndView;
    }
    private int parseInt(String i,HttpServletResponse response)throws IOException{
        int h = 0;
        try{
            h = Integer.parseInt(i);
        }
        catch (Exception e) {
            response.sendError(404);
        }
        return h;
    }
}
