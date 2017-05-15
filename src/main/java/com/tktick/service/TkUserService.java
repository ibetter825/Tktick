package com.tktick.service;

import com.tktick.bean.entity.TkUser;
import com.tktick.bean.form.LoginForm;

public interface TkUserService {
	/**
	 * 通过用户名获取用户
	 * @param username
	 * @return
	 */
	public TkUser getTkUserByUsername(String username);
	/**
	 * 登录认证
	 * @param form
	 * @return
	 */
	public TkUser valiLoginUser(LoginForm form);
}
