package com.yh.st.web.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yh.st.base.service.UserinfoService;

/**
 * 
 * @author yh
 * @Date 2017年10月27日
 * @desc
 */
@Controller
public class LoginController {

	@Resource
	private UserinfoService userinfoService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		return "login";
	}

	/**
	 * index
	 */
	@RequestMapping("index")
	public String home() {
		return "index";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("unauth")
	public String unauthorized() {
		return "unauthorized";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(RedirectAttributes redirectAttributes) {
		// 使用权限管理工具进行用户的退出，跳出登录，给出提示信息
		SecurityUtils.getSubject().logout();
		return "redirect:/login";
	}

}
