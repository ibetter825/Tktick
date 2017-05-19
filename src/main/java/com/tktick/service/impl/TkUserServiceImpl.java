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
import com.tktick.dao.repository.TkUserRepository;
import com.tktick.service.TkUserService;
import com.tktick.utils.DateUtil;
import com.tktick.utils.Md5Util;
import com.tktick.utils.SecretUtil;
import com.tktick.utils.WebUtil;

@Service
public class TkUserServiceImpl implements TkUserService {

	@Autowired
	private TkUserRepository userDao;
	
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
			long time = DateUtil.getDateByTime();
			TkUserInfo info = user.getInfo();
			short ec = info.getErrCount();//登录错误次数
			if(ec >= 3){//登录出错的次数超过三次，限制登录24小时
				long stopTime = info.getStopTime();
				int stopExpires = AuthConstant.LOGIN_ERR_STOP_EXPIRES;
				long stop = stopTime + stopExpires;
				
				if(stop > time){
					res = AuthConstant.USER_LOCKED_MSG + "[" + ((stop - time) % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60) + "]小时后解锁";//账户被锁定，12小时，
					return res;
				}
			}
			String salt = user.getUserSalt();
			String pwd = user.getUserPwd();
			
			if(Md5Util.md5(form.getPassword() + salt).equals(pwd)){
				int maxAge = new Short((short) 1).equals(form.getRemember()) ? 	AuthConstant.COOKIE_VALIDITY_SECONDS : -1;//保存14天 或者 0
				Integer userId = user.getUserId();
				//修改Info信息
				info.setLoginIp(WebUtil.getIpAddr(request));
				info.setLoginTime(time);
				info.setErrCount((short) 0);
				userDao.save(user);
				
				String userLoginInfo = SecretUtil.encrypt(userId + "@" + time + "@" + maxAge + "@" + Md5Util.md5(userId + "@" + pwd + "@" + salt + "@" + time + "@" + maxAge));
				long expires = DateUtil.getDateByTime() + maxAge * 1000;
				WebUtil.addCookie(response, null, null, true, AuthConstant.COOKIE_USER_INFO, userLoginInfo, expires, maxAge);
				//登录成功
				//将sessionId存放在缓存中
				Cache cache = CacheManager.getInstance().getCache(CacheConstant.LOGIN_USER_INFO_CACHE_NAME);
				cache.put(new Element(userId, user));
			}else{
				res = AuthConstant.WRONG_LOGIN_MSG;
				ec++;
				if(ec > 3)//登录出错次数
					info.setStopTime(time);//限制登录开始时间
				else
					info.setErrCount(ec);
				userDao.save(user);
			}
		}else
			res = res == null ? AuthConstant.USER_NOT_FOUND_MSG : res;
		return res;
	}
}
