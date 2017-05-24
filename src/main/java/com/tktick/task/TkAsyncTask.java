package com.tktick.task;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import com.hankcs.hanlp.HanLP;
import com.tktick.bean.entity.TkArticle;
import com.tktick.dao.mapper.TkArticleMapper;
import com.tktick.utils.StringUtil;

@Component
public class TkAsyncTask {
	@Autowired
	private TkArticleMapper articleMapper;
	@Async("tkTaskAsyncPool")
    public void doTaskArtTag(TkArticle article) throws InterruptedException{
        System.err.println("saveArtTag");
        TkArticle art = new TkArticle();
        try {
        	String text = StringUtil.removeHTMLLabelExe(article.getArtCont());
	        int lth = text.length();
	        int size = lth > 5000 ? 5 : (lth > 300 ? 3 : lth > 2000 ? 2 : 1);
	        List<String> keywordList = HanLP.extractKeyword(text, size);
	        
	        art.setId(article.getId());
	        art.setArtTags(StringUtils.join(keywordList, ","));
	        
	        articleMapper.updateByPrimaryKeySelective(art);
			System.err.println(keywordList);
		} finally {
			article = null;
			art = null;
		}
    }
	
}
