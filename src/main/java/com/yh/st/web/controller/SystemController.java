package com.yh.st.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.st.base.controller.BaseController;
import com.yh.st.base.domain.Auth;
import com.yh.st.base.service.UserinfoService;
import com.yh.st.common.util.ZnodesUtil;

/**
 * 
 * @author yh
 * @Date 2017年10月30日
 * @desc 系统设计相关(用户，权限。。。)
 */
@Controller
@RequestMapping("sys")
public class SystemController extends BaseController {

	@Resource
	private UserinfoService userinfoService;

	@RequestMapping("roleListView")
	public String roleListView(HttpServletRequest request) {
		return "sys/role-list";
	}

	/**
	 * 角色信息列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("roleListData")
	@ResponseBody
	public Object roleListData(HttpServletRequest request) {
		return userinfoService.queryRole(getParams(request), getPageNum(request), pageSize);
	}

	/**
	 * 角色编辑权限
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("editRoleAuth/{roleId}")
	public String editRoleAuth(@PathVariable("roleId") long roleId, Model model) {
		List<Auth> list = userinfoService.findAuthAll();
		List<Long> listRole = userinfoService.listAuthByRoleId(roleId);
		model.addAttribute("roleId", roleId);
		model.addAttribute("authList", ZnodesUtil.createZnodes(list,listRole));
		return "sys/role-edit";
	}

}
