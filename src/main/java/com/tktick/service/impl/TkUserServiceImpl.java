package com.tktick.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tktick.dao.TkUserDao;
import com.tktick.model.entity.TkUser;
import com.tktick.service.TkUserService;

@Service
public class TkUserServiceImpl implements TkUserService {

	@Autowired
	private TkUserDao userDao;
	
	@Override
	public TkUser getTkUser(String username) {
		return userDao.selectUserByUsername(username);
	}

}
