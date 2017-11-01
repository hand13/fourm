package com.hand13.bbs.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hd110 on 2017/11/1.
 * edited by hand13
 */
public class CFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Logger logger = LoggerFactory.getLogger(this.getClass());

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        MyRequest myRequest = new MyRequest(request);
        Logger logger = LoggerFactory.getLogger(this.getClass());
        filterChain.doFilter(myRequest,servletResponse);
    }
    @Override
    public void destroy() {

    }
}
class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    private Map<String,String[]> kv;
    public MyRequest(HttpServletRequest request) {
        super(request);
        kv = new HashMap<>();
        this.request = request;
        Set<String> keys = request.getParameterMap().keySet();
        for(String s : keys) {
            String[] v = request.getParameterMap().get(s);
            v[0] = v[0].trim().replaceAll("<","&lt;").replaceAll(">","&gt;");
            kv.put(s,v);

        }
    }
    @Override
    public String getParameter(String key) {
        String[] v = kv.get(key);
        if(v == null || v.length == 0) {
            return null;
        }
        return v[0];
    }
    @Override
    public String[] getParameterValues(String key) {
        return kv.get(key);
    }
}
