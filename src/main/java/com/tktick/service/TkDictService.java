package com.tktick.service;

import java.util.List;
import java.util.Map;
import com.tktick.bean.entity.TkDict;
import com.tktick.bean.rq.QueryRq;

public interface TkDictService {
	/**
	 * 保存字典
	 * @param dict
	 * @return
	 */
	public boolean saveDict(TkDict dict);
	/**
	 * 查询字典列表
	 * @param rq
	 * @return
	 */
	public List<Map<?, ?>> queryDictForMapList(QueryRq rq);
}