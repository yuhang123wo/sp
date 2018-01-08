package com.yh.st.base.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.yh.st.base.domain.Entity;
import com.yh.st.base.service.BaseService;
import com.yh.st.common.result.ResultData;
import com.yh.st.common.util.StringUtil;

public abstract class BaseController<T extends Entity> {
	/**
	 * 默认页数
	 */
	protected int pageSize = 20;
	@Resource
	protected BaseService<T> baseService;

	protected abstract String getPrefix();

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

	/**
	 * list页面跳转
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 *             String
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listPost(HttpServletRequest request) {
		return getPrefix() + "list";
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 *             String
	 */
	@RequestMapping(value = "listData", method = RequestMethod.GET)
	@ResponseBody
	public ResultData listData(HttpServletRequest request) {
		return new ResultData(baseService.queryPageByParmas(getParams(request),
				getPageNum(request), pageSize));
	}

}
