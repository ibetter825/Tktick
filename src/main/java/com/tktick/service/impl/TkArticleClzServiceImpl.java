package com.tktick.service.impl;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tktick.bean.entity.TkArticleClz;
import com.tktick.bean.rq.QueryRq;
import com.tktick.dao.mapper.TkArticleClzMapper;
import com.tktick.service.TkArticleClzService;

@Service
public class TkArticleClzServiceImpl implements TkArticleClzService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TkArticleClzServiceImpl.class);

	@Autowired
	private TkArticleClzMapper clzMapper;

	@Override
	public boolean save(TkArticleClz clz) {
		return clzMapper.insert(clz) == 1;
	}

	@Override
	public List<Map<?, ?>> queryForMapList(QueryRq rq) {
		return null;
	}
}
