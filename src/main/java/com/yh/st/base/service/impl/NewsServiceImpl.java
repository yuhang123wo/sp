package com.yh.st.base.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.News;
import com.yh.st.base.mapper.NewsMapper;
import com.yh.st.base.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Resource
	private NewsMapper newsMapper;

	@Override
	public PageInfo<News> queryNews(Map<String, Object> params, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		Example example = new Example(News.class);
		List<News> list = newsMapper.selectByExample(example);
		return new PageInfo<News>(list);
	}

	@Override
	public int addNews(News news) {
		news.setCreateTime(new Date());
		return newsMapper.insert(news);
	}
}
