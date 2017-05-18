package com.tktick.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.tktick.bean.entity.TkUser;
import com.tktick.context.SessionContextHolder;

@RestController
public class BaseController {
	@Autowired  
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	
	/**
	 * 获取当前登录的用户
	 * @return
	 */
	public TkUser getCurrentUser(){
		return SessionContextHolder.getCurrentUser();
	}
	/**
	 * 获取系统根目录
	 * @return
	 */
	public String getContextPath(String path){
		return request.getServletContext().getRealPath(path);
	}

	/**
	 * 添加request请求属性
	 * @param key
	 * @param val
	 */
	public void setAttr(String key, Object val){
		request.setAttribute(key, val);
	}
	/**
	 * 获取request请求属性
	 * @param key
	 * @return
	 */
	public Object getAttr(String key){
		return request.getAttribute(key);
	}
}
