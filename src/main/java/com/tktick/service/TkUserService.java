package com.tktick.service;

import com.tktick.model.entity.TkUser;

public interface TkUserService {
	/**
	 * 通过用户名获取用户
	 * @param username
	 * @return
	 */
	public TkUser getTkUser(String username);
}
