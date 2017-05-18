package com.tktick.bean.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 文章表
 * @author user
 *
 */
@Entity
@Table(name = "tk_article")
public class TkArticle extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Long artId;
	@NotBlank
	private String artTitle;
	private String artDesc;
	private TkArticleClz clz;
	private TkUser user;
	private Long addTime;
	private Long editTime;
	private Short artState;
	private Short artAuth;
	@NotBlank
	private String artCont;
	private String artImgs;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getArtId() {
		return artId;
	}
	public void setArtId(Long artId) {
		this.artId = artId;
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
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="clz_id")
	public TkArticleClz getClz() {
		return clz;
	}
	public void setClz(TkArticleClz clz) {
		this.clz = clz;
	}
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
	public TkUser getUser() {
		return user;
	}
	public void setUser(TkUser user) {
		this.user = user;
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
	public String getArtImgs() {
		return artImgs;
	}
	public void setArtImgs(String artImgs) {
		this.artImgs = artImgs;
	}
}
