package com.tktick.bean.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.tktick.utils.RegexUtil;

/**
 * 登录表单对象
 * @author user
 *
 */
public class LoginForm extends BaseForm{
	private static final long serialVersionUID = 1L;
	
	public static final short LOGIN_TYPE_PHONE = 1;
	public static final short LOGIN_TYPE_EMAIL = 2;
	
	@NotEmpty
	private String account;//登录表单中的字段，需要判断是电话号还是电子邮箱
	private String username;//用户名
	private Integer phonenum;//手机号码
	@Email
	private String email;//电子邮箱
	private String password;//登录密码
	private String captcha;//验证码
	private Short remember;//记住我
	private short type;//登录类型
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		//判断登录账号类型
		//手机号
		//电子邮箱
		if(RegexUtil.isEmail(account)){
			this.email = account;
			this.type = LOGIN_TYPE_EMAIL;
		}
		this.account = account;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(Integer phonenum) {
		this.phonenum = phonenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public Short getRemember() {
		return remember;
	}
	public void setRemember(Short remember) {
		this.remember = remember;
	}
	public short getType() {
		return type;
	}
	public void setType(short type) {
		this.type = type;
	}
}
