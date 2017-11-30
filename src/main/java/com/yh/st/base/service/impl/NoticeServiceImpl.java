package com.yh.st.base.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.Notice;
import com.yh.st.base.mapper.NoticeMapper;
import com.yh.st.base.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeMapper noticeMapper;

	@Transactional
	@Override
	public void addNotice(Notice notice) {
		noticeMapper.insert(notice);
	}

	@Override
	public PageInfo<Notice> queryNotice(Map<String, Object> params, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<Notice> list = noticeMapper.findNoticeByParams(params);
		return new PageInfo<Notice>(list);
	}

}
