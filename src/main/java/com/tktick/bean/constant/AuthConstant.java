package com.tktick.bean.constant;

public class AuthConstant {
	/**
	 * cookie中的sessionid名
	 */
	public final static String COOKIE_SESSION_ID = "TKSESSIONID";
	/**
	 * 解密cookie时使用的默认字符串
	 */
	public final static String COOKIE_SESSION_ID_SALT = "TKTICK";
	/**
	 * cookie的有效期
	 */
	public final static int COOKIE_VALIDITY_SECONDS = 1209600;//14天
	/**
	 * 登录成功后存默认跳转页面
	 */
	public final static String LOGIN_SUCCESS_DEFAULT_TARGET_URL = "/";
	/**
	 * 登录失败后默认跳转的页面
	 */
	public final static String LOGIN_FAILURE_DEFAULT_TARGET_URL = "/sign/in.html";
	/**
	 * 登出URL地址
	 */
	public final static String LOGOUT_PAGE_URL = "/sign/out.html";
	/**
	 * 用户名不存在
	 */
	public final static String USER_NOT_FOUND_MSG = "用户不存在";
	/**
	 * 需要登录
	 */
	public final static String USER_NOT_LOGIN = "请先登录";
	/**
	 * 密码错误
	 */
	public final static String WRONG_PASSWORD_MSG = "用户名或者密码错误";
	/**
	 * 账户被锁
	 */
	public final static String USER_LOCKED_MSG = "账户已被锁定";
	/**
	 * 账户被禁用
	 */
	public final static String USER_DISABLED_MSG = "账户被禁用";
	/**
	 * 密码过期
	 */
	public final static String TIME_OUT_PASSWORD_MSG = "密码过期";
	/**
	 * 登录过期
	 */
	public final static String TIME_OUT_SESSION_MSG = "登录过期";
	/**
	 * 验证码错误
	 */
	public final static String WRONG_CAPTCHA_MSG = "验证码错误";
}
