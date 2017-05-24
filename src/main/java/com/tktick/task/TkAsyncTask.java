package com.tktick.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import com.hankcs.hanlp.HanLP;
import com.tktick.bean.entity.TkArticle;
import com.tktick.bean.entity.TkTag;
import com.tktick.dao.mapper.TkArticleMapper;
import com.tktick.dao.mapper.TkTagMapper;
import com.tktick.utils.StringUtil;

@Component
public class TkAsyncTask {
	@Autowired
	private TkArticleMapper articleMapper;
	@Autowired
	private TkTagMapper tagMapper;
	
	@Async("tkTaskAsyncPool")
    public void doTaskArtTag(TkArticle article) throws InterruptedException{
        System.err.println("saveArtTag");
        TkArticle art = null;
        List<String> tagNmList = null;
        List<String> tagIdList = null;
        String artTagNms = article.getArtTagNms();//标签名
        String artTagIds = article.getArtTagIds();//标签id
        boolean isEmpty = StringUtils.isEmpty(artTagNms);
    	if(isEmpty){//新增文章时，没有填入标签
        	String text = StringUtil.removeHTMLLabelExe(article.getArtCont());
	        int lth = text.length();
	        int size = lth > 5000 ? 5 : (lth > 3000 ? 3 : lth > 2000 ? 2 : 2);
    		//如果没有填入标签，自动筛选出关键词
	        tagNmList = HanLP.extractKeyword(text, size);
	        tagIdList = new ArrayList<String>();
    	}else{
    		tagNmList = Arrays.asList(artTagNms.split(","));
    		//if(StringUtils.isNotEmpty(artTagIds))//如果存在id，则tagnms有数据库中已存在的数据
	        tagIdList = Arrays.asList(artTagIds.split(","));//不知是否存在的数据，id用0代替
    	}
    	//获取的关键词，填入到tk_tag表中
    	//至于该标签的引用数量，通过触发器完成
    	//还需要将将tag与art关联tk_tag_art中
    	TkTag tag = null;
    	if(isEmpty){
    		for (int i = 0, l = tagNmList.size(); i < l; i++) {
    			//需要存入数据库
    			tag = tagMapper.selectByName(tagNmList.get(i));
    			if(tag == null){
    				tag = new TkTag();
    				tag.setTagNm(tagNmList.get(i));
    				tagMapper.insertSelectiveUseGeneratedKeys(tag);
    			}
    			tagIdList.add(tag.getTagId().toString());
			}
    	} else {
	    	for (int i = 0, l = tagNmList.size(); i < l; i++) {
	    		if("0".equals(tagIdList.get(0))){//需要存入数据库
	    			tag = tagMapper.selectByName(tagNmList.get(i));
	    			if(tag == null){
	    				tag = new TkTag();
	    				tag.setTagNm(tagNmList.get(i));
	    				tagMapper.insertSelectiveUseGeneratedKeys(tag);
	    			}
	    			tagIdList.set(i, tag.getTagId().toString());
	    		}
			}
    	}
    	
    	if(isEmpty){
    		art = new TkArticle();
	        art.setId(article.getId());
	        art.setArtTagNms(StringUtils.join(tagNmList, ","));
	        art.setArtTagIds(StringUtils.join(tagIdList, ","));
	        //再修改该文章
	        articleMapper.updateByPrimaryKeySelective(art);
			System.err.println(tagNmList);
    	}
    	//插入关联数据
    	StringBuilder builder = new StringBuilder("INSERT IGNORE INTO `tk_tag_art` (`tag_id`, `art_id`) VALUES ");
    	for (int i = 0, l = tagIdList.size(); i < l; i++) {
    		if(i == l - 1)
    			builder.append("("+ tagIdList.get(i) +", "+ article.getId() +")");
    		else
    			builder.append("("+ tagIdList.get(i) +", "+ article.getId() +"),");
		}
    	//如果存在相同的tag_id与art_id则不会被插入
    	tagMapper.insertBySql(builder.toString());
    }
	
}
