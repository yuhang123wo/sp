package com.yh.st.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yh.st.base.controller.BaseController;
import com.yh.st.base.domain.Notice;
import com.yh.st.base.mapper.NoticeMapper;
import com.yh.st.base.service.NoticeService;
import com.yh.st.common.result.ResultData;

/**
 * 我的工作台
 * 
 * @author yh
 * @Date 2017年11月28日
 * @desc
 */
@Controller
@RequestMapping("work")
public class WorkController extends BaseController {

	@Resource
	private NoticeService noticeService;

	/**
	 * 公告列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("noticeListView")
	public String noticeList() {
		return "work/notice-list";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("noticeListData")
	@ResponseBody
	public Object noticeListData(HttpServletRequest request) {
		return noticeService.queryNotice(getParams(request), getPageNum(request),
				pageSize);
	}

}
