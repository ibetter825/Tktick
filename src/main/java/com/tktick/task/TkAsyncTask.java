package com.tktick.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.hankcs.hanlp.HanLP;
import com.tktick.bean.entity.TkArticle;
import com.tktick.bean.entity.TkTag;
import com.tktick.dao.repository.TkTagArtRepository;
import com.tktick.dao.repository.TkTagRepository;
import com.tktick.utils.StringUtil;

@Component
public class TkAsyncTask {
	
	@Autowired
	private TkTagRepository tagDao;
	
	@Async("tkTaskAsyncPool")
    public void doTaskArtTag(TkArticle article) throws InterruptedException{
        System.err.println("saveArtTag");
        String text = StringUtil.removeHTMLLabelExe(article.getArtCont());
        int lth = text.length();
        int size = lth > 5000 ? 5 : (lth > 300 ? 3 : lth > 2000 ? 2 : 1);
        List<String> keywordList = HanLP.extractKeyword(text, size);
        List<TkTag> tags = new ArrayList<TkTag>();
        TkTag tag = null;
        for (String key : keywordList) {
        	tag = new TkTag();
        	tag.setTagNm(key);
			tags.add(tag);
		}
        //保存或者修改tag
        //完成以后再添加到关联表中
        
        tagDao.save(tags);
		System.err.println(keywordList);
    }
	
}
