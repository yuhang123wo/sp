package com.yh.st.base.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.util.WebUtils;

import com.yh.st.common.util.StringUtil;

public class BaseController {
	/**
	 * 默认页数
	 */
	protected int pageSize = 20;

	protected int getPageNum(HttpServletRequest request) {
		return ServletRequestUtils.getIntParameter(request, "pageNo", 1);
	}

	/**
	 * 获取所有参数
	 * 
	 * @param request
	 * @return
	 */
	protected Map<String, Object> getParams(HttpServletRequest request) {
		Map<String, Object> params = WebUtils.getParametersStartingWith(request, "");
		if (params == null)
			return new HashMap<String, Object>();
		Iterator<Entry<String, Object>> iter = params.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Object> entry = iter.next();
			String key = entry.getKey();
			if (key.endsWith("_like")) {
				// 模糊匹配
				params.remove(key);
				params.put(key.replace("_like", ""), StringUtil.objAddLike(entry.getValue()));
			}
			if (key.endsWith("startTime")) {
				params.put(key, StringUtil.addStartTime(entry.getValue()));
			}
			if (key.endsWith("endTime")) {
				params.put(key, StringUtil.addEndTime(entry.getValue()));
			}
		}
		return params;
	}
}
