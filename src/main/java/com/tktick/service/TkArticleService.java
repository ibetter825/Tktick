package com.tktick.service;

import java.util.List;
import java.util.Map;

import com.tktick.bean.entity.TkArticle;
import com.tktick.bean.rq.QueryRq;

public interface TkArticleService {
	/**
	 * 保存新的文章
	 * @param article
	 * @return
	 * @throws InterruptedException 
	 */
	public TkArticle saveArticle(TkArticle article) throws InterruptedException;
	/**
	 * 根据条件查询文章集合
	 * @param rq
	 * @return
	 */
	public List<Map<?, ?>> queryArticleList(QueryRq rq);
	
	/**
	 * 根据主键查询封装为map的数据
	 * @param id
	 * @return
	 */
	public Map<?, ?> queryArticle(Long id);
}
