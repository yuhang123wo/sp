package com.yh.st.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.st.base.controller.BaseController;
import com.yh.st.base.service.NoticeService;

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
		return noticeService.queryNotice(getParams(request), getPageNum(request), pageSize);
	}

	/**
	 * 取未读消息数量
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("messageNum")
	@ResponseBody
	public Object messageNum(long userId) {
		return noticeService.countMessageNumByUserId(userId);
	}

}
