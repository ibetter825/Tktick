package com.tktick.bean.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 用户
 * onetoone共享主键
 * http://blog.csdn.net/cao_j/article/details/18217147
 * @author user
 *
 */
@Entity
@Table(name = "tk_user")
public class TkUser extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String userName;
	private String userPwd;
	private String userSalt;
	private Long userPhone;
	private String userEmail;
	private Short userState;
	private TkUserInfo info;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserSalt() {
		return userSalt;
	}
	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}
	public Long getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Short getUserState() {
		return userState;
	}
	public void setUserState(Short userState) {
		this.userState = userState;
	}
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn
	public TkUserInfo getInfo() {
		return info;
	}
	public void setInfo(TkUserInfo info) {
		this.info = info;
	}
}
