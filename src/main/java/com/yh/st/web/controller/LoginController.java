package com.yh.st.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yh.st.base.service.UserinfoService;
import com.yh.st.base.vo.MenuVo;
import com.yh.st.common.util.MenuTool;

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
	public String home(Model model) {
		List<MenuVo> list = MenuTool.getMenu(userinfoService.findAuthAll());
		model.addAttribute("menuList", list);
		return "index";
	}
}
