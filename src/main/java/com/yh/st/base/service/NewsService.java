package com.yh.st.base.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.News;

public interface NewsService {
	/**
	 * 
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageInfo<News> queryNews(Map<String, Object> params, int pageNo, int pageSize);

	/**
	 * 
	 * @param news
	 * @return
	 */
	int addNews(News news);
}
