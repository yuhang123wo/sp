package com.yh.st.base.domain;

import java.util.Date;

import javax.persistence.Column;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2017-11-29 11:22:24
 */
public class Notice extends Entity {

	private static final long serialVersionUID = 4238028428852895687L;
	@Column(name = "type")
	private int type;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "create_user_id")
	private long createUserId;
	@Column(name = "ceate_user_name")
	private String ceateUserName;
	@Column(name = "state")
	private int state;

	public static int TYPE_ALL = 1;
	public static int TYPE_PERSON = 2;

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}

	public String getCeateUserName() {
		return this.ceateUserName;
	}

	public void setCeateUserName(String ceateUserName) {
		this.ceateUserName = ceateUserName;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
