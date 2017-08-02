package com.tktick.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.tktick.bean.entity.TkHome;
import com.tktick.bean.rq.QueryRq;
import com.tktick.dao.mapper.TkHomeMapper;
import com.tktick.service.TkHomeService;

@Service
public class TkHomeServiceImpl implements TkHomeService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TkHomeServiceImpl.class);

	@Autowired
	private TkHomeMapper homeMapper;

	@Override
	public boolean save(TkHome home) {
		return homeMapper.insert(home) == 1;
	}

	@Override
	public List<Map<?, ?>> queryListForMap(QueryRq rq) {
		return homeMapper.selectListForMapByRq(rq.getQrq());
	}

	@Override
	public Map<String, List<TkHome>> queryHomeCont() {
		List<TkHome> list = homeMapper.selectList();
		Map<String, List<TkHome>> res = Maps.newHashMap();
		String htype = null;
		List<TkHome> homes = null;
		for (TkHome home : list) {
			htype = home.getHmType();
			if(res.containsKey(htype)){
				res.get(htype).add(home);
			}else{
				homes = new ArrayList<>();
				homes.add(home);
				res.put(htype, homes);
			}
		}
		return res;
	}
}
