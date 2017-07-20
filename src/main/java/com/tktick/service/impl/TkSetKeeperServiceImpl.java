package com.tktick.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tktick.bean.entity.TkSetKeeper;
import com.tktick.dao.mapper.TkSetKeeperMapper;
import com.tktick.service.TkSetKeeperService;

@Service
public class TkSetKeeperServiceImpl implements TkSetKeeperService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TkSetKeeperServiceImpl.class);

	@Autowired
	private TkSetKeeperMapper keeperMapper;

	@Override
	public boolean saveKeeper(TkSetKeeper keeper) {
		return keeperMapper.insert(keeper) == 1;
	}

	@Override
	public TkSetKeeper queryKeeper(TkSetKeeper keeper) {
		return keeperMapper.selectOne(keeper);
	}

}
