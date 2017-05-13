package com.tktick.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 评论表
 * @author user
 *
 */
@Entity
@Table(name = "tk_comment")
public class TkComment extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comtId;
	private Long comtTime;
	private String comtCont;
	private Long userId;
	private Long artId;
	private Short comtState;
	
	public Long getComtId() {
		return comtId;
	}
	public void setComtId(Long comtId) {
		this.comtId = comtId;
	}
	public Long getComtTime() {
		return comtTime;
	}
	public void setComtTime(Long comtTime) {
		this.comtTime = comtTime;
	}
	public String getComtCont() {
		return comtCont;
	}
	public void setComtCont(String comtCont) {
		this.comtCont = comtCont;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getArtId() {
		return artId;
	}
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	public Short getComtState() {
		return comtState;
	}
	public void setComtState(Short comtState) {
		this.comtState = comtState;
	}
}
