package com.tktick.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.tktick.interceptor.PreposeInterceptor;

/**
 * 配置拦截器
 * @author user
 *
 */
@Configuration
public class InterceptConfigure extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//注册前置拦截器
		registry.addInterceptor(new PreposeInterceptor()).addPathPatterns("/**");
	}
}
