package com.tktick.service;

import com.tktick.bean.entity.TkSet;

public interface TkSetService {
	/**
	 * 保存合集
	 * @param username
	 * @return
	 */
	public boolean save(TkSet set);
}
