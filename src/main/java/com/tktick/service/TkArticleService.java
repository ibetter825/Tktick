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
	public Map<?, ?> queryArticleForMap(Long id);
	/**
	 * 查询文章
	 * @param id
	 * @param state true: 查询状态不为-1的记录
	 * @return
	 */
	public TkArticle queryArticle(Long id, boolean state);
	/**
	 * 物理删除文章
	 * @param id
	 * @return
	 */
	public boolean removeArticle(Long id);
	/**
	 * 修改文章
	 * 可用于软删除文章
	 * @param article
	 * @return
	 */
	public boolean modifyArticle(TkArticle article);
}
