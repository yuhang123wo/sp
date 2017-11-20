package com.yh.st.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
