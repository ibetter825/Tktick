package com.tktick.bean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文章表
 * @author user
 *
 */
@Entity
@Table(name = "tk_article")
public class TkArticle extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@NotBlank
	private String artTitle;
	private String artDesc;
	private Integer clzId;
	private Integer userId;
	private Long addTime;
	private Long editTime;
	private Short artState;
	private Short artAuth;
	//@NotBlank
	private String artCont;
	private String artTags;
	private String artImgs;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArtTitle() {
		return artTitle;
	}
	public void setArtTitle(String artTitle) {
		this.artTitle = artTitle;
	}
	public String getArtDesc() {
		return artDesc;
	}
	public void setArtDesc(String artDesc) {
		this.artDesc = artDesc;
	}
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
	public Long getAddTime() {
		return addTime;
	}
	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}
	public Long getEditTime() {
		return editTime;
	}
	public void setEditTime(Long editTime) {
		this.editTime = editTime;
	}
	public Short getArtState() {
		return artState;
	}
	public void setArtState(Short artState) {
		this.artState = artState;
	}
	public Short getArtAuth() {
		return artAuth;
	}
	public void setArtAuth(Short artAuth) {
		this.artAuth = artAuth;
	}
	public String getArtCont() {
		return artCont;
	}
	public void setArtCont(String artCont) {
		this.artCont = artCont;
	}
	public String getArtTags() {
		return artTags;
	}
	public void setArtTags(String artTags) {
		this.artTags = artTags;
	}
	public String getArtImgs() {
		return artImgs;
	}
	public void setArtImgs(String artImgs) {
		this.artImgs = artImgs;
	}
}
