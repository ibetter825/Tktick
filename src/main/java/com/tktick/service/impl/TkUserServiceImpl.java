package com.tktick.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tktick.dao.TkUserDao;
import com.tktick.model.entity.TkUser;
import com.tktick.model.form.LoginForm;
import com.tktick.service.TkUserService;
import com.tktick.utils.Md5Util;

@Service
public class TkUserServiceImpl implements TkUserService {

	@Autowired
	private TkUserDao userDao;
	
	public TkUser getTkUserByUsername(String username) {
		return userDao.selectUserByUsername(username);
	}

	@Override
	public TkUser valiLoginUser(LoginForm form) {
		TkUser user = null;
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
			}
		}
		return user;
	}
}
