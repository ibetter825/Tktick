package com.tktick.bean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 合集表
 * @author user
 *
 */
@Entity
@Table(name = "tk_set")
public class TkSet extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer setId;
	private String setTitle;
	private Integer artNum;
	private Long addTime;
	private Long editTime;
	private String setDesc;
	private Short setState;
	
	public Integer getSetId() {
		return setId;
	}
	public void setSetId(Integer setId) {
		this.setId = setId;
	}
	public String getSetTitle() {
		return setTitle;
	}
	public void setSetTitle(String setTitle) {
		this.setTitle = setTitle;
	}
	public Integer getArtNum() {
		return artNum;
	}
	public void setArtNum(Integer artNum) {
		this.artNum = artNum;
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
	public String getSetDesc() {
		return setDesc;
	}
	public void setSetDesc(String setDesc) {
		this.setDesc = setDesc;
	}
	public Short getSetState() {
		return setState;
	}
	public void setSetState(Short setState) {
		this.setState = setState;
	}
	
}
