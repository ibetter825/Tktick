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
		return articleMapper.selectWithParams(rq.getQrq());
	}
	
	public static void main(String[] args) {
		String document = "小时候没啥玩具玩，玻璃弹珠是童年玩的最多的，也是童年最美好的回忆了。但是一直很好奇弹珠里面的花瓣是怎么来的，现在终于解开了，近期，一家日本的一个科学探索节目终于解开了这一困扰多年的疑问。弹珠有完全透明的，也有五彩缤纷的，里面还有花瓣的";
		//List<String> sentenceList = HanLP.extractSummary(document, 5);
		//System.out.println(sentenceList);
		//List<String> keywordList = HanLP.extractKeyword(document, 5);
		//System.err.println(keywordList);
	}
}
