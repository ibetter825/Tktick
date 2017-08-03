package com.tktick.service;

import java.util.List;
import java.util.Map;

import com.tktick.bean.entity.TkArticle;
import com.tktick.bean.rq.PagerRq;
import com.tktick.bean.rq.QueryRq;

public interface TkArticleService {
	/**
	 * 保存新的文章
	 * @param article
	 * @return
	 * @throws InterruptedException 
	 */
	public TkArticle save(TkArticle article);
	/**
	 * 根据条件查询文章集合
	 * @param rq
	 * @return
	 */
	public List<Map<?, ?>> queryForMapList(QueryRq rq);
	/**
	 * 分页查询文章map集合
	 * @param rq
	 * @param pager
	 * @return
	 */
	public List<Map<?, ?>> queryForMapList(QueryRq rq, PagerRq pager);
	/**
	 * 根据主键查询封装为map的数据
	 * @param id
	 * @return
	 */
	public Map<?, ?> queryForMap(Long id);
	/**
	 * 查询文章
	 * @param id
	 * @param state true: 查询状态不为-1的记录
	 * @return
	 */
	public TkArticle query(Long id, boolean state);
	/**
	 * 查询文章的评论以及每条评论的前5条回复
	 * @param params
	 * @return
	 */
	public List<Map<?, ?>> queryComtsAndReplies(Map<?, ?> params);
	/**
	 * 物理删除文章
	 * @param id
	 * @return
	 */
	public boolean remove(Long id);
	/**
	 * 修改文章
	 * 可用于软删除文章
	 * @param article
	 * @return
	 */
	public boolean modify(TkArticle article);
}
