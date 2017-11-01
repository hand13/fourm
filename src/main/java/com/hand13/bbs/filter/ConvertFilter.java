package com.hand13.bbs.filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * Created by hd110 on 2017/11/1.
 * edited by hand13
 */
public class ConvertFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Map<String,String[]> map = httpServletRequest.getParameterMap();
        Set<Map.Entry<String,String[]>> s = map.entrySet();
        for(Map.Entry<String,String[]> entry : s) {
            converts(entry.getKey(),entry.getValue());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
    private void converts(String key,String[] pa) {
        for(int i =0;i < pa.length;i++) {
            pa[i] = pa[i].replaceAll("<","&lt;")
                    .replaceAll(">","&gt;");
            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.debug(pa[i]+"----------------------------------------------------------");
        }
    }
}
