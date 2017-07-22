package com.tktick.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tktick.bean.entity.TkDeliver;
import com.tktick.dao.mapper.TkDeliverMapper;
import com.tktick.service.TkDeliverService;

@Service
public class TkDeliverServiceImpl implements TkDeliverService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TkDeliverServiceImpl.class);

	@Autowired
	private TkDeliverMapper deliverMapper;

	@Override
	public boolean save(TkDeliver deliver) {
		return deliverMapper.insert(deliver) == 1;
	}

	@Override
	public boolean modify(TkDeliver deliver) {
		return deliverMapper.updateByPrimaryKey(deliver) == 1;
	}
}
