package com.tktick.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.tktick.annotation.Permission;
import com.tktick.bean.entity.TkUser;
import com.tktick.context.SessionContextHolder;
import com.tktick.exception.TkAuthenticationException;

/**
 * 使用 AOP检查是否登录
 * @author user
 *
 */
@Aspect
@Component
public class AuthorityInterceptor {
	
	@Before("@annotation(permission)")//会拦截注解Permission的方法，否则不拦截
    public void authority(JoinPoint point, Permission permission) throws Throwable {
        TkUser user = SessionContextHolder.getCurrentUser();
        if(user == null){
        	System.err.println("用户尚未登录");
        	throw new TkAuthenticationException("未登录");
        }
    }
}
