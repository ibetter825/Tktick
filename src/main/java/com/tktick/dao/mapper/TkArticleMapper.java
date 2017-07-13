package com.tktick.dao.mapper;

import java.util.List;
import java.util.Map;
import com.tktick.bean.entity.TkArticle;
import com.tktick.dao.BaseMapper;

public interface TkArticleMapper extends BaseMapper<TkArticle> {
	/**
	 * 根据参数查询文章并设置将结果封装为map集合
	 * @param map
	 * @return
	 */
	public List<Map<?, ?>> selectListWithRq(Map<String, Object> rq);
}
