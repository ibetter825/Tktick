package com.tktick.service.impl;

import javax.servlet.http.HttpServletResponse;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tktick.bean.constant.AuthConstant;
import com.tktick.bean.entity.TkUser;
import com.tktick.bean.form.LoginForm;
import com.tktick.dao.TkUserDao;
import com.tktick.service.TkUserService;
import com.tktick.utils.DateUtil;
import com.tktick.utils.Md5Util;
import com.tktick.utils.SecretUtil;
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
			if(Md5Util.md5(form.getPassword() + salt).equals(pwd)){
				int maxAge = 15*24*60*60;//保存15天
				long time = DateUtil.getDateByTime();
				Long userId = user.getUserId();
				
				String userLoginInfo = SecretUtil.encrypt(userId + "@" + time + "@" + maxAge + "@" + Md5Util.md5(userId + "@" + pwd + "@" + salt + "@" + time + "@" + maxAge));
				WebUtil.addCookie(response, null, null, true, AuthConstant.COOKIE_USER_INFO, userLoginInfo, maxAge);
				//登录成功
				//将sessionId存放在缓存中
				Cache cache = CacheManager.getInstance().getCache("session");
				cache.put(new Element(userId, user));
				res = true;
			}
		}
		return res;
	}
}
