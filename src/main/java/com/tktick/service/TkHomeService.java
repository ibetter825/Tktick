package com.tktick.service;

import java.util.List;
import java.util.Map;

import com.tktick.bean.entity.TkHome;
import com.tktick.bean.rq.QueryRq;

public interface TkHomeService {
	/**
	 * 保存首页数据
	 * @param username
	 * @return
	 */
	public boolean save(TkHome home);
	/**
	 * 查询首页数据封装为map集合
	 * @param rq
	 * @return
	 */
	public List<Map<?, ?>> queryListForMap(QueryRq rq);
}
