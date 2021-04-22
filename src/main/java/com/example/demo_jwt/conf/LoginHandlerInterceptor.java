package com.example.demo_jwt.conf;

import com.example.demo_jwt.service.TokenUtilService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginHandlerInterceptor
 * 登录拦截器
 *
 * @author LINMINGLE
 * @version 1.0
 * 2021/4/21 15:58
 **/

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Resource(name = "tokenUtilService")
    TokenUtilService tokenUtilService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("L_Token");
        if (!tokenUtilService.verifyToken(token)) {
            response.setStatus(401);
            response.getWriter().print("无效的Token，请重新登录！");
            response.getWriter().flush();
            return false;
        }
        return true;
    }

//    todo： print logs
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
