package com.yh.st.base.domain;

import java.util.Date;

import javax.persistence.Column;

public class Userinfo extends Entity {
	private static final long serialVersionUID = 8809671435178537235L;
	@Column(name = "username")
	private String username;
	@Column(name = "realname")
	private String realname;
	@Column(name = "password")
	private String password;
	@Column(name = "sex")
	private int sex;
	@Column(name = "born")
	private Date born;
	@Column(name = "photo")
	private String photo;
	@Column(name = "type")
	private int type;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "update_time")
	private Date updateTime;
	@Column(name = "state")
	private int state;

	
	
	public Userinfo() {
		super();
	}

	
	public Userinfo(String username) {
		super();
		this.username = username;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getBorn() {
		return this.born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public static final int SEX_BOY = 1;
	public static final int SEX_GIRL = 0;

	public String getSexCN() {
		return sex == SEX_BOY ? "男" : "女";
	}

	public static final int STATE_DEL = 1;
	public static final int STATE_DISABLE = 2;
	public static final int STATE_ACTIVE = 3;

	public String getStateCN() {
		if (state == STATE_DEL) {
			return "删除";
		} else if (state == STATE_DISABLE) {
			return "禁用";
		} else {
			return "正常";
		}
	}
}
