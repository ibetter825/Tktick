package com.tktick.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.tktick.bean.constant.AuthConstant;
import com.tktick.bean.constant.CacheConstant;
import com.tktick.bean.entity.TkUser;
import com.tktick.bean.entity.TkUserInfo;
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
	@Cacheable(value = CacheConstant.LOGIN_USER_INFO_CACHE_NAME, key="#userId")
	public TkUser getTkUserById(Integer userId) {
		System.err.println("without cache");
		return userDao.findOne(userId);
	}
	
	@Override
	public String valiLoginUser(HttpServletRequest request, HttpServletResponse response, LoginForm form) {
		//判断验证码是否出错
		String captchaString = WebUtil.getCookieValueByName(request, AuthConstant.COOKIE_CAPTCHA_NAME);
		if(!Md5Util.md5(form.getCaptcha().toUpperCase() + AuthConstant.COOKIE_CAPTCHA_SALT).equals(captchaString))
			return AuthConstant.WRONG_CAPTCHA_MSG;//验证码不对
		WebUtil.addCookie(response, null, AuthConstant.COOKIE_CAPTCHA_PATH, true, AuthConstant.COOKIE_CAPTCHA_NAME, null, 0);
		String res = null;
		TkUser user = null;
		switch (form.getType()) {
			case LoginForm.LOGIN_TYPE_EMAIL:
				user = userDao.selectUserByEmail(form.getEmail());
				break;
			case LoginForm.LOGIN_TYPE_PHONE:
				user = userDao.selectUserByPhone(form.getPhonenum());
				break;
			default:
				res = AuthConstant.WRONG_USER_ACCOUNT_MSG;
				break;
		}
		if(user != null){
			String salt = user.getUserSalt();
			String pwd = user.getUserPwd();
			if(Md5Util.md5(form.getPassword() + salt).equals(pwd)){
				int maxAge = new Short((short) 1).equals(form.getRemember()) ? 	AuthConstant.COOKIE_VALIDITY_SECONDS : -1;//保存14天 或者 0
				long time = DateUtil.getDateByTime();
				Integer userId = user.getUserId();
				//修改Info信息
				TkUserInfo info = user.getInfo();
				info.setLoginIp(WebUtil.getIpAddr(request));
				info.setLoginTime(time);
				userDao.save(user);
				
				String userLoginInfo = SecretUtil.encrypt(userId + "@" + time + "@" + maxAge + "@" + Md5Util.md5(userId + "@" + pwd + "@" + salt + "@" + time + "@" + maxAge));
				long expires = DateUtil.getDateByTime() + maxAge * 1000;
				WebUtil.addCookie(response, null, null, true, AuthConstant.COOKIE_USER_INFO, userLoginInfo, expires, maxAge);
				//登录成功
				//将sessionId存放在缓存中
				Cache cache = CacheManager.getInstance().getCache(CacheConstant.LOGIN_USER_INFO_CACHE_NAME);
				cache.put(new Element(userId, user));
			}else
				res = AuthConstant.WRONG_LOGIN_MSG;
		}else
			res = res == null ? AuthConstant.USER_NOT_FOUND_MSG : res;
		return res;
	}
}
