package com.hand13.bbs.filter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by hd110 on 2017/10/26.j
 * edited by hand13
 */
public class LoginFilter extends PathMatchingFilter {
    private String loginControlPath = "/login";
    private String loginPath = "/login.jsp";
    private String username = "username";
    private String password = "password";
    @Override
    protected boolean onPreHandle(ServletRequest request,
                                  ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated())
            return true;
        HttpServletRequest servletRequest = (HttpServletRequest)request;
        if(toLogin(servletRequest)){
            if(servletRequest.getMethod().equalsIgnoreCase("post")) {
                if(login(servletRequest))
                    return true;
            }
        }
        saveRequestAndToLogin(servletRequest,(HttpServletResponse)response);
        return false;
    }
    private void saveRequestAndToLogin(HttpServletRequest request, HttpServletResponse response)throws IOException {
        WebUtils.saveRequest(request);
        WebUtils.issueRedirect(request,response,loginPath);
    }
    private boolean toLogin(HttpServletRequest request) {
        return this.pathsMatch(loginControlPath,request);
    }
    private boolean login(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try{
            subject.login(new UsernamePasswordToken(username,password));
        }
        catch (Exception e){
            request.setAttribute("shiroException",e);
        }
        return subject.isAuthenticated();
    }

    public String getLoginControlPath() {
        return loginControlPath;
    }

    public void setLoginControlPath(String loginControlPath) {
        this.loginControlPath = loginControlPath;
    }

    public String getLoginPath() {
        return loginPath;
    }

    public void setLoginPath(String loginPath) {
        this.loginPath = loginPath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
