package com.tktick.bean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 首页数据
 * @author user
 *
 */
@Entity
@Table(name = "tk_home")
public class TkHome extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hmId;
	private String hmType;
	private String hmTitle;
	private String hmImg;
	private String hmUrl;
	private Integer hmSeq;
	private Short hmState;
	private String hmPar;
	public Integer getHmId() {
		return hmId;
	}
	public void setHmId(Integer hmId) {
		this.hmId = hmId;
	}
	public String getHmType() {
		return hmType;
	}
	public void setHmType(String hmType) {
		this.hmType = hmType;
	}
	public String getHmTitle() {
		return hmTitle;
	}
	public void setHmTitle(String hmTitle) {
		this.hmTitle = hmTitle;
	}
	public String getHmImg() {
		return hmImg;
	}
	public void setHmImg(String hmImg) {
		this.hmImg = hmImg;
	}
	public String getHmUrl() {
		return hmUrl;
	}
	public void setHmUrl(String hmUrl) {
		this.hmUrl = hmUrl;
	}
	public Integer getHmSeq() {
		return hmSeq;
	}
	public void setHmSeq(Integer hmSeq) {
		this.hmSeq = hmSeq;
	}
	public Short getHmState() {
		return hmState;
	}
	public void setHmState(Short hmState) {
		this.hmState = hmState;
	}
	public String getHmPar() {
		return hmPar;
	}
	public void setHmPar(String hmPar) {
		this.hmPar = hmPar;
	}
}
