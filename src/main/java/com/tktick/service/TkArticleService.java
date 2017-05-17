package com.tktick.service;

import com.tktick.bean.entity.TkArticle;

public interface TkArticleService {
	/**
	 * 保存新的文章
	 * @param article
	 * @return
	 */
	public TkArticle saveArticle(TkArticle article);
}
