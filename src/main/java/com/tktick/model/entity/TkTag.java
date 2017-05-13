package com.tktick.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 标签表
 * @author user
 *
 */
@Entity
@Table(name = "tk_tag")
public class TkTag extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tagId;
	private String tagNm;
	private Integer artNum;
	
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getTagNm() {
		return tagNm;
	}
	public void setTagNm(String tagNm) {
		this.tagNm = tagNm;
	}
	public Integer getArtNum() {
		return artNum;
	}
	public void setArtNum(Integer artNum) {
		this.artNum = artNum;
	}
}
