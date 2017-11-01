package com.yh.st.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;

public class BaseController {
	/**
	 * 默认页数
	 */
	protected int pageSize = 20;

	public int getPageNum(HttpServletRequest request) {
		return ServletRequestUtils.getIntParameter(request, "pageNo", 1);
	}
}
