package com.yh.st.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.st.base.domain.Notice;
import com.yh.st.base.domain.NoticeMessage;
import com.yh.st.base.domain.State;
import com.yh.st.base.domain.Userinfo;
import com.yh.st.base.mapper.NoticeMapper;
import com.yh.st.base.mapper.NoticeMessageMapper;
import com.yh.st.base.mapper.UserinfoMapper;
import com.yh.st.base.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeMapper noticeMapper;
	@Resource
	private UserinfoMapper userinfoMapper;
	@Resource
	private NoticeMessageMapper noticeMessageMapper;

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

	@Transactional
	@Override
	public void addAllUserNotice(long createUserId, String message, String title) {
		Userinfo u = userinfoMapper.selectByPrimaryKey(createUserId);
		Notice notice = new Notice();
		notice.setCeateUserName(u.getUsername());
		notice.setContent(message);
		notice.setCreateUserId(createUserId);
		notice.setState(State.STATE_ON);
		notice.setTitle(title);
		notice.setType(Notice.TYPE_ALL);
		noticeMapper.insert(notice);
		// 存关联
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", State.STATE_ON);
		List<Userinfo> list = userinfoMapper.findUserinfoByParams(params);
		for (int i = 0; i < list.size(); i++) {
			NoticeMessage m = new NoticeMessage();
			m.setNoticeId(notice.getId());
			m.setState(State.STATE_ON);
			m.setUserId(list.get(i).getId());
			noticeMessageMapper.insert(m);
		}
	}

}
