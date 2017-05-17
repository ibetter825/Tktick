package com.tktick.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tktick.bean.entity.TkArticle;
import com.tktick.dao.TkArticleDao;
import com.tktick.service.TkArticleService;

@Service
public class TkArticleServiceImpl implements TkArticleService {

	@Autowired
	private TkArticleDao articleDao;
	
	@Override
	public TkArticle saveArticle(TkArticle article) {
		return articleDao.save(article);
	}
}
