package com.yh.st.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yh.st.base.config.shiro.ShiroService;
import com.yh.st.base.controller.BaseController;
import com.yh.st.base.domain.Userinfo;
import com.yh.st.base.service.UserinfoService;
import com.yh.st.common.result.ResultData;

/**
 * 
 * @author yh
 * @Date 2017年10月13日
 * @desc 用户相关操作(权限，信息等)
 */
@Controller
@RequestMapping(value = "user", method = { RequestMethod.POST, RequestMethod.GET })
public class UserController extends BaseController {

	@Resource
	private UserinfoService userinfoService;
	@Resource
	private ShiroService shiroService;

	/**
	 * 取用户菜单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("getUserMenu")
	@ResponseBody
	public Object getUserMenu(HttpServletRequest request) {
		return userinfoService.findMenuByUserId(1L);
	}

	/**
	 * 用户管理
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("userListView")
	public String userListView(HttpServletRequest request) {
		return "sys/user-list";
	}

	@RequestMapping("userListData")
	@ResponseBody
	public ResultData userListData(HttpServletRequest request) {
		PageInfo<Userinfo> page = userinfoService.queryUserinfo(getParams(request),
				getPageNum(request), pageSize);
		return new ResultData(page);
	}

	@Override
	protected String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

}
