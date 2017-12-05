package com.yh.st.web.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yh.st.base.service.NewsService;
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
	@Resource
	private NewsService newsService;

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
	public String home(Model model) {
		model.addAttribute("newList", newsService.queryNews(new HashMap<String, Object>(), 1, 10).getList());
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
