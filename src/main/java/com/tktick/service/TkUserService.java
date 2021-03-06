package com.tktick.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tktick.bean.entity.TkUser;
import com.tktick.bean.form.LoginForm;

public interface TkUserService {
	/**
	 * 通过用户名获取用户
	 * @param username
	 * @return
	 */
	public TkUser queryByUsername(String username);
	/**
	 * 通过id查询用户
	 * @param userId
	 * @return
	 */
	public TkUser queryById(Integer userId);
	/**
	 * 登录认证
	 * 返回错误信息
	 * 返回空表示登录成功
	 * @param form
	 * @return
	 */
	public String valiLoginUser(HttpServletRequest request, HttpServletResponse response, LoginForm form);
}
