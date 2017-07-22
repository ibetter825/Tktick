package com.tktick.service;

import java.util.List;
import java.util.Map;
import com.tktick.bean.entity.TkArticleClz;
import com.tktick.bean.rq.QueryRq;

public interface TkArticleClzService {
	/**
	 * 保存分类
	 * @param clz
	 * @return
	 */
	public boolean saveClz(TkArticleClz clz);
	/**
	 * 查询分类集合
	 * @param rq
	 * @return
	 */
	public List<Map<?, ?>> queryClzForMapList(QueryRq rq);
}
