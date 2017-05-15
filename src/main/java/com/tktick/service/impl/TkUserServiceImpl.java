package com.tktick.service.impl;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tktick.bean.constant.AuthConstant;
import com.tktick.bean.entity.TkUser;
import com.tktick.bean.form.LoginForm;
import com.tktick.dao.TkUserDao;
import com.tktick.service.TkUserService;
import com.tktick.utils.Md5Util;
import com.tktick.utils.StringUtil;
import com.tktick.utils.WebUtil;

@Service
public class TkUserServiceImpl implements TkUserService {

	@Autowired
	private TkUserDao userDao;
	
	public TkUser getTkUserByUsername(String username) {
		return userDao.selectUserByUsername(username);
	}

	@Override
	public boolean valiLoginUser(HttpServletResponse response, LoginForm form) {
		TkUser user = null;
		boolean res = false;
		switch (form.getType()) {
			case LoginForm.LOGIN_TYPE_EMAIL:
				user = userDao.selectUserByEmail(form.getEmail());
				break;
			case LoginForm.LOGIN_TYPE_PHONE:
				user = userDao.selectUserByPhone(form.getPhonenum());
				break;
			default:
				break;
		}
		if(user != null){
			String salt = user.getUserSalt();
			String pwd = user.getUserPwd();
			if(Md5Util.md5(salt + form.getPassword()).equals(pwd)){
				user.setUserPwd(null);
				user.setUserSalt(null);
				//登录成功
				String sessionId = StringUtil.uuid(false) + "|" +user.getUserId();
				//将sessionId存放在缓存中
				WebUtil.addCookie(response, null, null, true, AuthConstant.COOKIE_SESSION_ID, sessionId, 1000);
				res = true;
			}
		}
		return res;
	}
}
