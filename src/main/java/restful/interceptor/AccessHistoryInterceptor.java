package restful.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Chris Yang
 * created 2022-07-21 13:44
 **/
public class AccessHistoryInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(AccessHistoryInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuilder log = new StringBuilder();
        // 用户的地址
        log.append(request.getRemoteAddr());
        log.append("|");
        // 用户访问的网址
        log.append(request.getRequestURL());
        log.append("|");
        // 用户所用的设备
        log.append(request.getHeader("user-agent"));
        logger.info(log.toString());
        return true;
    }
}
