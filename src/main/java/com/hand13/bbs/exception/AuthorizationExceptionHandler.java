package com.hand13.bbs.exception;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
public class AuthorizationExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if(o instanceof AuthorizationException) {
            modelAndView.setViewName("");
        }
        return modelAndView;
    }
}
