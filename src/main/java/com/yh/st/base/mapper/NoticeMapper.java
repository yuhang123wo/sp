package com.yh.st.base.mapper;

import java.util.List;
import java.util.Map;

import com.github.abel533.mapper.Mapper;
import com.yh.st.base.domain.Notice;

public interface NoticeMapper extends Mapper<Notice> {

	List<Notice> findNoticeByParams(Map<String, Object> params);
}
