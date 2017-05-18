package com.tktick.bean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文章分类表
 * @author user
 *
 */
@Entity
@Table(name = "tk_article_clz")
public class TkArticleClz extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	private Integer clzId;
	private Integer userId;
	private String clzNm;
	private Short clzState;
	private Integer clzSeq;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getClzId() {
		return clzId;
	}
	public void setClzId(Integer clzId) {
		this.clzId = clzId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getClzNm() {
		return clzNm;
	}
	public void setClzNm(String clzNm) {
		this.clzNm = clzNm;
	}
	public Short getClzState() {
		return clzState;
	}
	public void setClzState(Short clzState) {
		this.clzState = clzState;
	}
	public Integer getClzSeq() {
		return clzSeq;
	}
	public void setClzSeq(Integer clzSeq) {
		this.clzSeq = clzSeq;
	}
}
