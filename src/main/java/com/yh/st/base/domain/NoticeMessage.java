package com.yh.st.base.domain;

public class NoticeMessage extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1473930334476891009L;
	private long noticeId;
	private long userId;
	private int state;

	/**
	 * @return the noticeId
	 */
	public long getNoticeId() {
		return noticeId;
	}

	/**
	 * @param noticeId
	 *            the noticeId to set
	 */
	public void setNoticeId(long noticeId) {
		this.noticeId = noticeId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

}
