package com.tktick.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tktick.bean.constant.CacheConstant;
import com.tktick.bean.entity.TkDict;
import com.tktick.bean.model.TreeModel;
import com.tktick.bean.rq.QueryRq;
import com.tktick.dao.mapper.TkDictMapper;
import com.tktick.service.TkDictService;

@Service
public class TkDictServiceImpl implements TkDictService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TkDictServiceImpl.class);

	@Autowired
	private TkDictMapper dictMapper;
	
	@Override
	public boolean save(TkDict dict) {
		return dictMapper.insert(dict) == 1;
	}

	@Override
	public List<Map<?, ?>> queryForMapList(QueryRq rq) {
		return dictMapper.selectListByRq(rq.getQrq());
	}

	@Override
	@Cacheable(value = CacheConstant.DICT_DATA_CACHE_NAME, key = "'FNO_'+#fno")
	public List<TreeModel> queryForTreeListByFno(String fno) {
		List<TkDict> dicts = dictMapper.selectListByFno(fno);
		return TkDict.listToTree(dicts, fno);
	}
	
}
