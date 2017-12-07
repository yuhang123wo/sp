package com.yh.st.base.domain;

import java.util.Date;

import com.yh.st.common.util.poi.ModelProp;
import com.yh.st.common.util.poi.ModelTitle;

/**
 *
 * This class was generated by MyBatis Generator. This class corresponds to the
 * database table news
 *
 * @mbggenerated do_not_delete_during_merge
 */

@ModelTitle(name = "excel测试")
public class News extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4023204579540488171L;

	/**
	 * Database Column Remarks: 新闻类型
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column news.type
	 *
	 * @mbggenerated
	 */
	@ModelProp(name = "类型", colIndex = 0, nullable = false)
	private int type;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column news.title
	 *
	 * @mbggenerated
	 */
	@ModelProp(name = "标题", colIndex = 1, nullable = false)
	private String title;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column news.url
	 *
	 * @mbggenerated
	 */
	@ModelProp(name = "url", colIndex = 2, nullable = false)
	private String url;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column news.create_time
	 *
	 * @mbggenerated
	 */
	@ModelProp(name = "时间", colIndex = 3, nullable = false)
	private Date createTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column news.type
	 *
	 * @return the value of news.type
	 *
	 * @mbggenerated
	 */
	public int getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column news.type
	 *
	 * @param type
	 *            the value for news.type
	 *
	 * @mbggenerated
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column news.title
	 *
	 * @return the value of news.title
	 *
	 * @mbggenerated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column news.title
	 *
	 * @param title
	 *            the value for news.title
	 *
	 * @mbggenerated
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column news.url
	 *
	 * @return the value of news.url
	 *
	 * @mbggenerated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column news.url
	 *
	 * @param url
	 *            the value for news.url
	 *
	 * @mbggenerated
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column news.create_time
	 *
	 * @return the value of news.create_time
	 *
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column news.create_time
	 *
	 * @param createTime
	 *            the value for news.create_time
	 *
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}