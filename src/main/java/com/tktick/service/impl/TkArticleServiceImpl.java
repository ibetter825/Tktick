package com.tktick.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tktick.bean.entity.TkArticle;
import com.tktick.bean.rq.QueryRq;
import com.tktick.dao.mapper.TkArticleMapper;
import com.tktick.service.TkArticleService;
import com.tktick.task.TkAsyncTask;

@Service
public class TkArticleServiceImpl implements TkArticleService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TkArticleServiceImpl.class);
	@Autowired
	private TkAsyncTask task;
	@Autowired
	private TkArticleMapper articleMapper;
	
	@Override
	public TkArticle saveArticle(TkArticle article) throws InterruptedException {
		//自动提取摘要,看是通过这种方法提取还是直接截取还是直接截取前200个字符，这种比较费时间
		//if(StringUtils.isEmpty(article.getArtDesc()))
			//article.setArtDesc(StringUtils.join(HanLP.extractSummary(article.getArtText(), 5), ","));
		//自动提取关键词
		//提取的关键词需要存入到另外一张表中，另开线程工作，工作完成以后，修改文章与关键词的关联表
		//根据文章的长度来确定应该提取的关键词的数量
		//articleRepository.save(article);
		//articleMapper.insertUseGeneratedKeys(article);//主键名必须为id保存后才能获取自增的id值
		articleMapper.insertSelectiveUseGeneratedKeys(article);
		System.err.println("生成的文章ID:" + article.getId());
		//task.doTaskArtTag(article);//自动提取关键词比较耗时，所以另开线程去做，然后update
		return article;
	}
	
	@Override
	public List<Map<?, ?>> queryArticleList(QueryRq rq) {
		return articleMapper.selectListByRq(rq.getQrq());
	}
	
	@Override
	public Map<?, ?> queryArticleForMap(Long id) {
		return articleMapper.selectOneByIdForMap(id);
	}
	
	@Override
	public TkArticle queryArticle(Long id, boolean state) {
		if(!state)
			return articleMapper.selectByPrimaryKey(id);
		else
			return articleMapper.selectOneById(id);
	}
	
	@Override
	public List<Map<?, ?>> queryComtsAndReplies(Map<?, ?> params) {
		return articleMapper.selectComtsAndReplies(params);
	}
	
	@Override
	public boolean removeArticle(Long id) {
		return articleMapper.deleteByPrimaryKey(id) == 1;
	}

	@Override
	public boolean modifyArticle(TkArticle article) {
		return articleMapper.updateByPrimaryKeySelective(article) == 1;
	}
	
}
