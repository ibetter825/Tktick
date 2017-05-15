package com.tktick.bean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 投递记录表
 * @author user
 *
 */
@Entity
@Table(name = "tk_deliver")
public class TkDeliver extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dverId;
	private Long artId;
	private Integer setId;
	private Long dverTime;
	private Short dverState;
	
	public Integer getDverId() {
		return dverId;
	}
	public void setDverId(Integer dverId) {
		this.dverId = dverId;
	}
	public Long getArtId() {
		return artId;
	}
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	public Integer getSetId() {
		return setId;
	}
	public void setSetId(Integer setId) {
		this.setId = setId;
	}
	public Long getDverTime() {
		return dverTime;
	}
	public void setDverTime(Long dverTime) {
		this.dverTime = dverTime;
	}
	public Short getDverState() {
		return dverState;
	}
	public void setDverState(Short dverState) {
		this.dverState = dverState;
	}
}
