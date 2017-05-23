package com.tktick.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hankcs.hanlp.HanLP;
import com.tktick.bean.entity.TkArticle;
import com.tktick.dao.repository.TkArticleRepository;
import com.tktick.service.TkArticleService;
import com.tktick.task.TkAsyncTask;

@Service
public class TkArticleServiceImpl implements TkArticleService {

	@Autowired
	private TkAsyncTask task;
	@Autowired
	private TkArticleRepository articleRepository;
	
	@Override
	public TkArticle saveArticle(TkArticle article) {
		//自动提取摘要,看是通过这种方法提取还是直接截取还是直接截取前200个字符，这种比较费时间
		//if(StringUtils.isEmpty(article.getArtDesc()))
			//article.setArtDesc(StringUtils.join(HanLP.extractSummary(article.getArtText(), 5), ","));
		//自动提取关键词
		//提取的关键词需要存入到另外一张表中，另开线程工作，工作完成以后，修改文章与关键词的关联表
		//根据文章的长度来确定应该提取的关键词的数量
		articleRepository.save(article);
		System.err.println("生成的文章ID:" + article.getArtId());
		try {
			task.doTaskArtTag(article);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public static void main(String[] args) {
		String document = "小时候没啥玩具玩，玻璃弹珠是童年玩的最多的，也是童年最美好的回忆了。但是一直很好奇弹珠里面的花瓣是怎么来的，现在终于解开了，近期，一家日本的一个科学探索节目终于解开了这一困扰多年的疑问。弹珠有完全透明的，也有五彩缤纷的，里面还有花瓣的";
		//List<String> sentenceList = HanLP.extractSummary(document, 5);
		//System.out.println(sentenceList);
		List<String> keywordList = HanLP.extractKeyword(document, 5);
		System.err.println(keywordList);
	}
}
