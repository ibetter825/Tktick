package com.tktick.service;

import com.tktick.bean.entity.TkHome;

public interface TkHomeService {
	/**
	 * 保存首页数据
	 * @param username
	 * @return
	 */
	public boolean save(TkHome home);
}
