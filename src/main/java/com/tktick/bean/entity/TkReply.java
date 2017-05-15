package com.tktick.bean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 回复表
 * @author user
 *
 */
@Entity
@Table(name = "tk_reply")
public class TkReply extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long replyId;
	private Long replyTime;
	private String replyCont;
	private Long comtId;
	private Long userId;
	private Short replyState;
	
	public Long getReplyId() {
		return replyId;
	}
	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}
	public Long getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Long replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyCont() {
		return replyCont;
	}
	public void setReplyCont(String replyCont) {
		this.replyCont = replyCont;
	}
	public Long getComtId() {
		return comtId;
	}
	public void setComtId(Long comtId) {
		this.comtId = comtId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Short getReplyState() {
		return replyState;
	}
	public void setReplyState(Short replyState) {
		this.replyState = replyState;
	}
}
