package com.tktick.bean.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 投递记录表
 * @author user
 *
 */
@Entity
@Table(name = "tk_tag_art")
public class TkTagArt extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Integer tagId;
	private Integer artId;
	
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public Integer getArtId() {
		return artId;
	}
	public void setArtId(Integer artId) {
		this.artId = artId;
	}
}
