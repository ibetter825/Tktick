package com.tktick.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tktick.context.SessionContextHolder;
import com.tktick.model.entity.TkUser;

/**
 * 前置拦截器
 * 每次从cookie中取出用户登录信息，存入到SessionContextHolder中
 * @author user
 *
 */
public class PreposeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.err.println(request.getRequestURI());
		System.err.println("进入到前置拦截器中");
		SessionContextHolder.setCurrentUser(new TkUser());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
