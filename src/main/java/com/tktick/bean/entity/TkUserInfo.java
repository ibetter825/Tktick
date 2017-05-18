package com.tktick.bean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 用户
 * @author user
 *
 */
@Entity
@Table(name = "tk_user_info")
public class TkUserInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String userAvatar;
	private String userIntro;
	private String nickName;
	private Short userSex;
	private Long loginTime;
	private String loginIp;
	private Long regTime;
	private Short errCount;
	private Long stopTime;
	private TkUser user;
	
	@Id
	@GeneratedValue(generator = "pkGenerator")
	@GenericGenerator(name = "pkGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Short getUserSex() {
		return userSex;
	}
	public void setUserSex(Short userSex) {
		this.userSex = userSex;
	}
	public Long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Long getRegTime() {
		return regTime;
	}
	public void setRegTime(Long regTime) {
		this.regTime = regTime;
	}
	public Short getErrCount() {
		return errCount;
	}
	public void setErrCount(Short errCount) {
		this.errCount = errCount;
	}
	public Long getStopTime() {
		return stopTime;
	}
	public void setStopTime(Long stopTime) {
		this.stopTime = stopTime;
	}
	@OneToOne(mappedBy="info", optional=false)
	public TkUser getUser() {
		return user;
	}
	public void setUser(TkUser user) {
		this.user = user;
	}
}
