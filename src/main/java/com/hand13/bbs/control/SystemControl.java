package com.hand13.bbs.control;
import com.hand13.bbs.service.AccountBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hd110 on 2017/10/28.
 * edited by hand13
 */
@Controller
@RequestMapping("/master")
public class SystemControl {
    private AccountBiz accountBiz;

    public AccountBiz getAccountBiz() {
        return accountBiz;
    }

    @Autowired
    public void setAccountBiz(AccountBiz accountBiz) {
        this.accountBiz = accountBiz;
    }

    @RequestMapping("/lockUser")
    public void lockUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("userId"));
        accountBiz.lockAccount(id);
    }

    @RequestMapping("unlockUser")
    public void unlockUser(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("userId"));
        accountBiz.unlockAccount(id);
    }
}
