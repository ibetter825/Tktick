package com.tktick.service;

import com.tktick.bean.entity.TkSetKeeper;

public interface TkSetKeeperService {
	/**
	 * 保存合集管理员记录
	 * @param username
	 * @return
	 */
	public boolean save(TkSetKeeper keeper);
	/**
	 * 查询合集管理员
	 * @param keeper
	 * @return
	 */
	public TkSetKeeper query(TkSetKeeper keeper);
}
