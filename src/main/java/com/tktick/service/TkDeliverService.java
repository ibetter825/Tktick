package com.tktick.service;

import com.tktick.bean.entity.TkDeliver;

/**
 * 投递记录
 * @author ibett
 *
 */
public interface TkDeliverService {
	/**
	 * 保存投递记录
	 * @param username
	 * @return
	 */
	public boolean saveDeliver(TkDeliver deliver);
	/**
	 * 编辑投递记录
	 * @param deliver
	 * @return
	 */
	public boolean modifyDeliver(TkDeliver deliver);
}
