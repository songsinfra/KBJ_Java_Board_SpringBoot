package com.board.kbj.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class InterceptHandler implements HandlerInterceptor{
 
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
            throws Exception {
    	// 원하는 경로로 설정하고 false 하면, 원래 예정이던 것은 실행되지 않음
    	if(false) {
    		res.sendRedirect("/"); //원하는 경로로 설정
    		return false;
    	}
    	// 특별히 의미는 없지만 설정한 Intercept
    	return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	// 특별히 의미는 없지만 설정한 Intercept
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    	// 특별히 의미는 없지만 설정한 Intercept
    }
 
}