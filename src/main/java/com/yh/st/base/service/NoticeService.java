package com.yh.st.base.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.Notice;

public interface NoticeService {

	/**
	 * 插入
	 * 
	 * @param notice
	 */
	void addNotice(Notice notice);

	/**
	 * 分页
	 * 
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageInfo<Notice> queryNotice(Map<String, Object> params, int pageNo, int pageSize);

	/**
	 * 发送公告
	 * 
	 * @param createUserId
	 * @param message
	 */
	void addAllUserNotice(long createUserId, String message, String title);
}
