package com.tktick.model.entity;

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
	private Long userId;
	private Short kprType;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Short getKprType() {
		return kprType;
	}
	public void setKprType(Short kprType) {
		this.kprType = kprType;
	}
}
