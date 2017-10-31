package com.yh.st.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.st.base.domain.Auth;
import com.yh.st.base.service.UserinfoService;
import com.yh.st.common.result.ResultData;

/**
 * 
 * @author yh
 * @Date 2017年10月30日
 * @desc 系统设计相关(用户，权限。。。)
 */
@Controller
@RequestMapping("sys")
public class SystemController {

	@Resource
	private UserinfoService userinfoService;

	@RequestMapping("roleListView")
	public String roleListView(HttpServletRequest request) {
		return "sys/role-list";
	}

	@RequestMapping("roleListData")
	@ResponseBody
	public Object roleListData(HttpServletRequest request) {
		List<Auth> list = userinfoService.findAuthAll();
//		return new ResultData(list);
		return list;
	}
}
