package com.tktick.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}
