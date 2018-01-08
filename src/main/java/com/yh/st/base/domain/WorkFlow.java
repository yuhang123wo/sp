package com.yh.st.base.domain;

import java.util.Date;

public class WorkFlow extends Entity {

	private static final long serialVersionUID = -8690343417826015248L;
	private String name;
	private String source;
	private String sourceImg;
	private int state;
	private String remark;
	private Date createTime;
	private Date updateTime;
	private String wkey;

	public static final int STATE_ON = 1;

	public static final int STATE_OFF = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceImg() {
		return sourceImg;
	}

	public void setSourceImg(String sourceImg) {
		this.sourceImg = sourceImg;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getWkey() {
		return wkey;
	}

	public void setWkey(String wkey) {
		this.wkey = wkey;
	}

}
