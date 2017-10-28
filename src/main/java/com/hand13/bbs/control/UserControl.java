package com.hand13.bbs.control;
import com.hand13.bbs.entity.User;
import com.hand13.bbs.exception.UserExistException;
import com.hand13.bbs.service.AccountBiz;
import com.hand13.bbs.service.UserBiz;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
@Controller
public class UserControl {
    private UserBiz userBiz;
    private AccountBiz accountBiz;
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        User user = userBiz.findUserByName(username);
        userBiz.login(user,request);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public ModelAndView register(User user, ModelAndView modelAndView) {
        try {
            userBiz.register(user);
        }
        catch (UserExistException ueu) {
            modelAndView.addObject("error",ueu.getMessage());
            modelAndView.setViewName("regiest");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping(path = "/password",method = RequestMethod.POST)
    public void password(HttpServletRequest request) {
        String password = request.getParameter("password");
        User user = (User)request.getSession().getAttribute("user");
        accountBiz.updatePassword(user.getUserId(),password);

    }
    public UserBiz getUserBiz() {
        return userBiz;
    }

    @Autowired
    public void setUserBiz(UserBiz userBiz) {
        this.userBiz = userBiz;
    }


    public AccountBiz getAccountBiz() {
        return accountBiz;
    }

    @Autowired
    public void setAccountBiz(AccountBiz accountBiz) {
        this.accountBiz = accountBiz;
    }
}
