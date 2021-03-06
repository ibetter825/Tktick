package com.tktick.bean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 合集管理员表
 * @author user
 *
 */
@Entity
@Table(name = "tk_set_keeper")
public class TkSetKeeper extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kprId;
	private Integer setId;
	private Integer userId;
	private Short kprType;
	private Short kprState;
	
	public Integer getKprId() {
		return kprId;
	}
	public void setKprId(Integer kprId) {
		this.kprId = kprId;
	}
	public Integer getSetId() {
		return setId;
	}
	public void setSetId(Integer setId) {
		this.setId = setId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Short getKprType() {
		return kprType;
	}
	public void setKprType(Short kprType) {
		this.kprType = kprType;
	}
	public Short getKprState() {
		return kprState;
	}
	public void setKprState(Short kprState) {
		this.kprState = kprState;
	}
	
}
